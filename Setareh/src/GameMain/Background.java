/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameMain;

import Controler.State;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 *
 * @author Setareh
 */
public class Background extends JPanel{
    
    public Background() {
        State.instance.game = this;
       	State.instance.button = new boolean [3];
        GetArrow();
    }
	
    private void GetArrow() {
      setFocusable(true);
      requestFocusInWindow();

      addKeyListener(new KeyAdapter() {

         @Override
         public void keyTyped(KeyEvent e) {
            myKeyEvt(e, "keyTyped");
         }

         @Override
         public void keyReleased(KeyEvent e) {
            myKeyEvt(e, "keyReleased");
         }

         @Override
         public void keyPressed(KeyEvent e) {
            myKeyEvt(e, "keyPressed");
         }

         private void myKeyEvt(KeyEvent e, String text) {
            int key = e.getKeyCode();
            System.out.println("TEST");

            if (key == KeyEvent.VK_KP_LEFT || key == KeyEvent.VK_LEFT)
            {
                System.out.println(text + " LEFT");
                if(text=="keyPressed")
                    State.instance.button[0]=true;
                else
                    State.instance.button[0]=false;
                
            }
            else if (key == KeyEvent.VK_KP_RIGHT || key == KeyEvent.VK_RIGHT)
            {
                System.out.println(text + " RIGHT");
                if(text=="keyPressed")
                    State.instance.button[1]=true;
                else
                    State.instance.button[1]=false;
            }
            else if (key == ' ')
            {
                System.out.println(text + " SPACE");
                if(text=="keyPressed")
                    State.instance.button[2]=true;
                else
                    State.instance.button[2]=false;
            }
         }


      });
   }

   
}
