package GObject.Subs;

import Controler.State;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import GObject.GameObj;
import GObject.Subs.Shoot;
import static com.sun.org.apache.xalan.internal.lib.ExsltMath.random;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import static jdk.nashorn.internal.objects.NativeMath.random;

public class Blocks implements GameObj {

    //keep each block color
    Color[][] color= new Color[State.instance.column_count][State.instance.row_count];
    public Blocks() {
        // TODO Auto-generated constructor stub
        State.instance.blocks = this;

        // calculate length and width of block
        State.instance.block_lenght = (State.instance.length / State.instance.column_count)  ;
        State.instance.block_width = (State.instance.width / State.instance.row_count) ;
        State.instance.radius =(State.instance.length / State.instance.column_count)-2;
        // meghdar dehi be array block
        State.instance.block = new boolean[State.instance.column_count][State.instance.row_count];
        
        Random rand = new Random();

        for(int j=0  ;  j < State.instance.column_count ; j++){
            for(int i=0 ; i< State.instance.row_count ; i++){
                if(j<3){
                    State.instance.block[i][j]=true;
                }
                else{
                    int randomNum = rand.nextInt(State.instance.column_count) ;
                    if(State.instance.block[randomNum][j-1]){
                        State.instance.block[randomNum][j]=true;
                    }
                }
            }
        
        }

        //choose random color for each block 
        for(int i = 0 ; i < State.instance.column_count ; i++){
            for(int j = 0 ; j < State.instance.row_count ; j++){
                 color[i][j]=set_rand_color();
            }
        }
    }

    @Override
    public void update() {
		// TODO Auto-generated method stub
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see object.GameObj#draw(java.awt.Graphics) this method draw blocks
	 */
    @Override
    public void draw(Graphics g) {
	                              

	for (int i = State.instance.column_count - 1; i >= 0; i--) {
            for (int j = State.instance.row_count - 1; j >= 0; j--) {
		g.setColor(color[i][j]);
                if (State.instance.block[i][j])
                    g.fillOval(i * State.instance.block_lenght + 1,j * State.instance.block_width + 1,State.instance.block_lenght - 1,State.instance.block_width - 1);
            }
	}
    }
	
    public boolean bump(Shoot shoot) {
        int x = ((int) shoot.getX()) / State.instance.block_lenght;
	int y = ((int) shoot.getY()) / State.instance.block_width;
	if( x>=0 && y>=0 && x<State.instance.column_count && y<State.instance.row_count ){
            if (State.instance.block[x][y]) {
		State.instance.block[x][y] = false;
		System.out.println(x+ " "+ y);
		return true;
            }
	}
	return false;
    }
    //give random color
    private  Color set_rand_color(){
        
        Random rand = new Random();
        int randomNum = rand.nextInt(5)+1 ;
        switch(randomNum){
            case(1):
                return Color.RED;
            case(2):
                return Color.GREEN;
            case(3):
                return Color.YELLOW;
            case(4):
                return Color.MAGENTA;
            case(5):
                return Color.CYAN;
        }
        return Color.WHITE;
    }
    

}
