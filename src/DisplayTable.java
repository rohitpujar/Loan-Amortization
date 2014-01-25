package com.amortize;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

/**
 * This class is used to draw the table, populate all the values into the
 * table and display the same
 * @author Rohit
 * netId : 2021153579
 */

public class DisplayTable extends JFrame{

	private static final long serialVersionUID = 1L;
	public JTable maintable;
	private JPanel contentPane;
	SpringLayout layout;
	JScrollPane scroll;
	
	
	//creates a table-maintable
	public DisplayTable(double principle,double term,double interest) {
		setTitle("Loan Amortization Table");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		 
//		Create an array to hold the values that will be displayed in the table
		ArrayList<Double> calculatedValues=new ArrayList<Double>();
//		Call the computationOfValues method to calculate all the values
		CalculatePaymentDetails paymentDetails= new CalculatePaymentDetails(principle,term,interest);
		calculatedValues=paymentDetails.computationOfValues(principle,term,interest);
//		Create a new panel for the table
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(50, 100, 677, 394);
		panel.setLayout(null);
		contentPane.add(panel);
        
		//creates a table named maintable
        maintable= new JTable(calculatedValues.size(), 5);
        
      //sets the column header values for the table
        maintable.getColumnModel().getColumn(0).setHeaderValue("Payment No.");			
        maintable.getColumnModel().getColumn(1).setHeaderValue("Premium Amount");
        maintable.getColumnModel().getColumn(2).setHeaderValue("Principal Amount");
        maintable.getColumnModel().getColumn(3).setHeaderValue("Interest Amount");
        maintable.getColumnModel().getColumn(4).setHeaderValue("Balance");
		
        //fills the cells in the table 
        for(int i=0;i<calculatedValues.size();i=i+3)
		{
			maintable.setValueAt(new Integer(i/3+1), i, 0);		//method setValueAt is used to fill the positions with data in the table 
			maintable.setValueAt(paymentDetails.premium, i, 1);
			maintable.setValueAt(calculatedValues.get(i+0), i, 2);
			maintable.setValueAt(calculatedValues.get(i+1), i, 3);
			maintable.setValueAt(calculatedValues.get(i+2), i, 4);
		}
        
        JScrollPane scrollPane = new JScrollPane(maintable);//to adjust the size of the table , if needed, by adding a scroll bar
        scrollPane.setBounds(-52, 37, 677, 394);
        scrollPane.setPreferredSize(new Dimension(500, 150));
        scrollPane.setLocation(0,0);
        setPreferredSize(new Dimension(677, 394));
        panel.add(scrollPane);
        panel.setOpaque(false);
    
        }
}
