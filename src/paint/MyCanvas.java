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
    ArrayList<Class<? extends Shape>> supportedShapes;
    
    private int squareX = 50;
    private int squareY = 50;
    private int squareW = 20;
    private int squareH = 20;

    public MyCanvas() {
        
        shapes= new ArrayList<>();
        unDoneShapes= new ArrayList<>();        
        setBorder(BorderFactory.createLineBorder(Color.black));
        supportedShapes=new ArrayList<>();
        supportedShapes.add(Rectangle.class);
        supportedShapes.add(Circle.class);
        supportedShapes.add(Triangle.class);
        supportedShapes.add(Line.class);
        supportedShapes.add(Square.class);
        supportedShapes.add(Oval.class);
        
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
        return supportedShapes;
    }

    @Override
    public void installPluginShape(Class<? extends Shape> shapeClass) {
        supportedShapes.add(shapeClass);
    }

    @Override
    public void undo() {
        if(unDoneShapes.size()>=20) unDoneShapes.remove(0);
        unDoneShapes.add(shapes.remove(shapes.size()-1));
        this.repaint();
    }

    @Override
    public void redo() 
    {        
        shapes.add(unDoneShapes.remove(unDoneShapes.size()-1));
        this.repaint();
    }
    
    
}
