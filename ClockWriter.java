//**********************************************************
// Assignment: Clock Project1 ClockWriter.java file
// Account: MichaelWang-6127
//
// Author: Michael Wang
//
// Date: 02/03/2016
//*********************************************************
public class ClockerWriter
{
  int m_hour = 0;
  int m_minute = 0;
  int m_second = 0;
  int m_timeUpperBound = 0;
  bool m_timeZone = 0;
  
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
  
  public static void displayClock()//prints out the time of the clock
  {
	  System.out.println(m_hour + ":" + m_minute + ":" + m_second );
  }
  
  public static void calculateTime()
  {
	  
  }
}
