/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import State.State;
import javax.swing.JPanel;

/**
 *
 * @author Setareh
 */
public class Background extends JPanel{

    public Background() {
        State.instance.game = this;
    }


}
