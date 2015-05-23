package window;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

public class Panel extends JPanel {
	
	private InputMap ipm = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	
	private ActionMap am = getActionMap();

	/**
	 * Create the panel.
	 */
	public Panel() {
		game.State.getInstance().botton = new boolean [3];
		
		
		setupInputs();

	}

	private void setupInputs() {
		// TODO Auto-generated method stub
		setFocusable(true);
		requestFocusInWindow();
		
		AbstractAction press = new AbstractAction() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent ev) {
				// TODO Auto-generated method stub
				switch(ev.getActionCommand()){
				case "a":
					game.State.getInstance().botton[0] = true;
					break;
					
				case "d":
					game.State.getInstance().botton[1] = true;
					break;
					
				case" ":
					game.State.getInstance().botton[2]= true;
				}
				
			}
		};
		
		AbstractAction release = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				// TODO Auto-generated method stub
				switch (ev.getActionCommand()) {
				case "a":
					game.State.getInstance().botton[0] = false;

					break;
				case "d":
					game.State.getInstance().botton[1] = false;
					System.out.println("release");
					break;
				case " ":
					game.State.getInstance().botton[2] = false;
					break;

				}

			}

		};

		ipm.put(KeyStroke.getKeyStroke("released A"), "ra");
		am.put("ra", release);

		ipm.put(KeyStroke.getKeyStroke("pressed A"), "pa");
		am.put("pa", press);

		ipm.put(KeyStroke.getKeyStroke("released D"), "rd");
		am.put("rd", release);

		ipm.put(KeyStroke.getKeyStroke("pressed D"), "pd");
		am.put("pd", press);

		ipm.put(KeyStroke.getKeyStroke("released SPACE"), "rs");
		am.put("rs", release);

		ipm.put(KeyStroke.getKeyStroke("pressed SPACE"), "ps");
		am.put("ps", press);
	}

		
	}
