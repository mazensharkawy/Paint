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
public class Square extends myShape implements Shape {   
    
    int sideLength;
    
     public Square(myShape shape){
        Square s=(Square)shape;
        x=s.x;
        y=s.y;
        color=s.color;
        fillcolor=s.color;
        sideLength=s.sideLength;
        
    }
    
    public Square(){
        
        Random rand=new Random();
        x= rand.nextInt(100);
        y=rand.nextInt(100);
        color=Color.RED;
        fillcolor=Color.RED;    
        sideLength=70;
    }
    
   

    @Override
    public void setProperties(Map<String, Double> properties) {        
        sideLength=properties.get("sideLength").intValue();
        
    }

    @Override
    public Map<String, Double> getProperties() {
        HashMap<String, Double> properties = new HashMap<>();         
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
    
   
}
