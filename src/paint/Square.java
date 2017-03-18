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
public class Square extends myShape implements Shape {   
    
    int sideLength;
    
     public Square(myShape shape){
        Square s=(Square)shape;
        x=s.x;
        y=s.y;
        color=s.color;
        sideLength=s.sideLength;
        
    }
    
    public Square(){        
        Random rand=new Random();
        x= rand.nextInt(100);
        y=rand.nextInt(100);
        color=Color.RED;        
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField sideLengthField = new JTextField(5);
        
        sideLengthField.setText(""+defaultLength());
        
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
        myPanel.add(sideLengthField);
        
        result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if(result==JOptionPane.OK_OPTION){            
            sideLength=Integer.parseInt(sideLengthField.getText());
            x=Integer.parseInt(xField.getText());
            y=Integer.parseInt(yField.getText());
        }
        
    }
    
   

    @Override
    public void setProperties(Map<String, Double> properties) {
        x=properties.get("x").intValue();
        y=properties.get("y").intValue();
        sideLength=properties.get("sideLength").intValue();
        
    }

    @Override
    public Map<String, Double> getProperties() {
        HashMap<String, Double> properties = new HashMap<>();
         properties.put("x",((double)x));
         properties.put("y",((double)y));
         properties.put("sideLength",((double)sideLength));
                

         return properties;
    }

    @Override
    public void draw(Graphics canvas) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        canvas.setColor(this.color);
        canvas.drawRect(x,y,sideLength,sideLength);        
        canvas.fillRect(x,y,sideLength,sideLength);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Square shape= new Square(this);
        
        shape.x+=10;
        shape.y+=10; 

        return shape;
    }
    
    public int defaultLength(){
        return 50;
    }
   
}
