/**********************************************
Workshop 10 
Course:Java for C++ Programmers
Last Name: Jeong
First Name: Yeonkwan
ID: 104069208
Section: JAC444ZCC
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: 2022-04-18
**********************************************/



package workshop10;

import java.util.*;

public class Time implements Comparable<Time>, Cloneable {

	private static int mHour;
	private static int mMin;
	private static int mSecond;
	// elapsed seconds
	private long mTime;

	public Time() {
		mTime = System.currentTimeMillis();
	}

	public Time(int hour, int min, int second) {
		mHour = hour;
		mMin = min;
		mSecond = second;
	}

	public Time(long seconds) {
		mTime = seconds;
	}

	public int getHour() {
		return (int) (mTime / (60 * 60)) % 24;
	}

	public int getMinute() {
		return (int) (mTime / 60) % 60;
	}

	public int getSecond() {
		return (int) (mTime) % 60;
	}
	public static long getSeconds() {
		return (mHour * 60 * 60) + (mMin * 60) + mSecond;
	}

	public String toString() {
		
		return getHour() + " hours " + getMinute() + " minutes " + getSecond() + " seconds";
	}
	
	@Override
    public int compareTo(Time other) {
        int result = (int) (this.mTime - other.mTime); 
        return result;
    }
	@Override
    protected Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }
	
	
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		//time 1
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter time1 (hour minute second): ");
		int i;
		int a[] = new int[3];
		String s[] = scan.nextLine().split(" ");
		for (i = 0; i < s.length; i++) {
			a[i] = Integer.parseInt(s[i]);
		}
		Time time1 = new Time(a[0], a[1], a[2]);
		time1.mTime = getSeconds();
		System.out.println(time1.toString());
		System.out.println("Elapsed seconds in time1: " + time1.mTime);
		
		//time 2
		
		System.out.print("Enter time2 (elapsed time in seconds): ");
		long temp = scan.nextLong();
		
		//create time2 by constructor with 1 parameter
		Time time2 = new Time(temp);
		
		System.out.println(time2.toString());
		System.out.println("Elapsed seconds in time2: " + time2.mTime);
		
		
		System.out.println("time1.compareTo(time2)? " + time1.compareTo(time2));
		
		
		Time time3 = (Time)time1.clone();
		if(time3 != null) {
			System.out.println("time3 is created as a clone of time1");
			
		}
		System.out.println("time1.compareTo(time3)? " + time1.compareTo(time3));
	}

}
