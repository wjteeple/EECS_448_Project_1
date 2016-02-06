//**********************************************************
// Assignment: Clock Project1 Clock.java file
// Account: MichaelWang-6127
//
// Author: Michael Wang (Edited by Will Teeple)
//
// Date: 02/03/2016
//*********************************************************
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
import java.lang.Object;
import java.io.InputStream;
import java.util.Scanner;

public class Clock
{
  private int m_hour = 0;
  private int m_minute = 0;
  private int m_second = 0;
  public int m_timeUpperBound = 0;//tells if the clock is 24 hours or 12 hour clock
  public boolean m_timeZone = true;//tells if the time is AM or PM
  public long timeNow = 0;
  public long timeLater = 0;
  public String m_timeOfDay = "";

  public Clock() //wjt ; constructor
  {
    setTime(12, 0, 0);
  }

  public Clock(int hours, int minutes, int seconds)
  {
    setTime(hours, minutes, seconds);
  }

  public void setTime(int hours, int minutes, int seconds)//sets the time with user input.
  {
	  m_hour = hours;
	  m_minute = minutes;
	  m_second = seconds;
  }

  public void is24Hour(boolean time)//sets the boundary for 24 hour clock or 12 hour clock. ; wjt return type to void
  {
    if(time == true)
    {
      m_timeUpperBound = 24;
    }
    else
    {
      m_timeUpperBound = 12;
    }

    return;
  }

  public void isAM(boolean AM)//tells the if the time is AM or PM or 12 hour ; wjt change return to void
  {
  	if(AM == true)
  	{
  	 m_timeZone = true;
  	 m_timeOfDay = "A.M.";
  	}
  	else
  	{
  	 m_timeZone = false;
  	 m_timeOfDay = "P.M.";
  	}

    return; //wjt
  }

  public void displayClock()//prints out the time of the clock
  {
	 if(m_timeUpperBound == 24)
	 {
	 	System.out.println(m_hour + ":" + m_minute + ":" + m_second);
	 }
	 else
	 {
	 	System.out.println(m_hour + ":" + m_minute + ":" + m_second + " " + m_timeOfDay);
	 }
  }

  public void calculateTime()//this calculates the time for the clock
  {
	  timeNow = System.currentTimeMillis();//This grabs the system clock time in milliseconds
	  timeLater = (System.currentTimeMillis()+1000);
	  while(timeNow != timeLater)//This delays the process by one second
	  {
	  	timeNow = System.currentTimeMillis();
	  }
	  m_second += 1;
	  if(m_second == 60)
	  {
	  	m_second = 0;
	  	m_minute += 1;
	  	if(m_minute == 60)
	  	{
	  		m_minute = 0;
	  		m_hour +=1;
	  		if(m_timeUpperBound == 24)
	  		{
	  			if(((m_hour == 24) && (m_minute == 0) && (m_second == 0)))//helps for the wrap around time
	  			{
	  			 m_hour = 0;
	  			}
	  		}
	  		else
	  		{
	  			if(m_timeZone == true)
	  			{
	  				if(((m_hour == 12) && (m_minute == 0) && (m_second == 0)))//helps for the wrap around time zone
	  				{
	  					m_timeZone = false;
	  				}
	  				else if(((m_hour == 13) && (m_minute == 0) && (m_second == 0)))//helps for the wrap around time
	  				{
	  				 m_hour = 1;
	  				}
	  			}
	  			else
	  			{
	  				if(((m_hour == 12) && (m_minute == 0) && (m_second == 0)))//helps for the wrap around time zone
	  				{
	  					m_timeZone = true;
	  				}
	  				else if(!((m_hour == 13) && (m_minute == 0) && (m_second == 0)))//helps for the wrap around time
	  				{
	  				 m_hour = 1;
	  				}
	  			}
	  		}
	  	}
	  }
    isAM(m_timeZone);
  }

  public void initMenu() //wjt ; console menu for method testing
  {
    String h, m, s, input;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to your new clock!");

    do {
      System.out.println("\nSelect 12 hour or 24 hour clock format.");
      System.out.println("1. 12 hour");
      System.out.println("2. 24 hour");
      System.out.print("Your choice: ");
      input = scanner.nextLine();

      if (Integer.parseInt(input) == 1)
      {
        is24Hour(false);
      }
      else if (Integer.parseInt(input) == 2)
      {
        is24Hour(true);
      }
      else
      {
        System.out.println("Invalid selection, please choose again.");
      }
    } while (Integer.parseInt(input) != 1 && Integer.parseInt(input) != 2);

    if (m_timeUpperBound == 24)
    {
      System.out.println("\nLet's set the time.");
      do {
        System.out.print("Hours: ");
        h = scanner.nextLine();
        if (Integer.parseInt(h) < 0 || Integer.parseInt(h) > 23)
        {
          System.out.println("Invalid selection, please choose again.");
        }
      } while (Integer.parseInt(h) < 0 || Integer.parseInt(h) > 23);
    }
    else //if 12
    {
      do {
        do {
          System.out.println("\nA.M. or P.M.?");
          System.out.println("1. A.M.");
          System.out.println("2. P.M.");
          System.out.print("Your choice: ");
          input = scanner.nextLine();
          if (Integer.parseInt(input) != 1 && Integer.parseInt(input) != 2)
          {
            System.out.println("Invalid selection, please choose again.");
          }
        } while (Integer.parseInt(input) != 1 && Integer.parseInt(input) != 2);
        if (Integer.parseInt(input) == 1)
        {
          isAM(true);
        }
        else
        {
          isAM(false);
        }

        System.out.println("\nLet's set the time.");
        System.out.print("Hours: ");
        h = scanner.nextLine();
        if (Integer.parseInt(h) < 1 || Integer.parseInt(h) > 12)
        {
          System.out.println("Invalid selection, please choose again.");
        }
      } while (Integer.parseInt(h) < 1 || Integer.parseInt(h) > 12);
    }

    do {
      System.out.print("Minutes: ");
      m = scanner.nextLine();
      if (Integer.parseInt(m) < 0 || Integer.parseInt(m) > 60)
      {
        System.out.println("Invalid selection, please choose again.");
      }
    } while (Integer.parseInt(m) < 0 || Integer.parseInt(m) > 60);

    do {
      System.out.print("Seconds: ");
      s = scanner.nextLine();
      if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 60)
      {
        System.out.println("Invalid selection, please choose again.");
      }
    } while (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 60);

    setTime(Integer.parseInt(h), Integer.parseInt(m), Integer.parseInt(s));

    System.out.println("\nEverything looks good! Your clock will now begin.\n");
  }

  public static void main(String[] args) //wjt ; test main
  {
    Clock clock = new Clock();
    clock.initMenu();
    clock.displayClock();

    while(true)
    {
      clock.calculateTime();
      clock.displayClock();
    }
  }
}
