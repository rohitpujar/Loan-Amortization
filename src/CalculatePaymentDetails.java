
package com.amortize;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class calculates all the details pertaining to the loan
 * @author Rohit
 * netId : 2021153579
 */
public class CalculatePaymentDetails{

//	declare all the instance variables
	public double pa1;
	public double r1;
	double t1;
	double balance[];
	double interest_payment[];
	double principal_payment[];
	double premium;
	ArrayList<Double> calculatedValues =new ArrayList<Double>();
	
	public CalculatePaymentDetails(double pa, double r,double t)		//constructor to initialize variables
	{
		pa1=pa;
		t1=t;
		r1=r;
		balance = new double[(int)t];
		interest_payment = new double[(int)t];
		principal_payment = new double[(int)t];
	}
	
	
	// function to compute all the values and store them in an array list 
	public ArrayList<Double> computationOfValues(double principle,double rate,double term)
	{   
		try{
		DecimalFormat df = new DecimalFormat("#.00");		//limits the number of digits after the decimal point to 2
		double Number_of_payments = term ;
		double p=Math.pow((1+(rate/12)/100), term);
		premium=Double.parseDouble(df.format(principle*((rate/12)/100*p)/(p-1)));
		double bal=principle;
 		for(int i=0;i<(int)Number_of_payments;i++)
		{   
// 			formulas to calculate different type of values as required
			interest_payment[i] = Double.parseDouble(df.format(bal*(rate/12)/100));
			principal_payment[i] = Double.parseDouble(df.format(premium - interest_payment[i]));
			balance[i]= Double.parseDouble(df.format(bal - principal_payment[i]));
			bal=Double.parseDouble(df.format(bal-principal_payment[i]));
			if(bal<1){
				balance[i]=0;
			}
			calculatedValues.add(principal_payment[i]);  //adds the individual arrays to an array list
			calculatedValues.add(interest_payment[i]);
			calculatedValues.add(balance[i]);
		}
	} catch (Exception e) {
		System.out.println("Please enter valid input");
		System.exit(0);
	}
		return calculatedValues;
	}
}
