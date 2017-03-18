package paint;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP-
 */
public class MyCanvas extends JPanel implements DrawingEngine{
    ArrayList<Shape> shapes;
    ArrayList<Shape> unDoneShapes;
    
    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 20;
    private int squareH = 20;

    public MyCanvas() {
        
        shapes= new ArrayList<>();
        unDoneShapes= new ArrayList<>();        
        setBorder(BorderFactory.createLineBorder(Color.black));
        
    }  
    public MyCanvas(MyCanvas oldCanvas) {
        
        shapes= new ArrayList<>();
        setBorder(BorderFactory.createLineBorder(Color.black));
        
    }

    
    public static void main(String[] args){
      
      MyCanvas  awtGraphicsDemo = new MyCanvas();  
      awtGraphicsDemo.setVisible(true);
      awtGraphicsDemo.shapes= new ArrayList<>();
   }
    @Override
    public void paintComponent(Graphics g)
    {
        //shape.draw();
        super.paintComponent(g);
        for(Shape s: shapes){
            s.draw(g);
        }
         /*Rectangle r = new Rectangle();
         Circle c = new Circle();
         c.setColor(Color.BLUE);
         r.draw(g);
         c.draw(g);*/
    }
    @Override
    public void addShape(Shape shape){
        shapes.add(shape);
        this.repaint();
        
    }

    @Override
    public void removeShape(Shape shape) {
        /*for(int i=0;i<shapes.size();i++){
            if(shapes.get(i).getPosition()!=shape.getPosition()) continue;
            if(shapes.get(i).getProperties().size()!=shape.getProperties().size()) continue;
            if(shapes.get(i).getColor()!=shape.getColor()) continue;
            shapes.r(i);
                   
        }*/
        shapes.remove(shape);
        this.repaint(); 
    }

    @Override
    public Shape[] getShapes() {        
        return shapes.toArray(new Shape[shapes.size()]);
    }

    @Override
    public void refresh(Graphics canvas) {
        this.repaint();
    }

    @Override
    public List<Class<? extends Shape>> getSupportedShapes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void installPluginShape(Class<? extends Shape> shapeClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        unDoneShapes.add(shapes.remove(shapes.size()-1));
        this.repaint();
    }

    @Override
    public void redo() {
        
        shapes.add(unDoneShapes.remove(unDoneShapes.size()-1));
        this.repaint();
    }
    
    
}
