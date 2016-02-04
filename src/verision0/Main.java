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
	public static void pln(String s)//time-saving method
	{
		System.out.println(s);
	}
}
