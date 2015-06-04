package Controler;

import java.awt.Color;
import java.awt.image.BufferedImage;

import GObject.GameObj;
import GObject.Subs.Blocks;
import GObject.Subs.Arrow;
import GameMain.Play;

public class Engine {
	
	

    public void Playgame(){
        boolean start = true;//If the game is running
        init();
	long currentTime = System.nanoTime();
	while(start){
            //TODO
            long updatedTime = System.nanoTime();
            State.instance.delta = (updatedTime - currentTime)/1000000;
            currentTime = updatedTime;
            update();
            draw();
	}
	end();
    }
	

	/*
	 * This method is run every frame for drawing purpose for drawing on game
	 * panel
	 */
	
    private void draw() {
        //set background
            State.instance.g.setColor(Color.WHITE);
            State.instance.g.fillRect(0, 0,State.instance.length,State.instance.width);
		
            // BEGIN: draw on g2
        	for(GameObj go: State.instance.objects)
			go.draw(State.instance.g);
		
		// END: draw on g2
		State.instance.game.getGraphics().drawImage(State.instance.buffered, 0, 0, State.instance.game);
	}
	
	/*
	 * this method run before game begin
	 */

	private void init(){
		
            Play first = new Play();
            try
            {
                first.setVisible(true);

            }
            catch(Exception e)
            {
            
            }
            settupBuffered();
            Blocks b = new Blocks();
            State.instance.objects.add(b);
            Arrow s = new Arrow(400,500,25,30,0);
            State.instance.objects.add(s);
		
		
	}
	
	/*
	 * this method is run every frame
	 */
	private void update(){
		//TODO
		for(GameObj go: State.instance.objects)
			go.update();
		
		for(GameObj go: State.instance.add)
			State.instance.objects.add(go);
		

		for(GameObj go: State.instance.remove)
			State.instance.objects.remove(go);
		
		
		State.instance.add.clear();
		State.instance.remove.clear();
	}
	
	/*
	 * this method is for end of game
	 */
	private void end(){
		//TODO
	}
	
	/*
	 * creates image and sets graphic
	 */
	private void settupBuffered(){
		State.instance.buffered = new BufferedImage(State.instance.length,
				State.instance.width,BufferedImage.TYPE_INT_RGB);
		State.instance.g = State.instance.buffered.getGraphics();
	}
	

}
