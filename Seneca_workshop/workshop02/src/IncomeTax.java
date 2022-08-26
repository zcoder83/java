/**********************************************
Workshop 02 
Course:Java for C++ Programmers
Last Name: Jeong
First Name: Yeonkwan
ID: 104069208
Section: JAC444ZCC
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2022-02-15
**********************************************/
public class IncomeTax {
	
	public final int SINGLE_FILER = 0;
	public final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
	public final int MARRIED_SEPARATELY = 2;
	public final int HEAD_OF_HOUSEHOLD = 3;
	
	private int filingStatus;
	private int[][] intervals;
	private double[] rates;
	private double taxableIncome;
	// default constructor
	public IncomeTax() {
		
	}
	// constructor with params
	public IncomeTax(int filingStatus, int[][] i, double[] rates, double taxableIncome) {
		this.filingStatus = filingStatus;
		intervals = i;
		this.rates = rates;
		this.taxableIncome = taxableIncome;
	}

	// set and get functions
	public int getFilingStatus() {
		return filingStatus;
	}
	
	public void setFilingStatus(int val) {
		filingStatus = val;
	}
	
	public int[][] getIntervals(){
		return intervals;
	}
	public void setIntervals(int[][] arr) {
		intervals = arr;
	}
	public double[] getRates() {
		return rates;
	}
	public void setRates(double[] arr) {
		rates = arr;
	}
	public double getTaxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(double val) {
		taxableIncome = val;
	}
	
	// calculate tax and return it
	public double getIncomeTax() {
		double tax = 0;
		
		//  
		for(int i=0; i < intervals.length; i++) {
			if(i == 0 && intervals[i][filingStatus] <= taxableIncome) { // set tax in first interval, taxableIncome is over the interval
				tax = intervals[i][filingStatus] * (rates[i]/100);
			} else if(i == 0) {
				tax = taxableIncome * (rates[i]/100); // set tax when taxable income is less than the first interval
				break;
			} else if(intervals[i][filingStatus] <= taxableIncome) { // add taxes in middle range interval
				tax += (intervals[i][filingStatus] - intervals[i-1][filingStatus]) * (rates[i]/100);
				
			} else {
				tax += (taxableIncome - intervals[i-1][filingStatus]) * (rates[i]/100); // add tax in last interval
				break;
			}
		}
		
		return tax;
	}
	

	
	
	
	
}
