/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import game.Background;

/**
 *
 * @author Setareh
 */
public class State {
    private State(){
    
    }
    public static final State instance = new State();
    
    public Background game;
}
