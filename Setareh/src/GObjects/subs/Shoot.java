/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GObjects.subs;

import GObjects.GameObject;
import State.State;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Setareh
 */
public class Shoot implements GameObject{

    int x = 400 , y= 550;
    double alpha;
    double speed = 1;
    
    public Shoot(double alpha){
        this.alpha=alpha;
    }

    @Override
    public void update() {
        x+=speed*Math.cos(alpha)*State.instance.delta;
        y+=speed*Math.cos(alpha)*State.instance.delta;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.PINK);
        g.fillOval(x, y , 10 , 10); //To change body of generated methods, choose Tools | Templates.
    }
    
}
