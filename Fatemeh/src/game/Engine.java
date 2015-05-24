package game;

import java.awt.Color;
import java.awt.image.BufferedImage;

import object.GameObj;
import object.display.Shelik;
import window.Frame;

public class Engine {
	
	public boolean start = true;
	
	
	public void Maingame(){
		init();
		
		
		long currentTime = System.nanoTime();
		while(start){
			//TODO
			long updatedTime = System.nanoTime();
			State.getInstance().delta = (updatedTime - currentTime)/1000000;
			currentTime = updatedTime;
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
		
		
		for(GameObj go: State.getInstance().objects)
			go.draw(State.getInstance().g);
		
		State.getInstance().Panel.getGraphics().drawImage(State.getInstance().buffered
				, 0, 0, State.getInstance().Panel);
	}

	private void init(){
		Frame frame = new Frame();
		settupBuffered();
		
		Shelik s = new Shelik(400,500,25,30,0);
		State.getInstance().objects.add(s);
	}
	
	private void update(){
		//TODO
		for(GameObj go: State.getInstance().objects)
			go.update();
		
		for(GameObj go: State.getInstance().add)
			State.getInstance().objects.add(go);
		
		State.getInstance().add.clear();
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
