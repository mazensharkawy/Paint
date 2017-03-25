/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;

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
        sideLength=100;
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
