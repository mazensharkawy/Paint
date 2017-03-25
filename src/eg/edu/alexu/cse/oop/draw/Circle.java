/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
        this.fillcolor=Color.RED;
        Random rand=new Random();
        x= rand.nextInt(100);
        y=rand.nextInt(100);
        diameter=70;
    }
    
    
    

    @Override
    public void setProperties(Map<String, Double> properties) {
        diameter= properties.get("diameter").intValue();        
    }

    @Override
    public Map<String, Double> getProperties() {
        HashMap<String, Double> properties = new HashMap<>();
        properties.put("diameter",(double)diameter);      
        return properties;
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
        shape.y+=10;     
        return shape;
    }
    
}
