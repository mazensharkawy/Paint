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
        fillcolor=s.fillcolor;
        width=s.width;
        height=s.height;    
        
        
    }
    
    public Rectangle(){   
        Random rand=new Random();
        x= rand.nextInt(100);
        y=rand.nextInt(100);
        color=Color.RED;        
        fillcolor=Color.RED;
        width=70;
        height=50;
        
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
