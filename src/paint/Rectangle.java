/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
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
public class Rectangle extends myShape implements Shape {
    
    int width;
    int height;
    
    public Rectangle(myShape shape){
        Rectangle s=(Rectangle)shape;
        x=s.x;
        y=s.y;
        color=s.color;
        width=s.width;
        height=s.height;    
        int result;
        
    }
    
    public Rectangle(){   
        Random rand=new Random();
        x= rand.nextInt(100);
        y=rand.nextInt(100);
        color=Color.RED;        
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
        myPanel.add(new JLabel("Length: "));
        myPanel.add(lengthField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Width: "));
        myPanel.add(widthField);
        result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if(result==JOptionPane.OK_OPTION){
            width=Integer.parseInt(widthField.getText());
            height=Integer.parseInt(lengthField.getText());
            x=Integer.parseInt(xField.getText());
            y=Integer.parseInt(yField.getText());
        }
        
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
        canvas.setColor(this.color);
        canvas.drawRect(x,y,width,height);        
        canvas.fillRect(x,y,width,height);
        /*canvas.setColor(color);        
        canvas.drawRoundRect(x,y,width,height,5,5);
        canvas.fillRoundRect(x,y,width,height,5,5);*/
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Rectangle shape= new Rectangle(this);
        shape.x+=10;
        shape.y+=10;      
        
        return shape;
    }
    
}
