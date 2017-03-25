/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;
import javax.swing.JOptionPane;


/**
 *
 * @author HP-
 */
public abstract class myShape implements Shape{
    Color color;
    Color fillcolor;
    int x;
    int y;
    
    @Override
    public abstract Object clone() throws CloneNotSupportedException;

     @Override
    public final void setPosition(Point position) {
       x=position.x;
       y=position.y;
    }

    @Override
    public final Point getPosition() {
        return new Point(x,y);
    }    

    @Override
    public abstract void setProperties(Map<String, Double> properties);

    @Override
    public abstract Map<String, Double> getProperties();
        

    @Override
    public final void setColor(Color color) {
        this.color=color; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public final Color getColor() {
        return this.color; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public final void setFillColor(Color color) {
        this.fillcolor=color; 
    }

    @Override
    public final Color getFillColor() {
        return this.fillcolor; 
    }

    @Override
    public abstract void draw(Graphics canvas);
    //To change body of generated methods, choose Tools | Templates.
    }
