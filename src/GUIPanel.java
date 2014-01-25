package com.amortize;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class creates a panel and swing components buttons,text fields,labels
 * @author Rohit netId : 2021153579
 */
@SuppressWarnings("serial")
public class GUIPanel extends JPanel { // creating all the components

	DisplayTable tc;
	SpringLayout currentlayout;
	JLabel title;
	JLabel principleLabel;
	JLabel termLabel;
	JLabel interestLabel;
	JTextField principleField;
	JTextField termField;
	JTextField interestField;
	JButton chartButton;
	JButton graphButton;
	JScrollPane scrollPane;

	public GUIPanel() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(new Color(0, 206, 209));
		title = new JLabel("Loan Amortization");
		title.setFont(new Font("Tahoma", Font.BOLD, 13));
		termLabel = new JLabel("Term"); // initializes all parameters
		principleLabel = new JLabel("Principle");
		interestLabel = new JLabel("Interest");
		principleField = new JTextField();
		principleField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) { //The text fields allow only numbers to be entered
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
						|| (c == KeyEvent.VK_DELETE) || (c == '.'))) {
					e.consume();
				}

			}
		});
		termField = new JTextField();
		termField.addKeyListener(new KeyAdapter() { //The text fields allow only numbers to be entered
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
						|| (c == KeyEvent.VK_DELETE) || (c == '.'))) {
					e.consume();
				}

			}
		});
		interestField = new JTextField();
		interestField.addKeyListener(new KeyAdapter() { //The text fields allow only numbers to be entered
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE)
						|| (c == KeyEvent.VK_DELETE) || (c == '.'))) {
					e.consume();
				}

			}
		});
		scrollPane = new JScrollPane();

		// creates a button named table
		chartButton = new JButton("Monthly Payment");
		chartButton.setEnabled(false);

		// creates a button named graph
		graphButton = new JButton("Graph");
		graphButton.setEnabled(false);

		scrollPane.setEnabled(false);

		// Set the background color for buttons
		graphButton.setBackground(Color.LIGHT_GRAY);
		chartButton.setBackground(Color.LIGHT_GRAY);

		// document listener to observe the values entered in the text fields
		principleField.getDocument().addDocumentListener(
				new DocumentListener() {

					public void changedUpdate(DocumentEvent arg0) {
						validate();
					}

					public void insertUpdate(DocumentEvent arg0) {
						validate();
					}

					public void removeUpdate(DocumentEvent arg0) {
						validate();
					}
				});

		termField.getDocument().addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent arg0) {
				validate();
			}

			public void insertUpdate(DocumentEvent arg0) {
				validate();
			}

			public void removeUpdate(DocumentEvent arg0) {
				validate();
			}
		});

		interestField.getDocument().addDocumentListener(new DocumentListener() {

			public void changedUpdate(DocumentEvent arg0) {
				validate();
			}

			public void insertUpdate(DocumentEvent arg0) {
				validate();
			}

			public void removeUpdate(DocumentEvent arg0) {
				validate();
			}
		});

		// action listener for the button "Table"
		chartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double prin = Double.parseDouble(principleField.getText()); 
				double term = Double.parseDouble(interestField.getText());
				double interest = Double.parseDouble(termField.getText());
				tc = new DisplayTable(prin, term, interest);
				tc.setVisible(true);
			}
		});

		// action listener for the button "Graph"
		graphButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double prin = Double.parseDouble(principleField.getText());
				double term = Double.parseDouble(interestField.getText());
				double interest = Double.parseDouble(termField.getText());

				GraphingData ng = new GraphingData();
				ng.drawGraph(prin, term, interest);
			}
		});

		currentlayout = new SpringLayout();

		setupPanel(); // to add the components to the panel
	}

	// function to validate the data entered in the text fields by the user by
	// using regular expressions
	public void validate() {
		if (principleField.getText().matches("[0-9]+(.[0-9]+)?")
				&& termField.getText().matches("[0-9]+(.[0-9]+)?")
				&& interestField.getText().matches("[0-9]+(.[0-9]+)?")) {
			chartButton.setEnabled(true);
			graphButton.setEnabled(true);
		} else {
			if (principleField.getText().matches("[0]?")
					&& termField.getText().matches("[0]?")
					&& interestField.getText().matches("[0]?")) {
				chartButton.setEnabled(false);
				graphButton.setEnabled(false);
			}
		}

	}

	// adds all the components to the panel
	public void setupPanel() {
		this.setLayout(currentlayout);
		this.add(title);
		this.add(principleLabel);
		this.add(interestLabel);
		this.add(termLabel);
		this.add(principleField);
		this.add(termField);
		this.add(interestField);
		this.add(chartButton);
		this.add(scrollPane);
		this.add(graphButton);
		setupLayout(); // to define all the constraints
	}

	// Sets the constraints to allign the components
	public void setupLayout() {
		currentlayout.putConstraint(SpringLayout.WEST, termLabel, 0,
				SpringLayout.WEST, principleLabel);
		currentlayout.putConstraint(SpringLayout.NORTH, principleLabel, 81,
				SpringLayout.NORTH, this);
		currentlayout.putConstraint(SpringLayout.WEST, principleLabel, 107,
				SpringLayout.WEST, this);
		currentlayout.putConstraint(SpringLayout.NORTH, termLabel, 25,
				SpringLayout.SOUTH, interestLabel);
		currentlayout.putConstraint(SpringLayout.NORTH, interestLabel, 18,
				SpringLayout.SOUTH, principleLabel);
		currentlayout.putConstraint(SpringLayout.WEST, interestLabel, 0,
				SpringLayout.WEST, principleLabel);
		interestLabel.setVerticalAlignment(SwingConstants.TOP);
		currentlayout.putConstraint(SpringLayout.NORTH, principleField, -3,
				SpringLayout.NORTH, principleLabel);
		currentlayout.putConstraint(SpringLayout.WEST, principleField, 66,
				SpringLayout.EAST, principleLabel);
		currentlayout.putConstraint(SpringLayout.EAST, principleField, 123,
				SpringLayout.EAST, principleLabel);
		currentlayout.putConstraint(SpringLayout.NORTH, termField, -3,
				SpringLayout.NORTH, termLabel);
		currentlayout.putConstraint(SpringLayout.WEST, termField, 0,
				SpringLayout.WEST, principleField);
		currentlayout.putConstraint(SpringLayout.EAST, termField, -181,
				SpringLayout.EAST, this);
		currentlayout.putConstraint(SpringLayout.NORTH, interestField, -3,
				SpringLayout.NORTH, interestLabel);
		currentlayout.putConstraint(SpringLayout.WEST, interestField, 0,
				SpringLayout.WEST, principleField);
		currentlayout.putConstraint(SpringLayout.EAST, interestField, 0,
				SpringLayout.EAST, principleField);
		currentlayout.putConstraint(SpringLayout.NORTH, graphButton, 1,
				SpringLayout.NORTH, chartButton);
		currentlayout.putConstraint(SpringLayout.WEST, graphButton, 35,
				SpringLayout.EAST, chartButton);
		currentlayout.putConstraint(SpringLayout.SOUTH, graphButton, 0,
				SpringLayout.SOUTH, chartButton);
		currentlayout.putConstraint(SpringLayout.EAST, graphButton, -62,
				SpringLayout.EAST, this);
		currentlayout.putConstraint(SpringLayout.NORTH, chartButton, 27,
				SpringLayout.SOUTH, termField);
		currentlayout.putConstraint(SpringLayout.WEST, chartButton, 98,
				SpringLayout.WEST, this);
		currentlayout.putConstraint(SpringLayout.EAST, chartButton, -228,
				SpringLayout.EAST, this);
		currentlayout.putConstraint(SpringLayout.WEST, title, 175,
				SpringLayout.WEST, this);
		currentlayout.putConstraint(SpringLayout.EAST, title, -142,
				SpringLayout.EAST, this);
		currentlayout.putConstraint(SpringLayout.NORTH, title, 10,
				SpringLayout.NORTH, this);
		currentlayout.putConstraint(SpringLayout.SOUTH, title, 53,
				SpringLayout.NORTH, this);

	}

}
