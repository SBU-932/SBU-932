/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Setareh
 */
public class Background extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
    
        this.setBackground(Color.WHITE);
        g.setColor(Color.red);
//        g.fillOval(300, 400, 50, 50);
    }
}
