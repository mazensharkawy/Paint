/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


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
        fillcolor=s.fillcolor;
        width=s.width;
        height=s.height;        
        
    }
    
    public Triangle(){
        Random rand=new Random();
        x= rand.nextInt(100);
        y=rand.nextInt(100)+20;        
        height=50;
        width=100;
        color=Color.RED;
        fillcolor=Color.RED;
        
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
