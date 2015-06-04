/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import GObjects.GameObject;
import game.Background;
import java.util.ArrayList;

/**
 *
 * @author Setareh
 */
public class State {
    public double delta;
    private State(){
    
    }
    public static final State instance = new State();
    
    public Background game;
    public boolean []button;
    public ArrayList<GameObject> add = new ArrayList<>();
}
