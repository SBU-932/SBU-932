/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author Setareh
 */
public class Engine {
    public void game(){
        boolean start=true;
        start();
        while(start){
            init();
            update();
            draw();
            start=check();
        
        }
        end();
    }
    private void start(){
    
    }
    private void init(){
    
    }
    private void update(){
   
    }
    private void draw(){
   
    }
    private boolean check(){
        return true;
    }
    private void end(){
    
    }
   
}
