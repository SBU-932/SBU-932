package window;

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

public class Panel extends JPanel {
	
	private InputMap ipm = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	
	private ActionMap am = getActionMap();

	/**
	 * Create the panel.
	 */
	public Panel() {
		game.State.getInstance().button = new boolean [3];
		
		game.State.getInstance().Panel=this;
		
		setupInputs();
		setupBotton();

	}

	private void setupBotton() {
		// TODO Auto-generated method stub
		JButton button = new JButton("Restart");
		JButton button1 = new JButton("Quit");
		button.setLocation(868,462);
		button.setSize(89, 23);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Restart();
				
			}

			private void Restart() {
				// TODO Auto-generated method stub
				
			}
		});
		setLayout(null);
		add(button);
		
		button1.setLocation(868, 517);
		button1.setSize(88,23);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Quit();
			}

			private void Quit() {
				// TODO Auto-generated method stub
				
			}
		});
		add(button1);
		
	}

	private void setupInputs() {
		// TODO Auto-generated method stub
		setFocusable(true);
		requestFocusInWindow();
		
		AbstractAction press = new AbstractAction() {
			
			
			@Override
			public void actionPerformed(ActionEvent ev) {
				System.out.println("Press"+ev.getActionCommand());
				// TODO Auto-generated method stub
				switch(ev.getActionCommand()){
				case "a":
					game.State.getInstance().button[0] = true;
					break;
					
				case "d":
					game.State.getInstance().button[1] = true;
					break;
					
				case" ":
					game.State.getInstance().button[2]= true;
				}
				
			}
		};
		
		AbstractAction release = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				System.out.println("Release"+ev.getActionCommand());
				// TODO Auto-generated method stub
				switch (ev.getActionCommand()) {
				case "a":
					game.State.getInstance().button[0] = false;

					break;
				case "d":
					game.State.getInstance().button[1] = false;
					System.out.println("release");
					break;
				case " ":
					game.State.getInstance().button[2] = false;
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
