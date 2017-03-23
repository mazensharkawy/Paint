/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author HP-
 */
public class Triangle extends myShape implements Shape {    
    int width;
    int height;
    
    public Triangle(myShape shape){
        Triangle s=(Triangle)shape;
        x=s.x;
        y=s.y;
        color=s.color;
        width=s.width;
        height=s.height;        
        
    }
    
    public Triangle(){
        Random rand=new Random();
        x= rand.nextInt(100);
        y=rand.nextInt(100)+20;
        /*color=Color.RED;
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField lengthField = new JTextField(5);
        JTextField widthField = new JTextField(5);
        lengthField.setText("50");
        widthField.setText("100");
        xField.setText(""+x);
        yField.setText(""+y);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("x:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer 
        myPanel.add(new JLabel("y:"));
        myPanel.add(yField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Height: "));
        myPanel.add(lengthField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Base: "));
        myPanel.add(widthField);
        result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if(result==JOptionPane.OK_OPTION){
            width=Integer.parseInt(widthField.getText());
            height=Integer.parseInt(lengthField.getText());
            x=Integer.parseInt(xField.getText());
            y=Integer.parseInt(yField.getText());
        }*/
    }
    
   
    @Override
    public void setProperties(Map<String, Double> properties) {       
        width=properties.get("width").intValue();
        height=properties.get("height").intValue();
    }

    @Override
    public Map<String, Double> getProperties() {
        HashMap<String, Double> properties = new HashMap<>();         
         properties.put("width",((double)width));
         properties.put("height",((double)height));       

         return properties;
    }


    @Override
    public void draw(Graphics canvas) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Point location = new Point(x,y);
        Point point2 = new Point(location.x+width,location.y);
        Point point3 = new Point(location.x+(width/2),location.y - height);
        canvas.setColor(this.color);
        /*canvas.setColor(Color.BLUE);
        canvas.drawLine(location.x,location.y,point2.x,point2.y);
        canvas.drawLine(location.x,location.y,point3.x,point3.y);
        canvas.drawLine(point2.x,point2.y,point3.x,point3.y);*/
        int[] intx={location.x,point2.x,point3.x};
        int[] inty={location.y,point2.y,point3.y};
        canvas.drawPolygon(intx,inty , 3);
        canvas.fillPolygon(intx,inty , 3);

    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Triangle shape= new Triangle(this);
         shape.x+=10;
        shape.y+=10; 
        
        return shape;
    }
    
}
