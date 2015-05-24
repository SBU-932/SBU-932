/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GObject;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Setareh
 */
public class Shot implements GameObject{

    int x = 400 , y= 550;
    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.PINK);
        g.fillOval(x, y , 10 , 10); //To change body of generated methods, choose Tools | Templates.
    }
    
}
