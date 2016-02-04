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
  int m_hour = 0;
  int m_minute = 0;
  int m_second = 0;
  int m_timeUpperBound = 0;//tells if the clock is 24 hours or 12 hour clock
  bool m_timeZone = true;//tells if the time is AM or PM
  long timeNow = 0;
  long timeLater = 0;
  String m_timeOfDay = "";
  
  public static void setTime(int hours, int minutes, int seconds)//sets the time with user input.
  {
	  m_hour = hours;
	  m_minute = minutes;
	  m_second = seconds;
  }
  
  public static bool is24Hour(bool time)//sets the boundary for 24 hour clock or 12 hour clock.
  {
    if(time == true)
    {
      m_timeUpperBound = 24;
    }
    else()
    {
      m_timeUpperBound = 12;
    }
  }
  
  public static bool isAM(bool AM)//tells the if the time is AM or PM or 12 hour
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
  }
  
  public static void displayClock()//prints out the time of the clock
  {
	 if(timeUpperBound == 24)
	 {
	 	System.out.println(m_hour + ":" + m_minute + ":" + m_second );
	 }
	 else()
	 {
	 	System.out.println(m_hour + ":" + m_minute + ":" + m_second + " " + m_timeOfDay);	
	 }
  }
  
  public static void calculateTime()//this calculates the time for the clock
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
	  		if(m_timeUpperBound = 24;)
	  		{
	  			if(((m_hour == 24) && (m_minute == 0) && (m_second == 0)))//helps for the wrap around time
	  			{
	  			 m_hour = 0;
	  			}
	  		}
	  		else()
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
	  			else()
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
}
