/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GObject;

import java.awt.Graphics;
import State.State;
import java.awt.Color;
/**
 *
 * @author Setareh
 */
public class Arrow implements GameObject{

    int x=400 , y=300 , r = 20;
    int lenght=30;
    boolean shoot = true;
    double alpha , speed = 0.005 ;
    
    public Arrow( double alpha ){
        this.alpha= alpha;
        
    }
    @Override
    public void update() {
        if(State.instance.button[0]){
            alpha-=speed * State.instance.delta;
        }
        else if(State.instance.button[1]){
            alpha+=speed * State.instance.delta;
        }
        else if(State.instance.button[2]){
            if(shoot){
                Shoot new_shoot = new Shoot(alpha);
                State.instance.add.add(new_shoot);
                System.out.println("New Shoot !!");
                shoot = false;
            }
            
        }
        else
            shoot=true;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillArc(x, y, r , lenght, 0 , 180 );
        
        g.setColor(Color.DARK_GRAY);
        g.drawLine(x, y, x + (int)(lenght*Math.cos(alpha)), y + (int)(lenght*Math.sin(alpha)));
    }
    
}
