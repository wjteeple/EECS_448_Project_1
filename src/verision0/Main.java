/**
 *		@file:		Main.java
 *		@author:	Austin Bailey
 *		@date:		2/4/2016
 * 
 */
package verision0;
import java.util.Scanner;
public class Main 
{
	static Scanner myScanner = new Scanner(System.in);
	public static void main(String[] args)
	{
		boolean is12hr;		//this boolean determines if the clock outputs in 12 or 24 hr, 12 for true, 24 for false
//		boolean initialSeen=false;//When reading input from user, will determine if the user has seen the prompt for the first time or not
		boolean exit = false;//determines if we should exit loop
		int choice;
		int min, hr, sec;
		pln("Welcome to the clock!\nplease interact with the clock by pressing a number and hitting enter");
		while(!exit)
		{
			pln("Would you like the clock to display in 12 or 24 hour mode?\n1)12hr\n2)24hr");
			choice = myScanner.nextInt();//TODO fix so that it takes any input in as a string, then converts to int to prevent errors
			if(choice==1)
			{
				is12hr=true;
				exit=true;
			}
			else if(choice==2)
			{
				is12hr=false;
				exit=true;
			}
			else
			{
				pln("Please enter only the number 1 or 2 and nothing else");
				exit=false;
			}
		}
	}
	public static TimeTriple setTime()
	{
		boolean exit = false;
		int sec=0;
		int min=0;
		int hr=0;
		int choice;
		while(!exit)
		{
			pln("At what second would you like to set the clock?");
			choice = myScanner.nextInt();//TODO fix so it takes and converts string input
			if(choice>=0&&choice<=59)
			{
				sec = choice;
				exit = true;
			}
			else
			{
				pln("Please input a number betwn 0 and 59");
			}
		}
		exit=false;
		while(!exit)
		{
			pln("At what minute would you like to set the clock?");
			choice = myScanner.nextInt();//TODO fix so takes and converts string input
			if(choice>=0&&choice<=59)
			{
				min=choice;
				exit=true;
			}
			else
			{
				pln("Please input a number between 0 and 59");
			}
		}
		exit=false;
		while(!exit)
		{
			pln("At what hr would you like to set the clock?");
			choice = myScanner.nextInt();//TODO fix so takes and converts string input
			if(choice>=0&&choice<=23)
			{
				hr=choice;
				exit=true;
			}
			else
			{
				pln("Please input a between 0 and 23");
			}
		}
		TimeTriple myTimeTriple = new TimeTriple(hr,min,sec);
		return myTimeTriple;
	}
	public static void pln(String s)//time-saving method
	{
		System.out.println(s);
	}
}
