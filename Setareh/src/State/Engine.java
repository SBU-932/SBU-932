package State;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import game.Play;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Setareh
 */
public class Engine {
    private BufferedImage bufferedImage;
    private Graphics g2;
    public Engine(){
    
    }
    public void playgame(){
        boolean start=true;
        init();
      
        while(start){

            update();
            draw();
            start=check();
        
        }
        gameOver();
    }
    
    private void init(){
        Play first = new Play();
        try
        {
        first.setVisible(true);
        }
        catch(Exception e)
        {
            
        }  
        
        settupBufferedImage();
    }
    private void update(){
        
    }
    private void draw(){
        g2.clearRect(0, 0, 800, 600);
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 800, 600);
        
        State.instance.game.getGraphics().drawImage(bufferedImage, 0, 0, State.instance.game);
    }
    private boolean check(){
        return true;
    }
    private void gameOver(){
    
    }
    private void settupBufferedImage(){
        bufferedImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        g2= bufferedImage.getGraphics();
    }
   
}
