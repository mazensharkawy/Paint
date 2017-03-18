/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Graphics;

/**
 *
 * @author HP-
 */


public class Line extends Square implements Shape{

    public Line(myShape shape) {
        super(shape);
    }
    
   
    
    public Line() {
        super();
    }

    @Override
    public int defaultLength() {
        return 100; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.color);
        canvas.drawRect(x,y,sideLength,2);        
        canvas.fillRect(x,y,sideLength,2);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
        Square shape= new Line(this);
//        Line shape= (Line)s;
        
        shape.x+=10;
        shape.y+=15;
        System.out.println(shape.y);        
        System.out.println(this.y);        

        return shape;
    }

    

    
    
}