
package com.amortize;

import javax.swing.JFrame;

/**
 * This class creates a frame which holds the panel and swing components
 * @author Rohit
 * netId : 2021153579
 */
public class GUIFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	GUIPanel guiPanel;

	public GUIFrame() {
		guiPanel = new GUIPanel(); // create a new gui panel
		setupFrame();
	}

	public void setupFrame() {
		this.setContentPane(guiPanel); // add the gui panel to the frame
	}

	public void start() { // sets the properties of the frame
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
