package State;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GObjects.subs.Arrow;
import GObjects.GameObject;
import game.Play;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Setareh
 */
public class Engine {
    private BufferedImage bufferedImage;
    private Graphics g2;
    private ArrayList<GameObject> gameObjects = new ArrayList<>();
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
		
	Arrow a = new Arrow(0);
        gameObjects.add(a);
    }
    private void update(){
        for (GameObject  g : gameObjects)//tak tak object ha ra update mikonad !!
            g.update();
    }
    private void draw(){
        
        g2.clearRect(0, 0, 800, 600);
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 800, 600);
        
        State.instance.game.getGraphics().drawImage(bufferedImage, 0, 0, State.instance.game);
        for (GameObject  g : gameObjects)//tak tak object ha ra rasm mikonad
            g.draw(g2);
        for (GameObject  g : State.instance.add)//tak tak object ha ra rasm mikonad
            g.draw(g2);

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
