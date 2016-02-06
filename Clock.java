//**********************************************************
// Assignment: Clock Project1 Clock.java file
// Account: MichaelWang-6127
//
// Author: Michael Wang
//
// Date: 02/03/2016
//*********************************************************
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;
import java.lang.Object;
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

  public boolean is24Hour(boolean time)//sets the boundary for 24 hour clock or 12 hour clock.
  {
    if(time == true)
    {
      m_timeUpperBound = 24;
      return true; //wjt
    }
    else
    {
      m_timeUpperBound = 12;
      return false; //wjt
    }
  }

  public boolean isAM(boolean AM)//tells the if the time is AM or PM or 12 hour
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

    return m_timeZone; //wjt
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
  }
  public static void main(String[] args) //wjt ; test mai
  {
    if(args.length > 0)
    {
      Clock clock = new Clock(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
      clock.displayClock();

      while(true)
      {
        clock.calculateTime();
        clock.displayClock();
      }
    }
    else
    {
      Clock clock = new Clock();
      clock.displayClock();

      while(true)
      {
        clock.calculateTime();
        clock.displayClock();
      }
    }


  }


}
