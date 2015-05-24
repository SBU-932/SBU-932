/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import State.State;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

import java.awt.FlowLayout;


/**
 *
 * @author Setareh
 */
public class Background extends JPanel{
    private InputMap input_map = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	
    private ActionMap action_map = getActionMap();

    public Background() {
        State.instance.game = this;
       	State.instance.button = new boolean [3];
        get_Inputs();
    }
    private void get_Inputs(){
        setFocusable(true);
        requestFocusInWindow();
        //press "v" for turn left
        //press "n" for turn right
        //press space for shot
        AbstractAction press = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
		System.out.println("Press : ");// TODO Auto-generated method stub
                switch(e.getActionCommand()){
                    case "v":
                        State.instance.button[0] = true;
                        System.out.println("Left");
                        break;
					
                    case "n":
			State.instance.button[1] = true;
			System.out.println("Right");
                        break;
					
                    case" ":
			State.instance.button[2]= true;
                        System.out.println("Shoot");
		}
				

                //To change body of generated methods, choose Tools | Templates.
            }
        };
        AbstractAction release = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 System.out.println("release ");
                 switch(e.getActionCommand()){
                 case"v":
                     State.instance.button[0] =false;
                     break;
                 case"n":
                     State.instance.button[1] =false;
                     break;
                 case" ":
                     State.instance.button[2] =false;
                     break;
                 }
                 
            }
        };
        input_map.put(KeyStroke.getKeyStroke("released v"), "rv");
        action_map.put(KeyStroke.getKeyStroke("rv"), release);
        
        input_map.put(KeyStroke.getKeyStroke("released n"), "rn");
        action_map.put(KeyStroke.getKeyStroke("rn"), release);
    
        input_map.put(KeyStroke.getKeyStroke("released Space"), "rs");
        action_map.put(KeyStroke.getKeyStroke("rs"), release);
        
        input_map.put(KeyStroke.getKeyStroke("pressed v"), "pv");
        action_map.put("pv", press);
        
        input_map.put(KeyStroke.getKeyStroke("presssed n"), "pn");
        action_map.put(KeyStroke.getKeyStroke("pn"), press);
    
        input_map.put(KeyStroke.getKeyStroke("pressed Space"), "ps");
        action_map.put(KeyStroke.getKeyStroke("ps"), press);
        
    }
    


}
