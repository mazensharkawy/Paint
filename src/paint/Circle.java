/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
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
public class Circle extends myShape implements Shape{
    
    int diameter;
    
    public Circle(myShape shape){
        Circle s=(Circle)shape;
        x=s.x;
        y=s.y;
        color=s.color;
        diameter=s.diameter;
        
    }
    
    public Circle() {
        this.color=Color.RED;
        Random rand=new Random();
        x= rand.nextInt(100);
        y=rand.nextInt(100);
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField diameterField = new JTextField(5);       
        
        diameterField.setText("70");
        xField.setText(""+x);
        yField.setText(""+y);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("x:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer 
        myPanel.add(new JLabel("y:"));
        myPanel.add(yField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Diameter: "));
        myPanel.add(diameterField);
       
        result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if(result==JOptionPane.OK_OPTION){
            diameter=Integer.parseInt(diameterField.getText());            
            x=Integer.parseInt(xField.getText());
            y=Integer.parseInt(yField.getText());
        }
    }
    
    
    

    @Override
    public void setProperties(Map<String, Double> properties) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Double> getProperties() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.color);
        canvas.drawOval(x, y, diameter,diameter);        
        canvas.fillOval(x,y,diameter,diameter);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Circle shape= new Circle(this);
        shape.x+=10;
        shape.y=+10;      
        
        return shape;
    }
    
}
