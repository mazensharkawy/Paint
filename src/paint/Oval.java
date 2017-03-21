/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

/**
 *
 * @author HP-
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Oval extends myShape implements Shape{
   
    int hAxis;
    int vAxis;
    
    public Oval(myShape shape){
        Oval s=(Oval)shape;
        x=s.x;
        y=s.y;
        color=s.color;
        hAxis=s.hAxis;
        vAxis=s.vAxis;
    }
    
    public Oval() {
        this.color=Color.RED;
        Random rand=new Random();
        x= rand.nextInt(100);
        y=rand.nextInt(100);
        
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField vAxisField = new JTextField(5);
        JTextField hAxisField = new JTextField(5);
        vAxisField.setText("50");
        hAxisField.setText("100");
        xField.setText(""+x);
        yField.setText(""+y);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("x:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer 
        myPanel.add(new JLabel("y:"));
        myPanel.add(yField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("V-Axis: "));
        myPanel.add(vAxisField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("H-Axis: "));
        myPanel.add(hAxisField);
        result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
        if(result==JOptionPane.OK_OPTION){
            hAxis=Integer.parseInt(hAxisField.getText());
            vAxis=Integer.parseInt(vAxisField.getText());
            x=Integer.parseInt(xField.getText());
            y=Integer.parseInt(yField.getText());
        }
    }
   
    @Override
    public void setProperties(Map<String, Double> properties) {
        this.hAxis=properties.get("hAxis").intValue();
        this.vAxis=properties.get("vAxis").intValue();
    }

    @Override
    public Map<String, Double> getProperties() {
        HashMap<String,Double> properties =new HashMap<>();
        properties.put("hAxis", (double)hAxis);
        properties.put("vAxis", (double)vAxis);
        return properties;
    }

   

    

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.color);
        canvas.drawOval(x, y, hAxis, vAxis);        
        canvas.fillOval(x,y,hAxis,vAxis);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Oval shape= new Oval(this);
        shape.x+=10;
        shape.y+=10; 
        
        return shape;
    }
    
}
