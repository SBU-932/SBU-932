package game;

import java.awt.Color;
import java.awt.image.BufferedImage;

import window.Frame;

public class Engine {
	
	public boolean start = true;
	
	
	public void Maingame(){
		init();
		while(start){
			//TODO
			
			update();
			draw();
		}
		end();
		
	}
	
	private void draw() {
		// TODO Auto-generated method stub
		State.getInstance().g.setColor(Color.PINK);
		State.getInstance().g.fillRect(0, 0,State.getInstance().width
				,State.getInstance().heigth);
		
		State.getInstance().Panel.getGraphics().drawImage(State.getInstance().buffered
				, 0, 0, State.getInstance().Panel);
	}

	private void init(){
		Frame frame = new Frame();
		settupBuffered();
	}
	
	private void update(){
		//TODO
	}
	
	private void end(){
		//TODO
	}
	
	private void settupBuffered(){
		State.getInstance().buffered = new BufferedImage(State.getInstance().width,
				State.getInstance().heigth,BufferedImage.TYPE_INT_RGB);
		State.getInstance().g = State.getInstance().buffered.getGraphics();
	}
	

}
