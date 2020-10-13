import java.util.Scanner; 

public class  TimeDifferenceCalculation{
	public static void main(String[] args) {

		Scanner Time = new Scanner(System.in);

		System.out.print("Enter First Time:");

		int FirstTime = Time.nextInt(); 

		System.out.print("Enter SecondTime Time:");

		int SecondTime = Time.nextInt(); 

		//System.out.println(FirstTime); 

		//System.out.println(SecondTime); 

		int HoursinTime1 = (FirstTime/10000) ; 

		int HoursinTime2 = (SecondTime / 10000);


		int minutes_secondsT1 = (FirstTime % 10000); 

		int minutes_secondsT2 = (SecondTime % 10000); 

		int minutes_T1 = (minutes_secondsT1 / 100); // isolate the minutes in time 1 

		int minutes_T2 = (minutes_secondsT2 / 100); // isolate the minutes in time 2 

		int seconds_T1 = (minutes_secondsT1 % 100); // isolate the seconds in time 1 

		int seconds_T2 = (minutes_secondsT2 % 100);  // isolate the seconds in time 2 

		int totalT1_seconds = (HoursinTime1 * 3600) + (minutes_T1 * 60) + (seconds_T1); 

		int totalT2_seconds = (HoursinTime2 * 3600) + (minutes_T2 * 60) + (seconds_T2); 

		int TimeDifference = totalT1_seconds - totalT2_seconds; 

		int HoursTimeDiff = (TimeDifference / 3600) * 10000; 

		int Minutes_TimeDiff = (TimeDifference % 3600); 

		int Minutes_TimeDiff2 = (Minutes_TimeDiff / 60) * 100 ; 

		int Seconds_TimeDiff = Minutes_TimeDiff % 60; 

		int Time_Difference = HoursTimeDiff + Minutes_TimeDiff2 + Seconds_TimeDiff; 


		//System.out.println("minutes in time 1 are \t" +  minutes_T1);

		//System.out.println("minutes in time 2 are \t" +  minutes_T2);

		//System.out.println("seconds in time  1 are \t " + seconds_T1);

		//System.out.println("seconds in time 2 are \t " +  seconds_T2);	

		//System.out.println(" total seconds in time 1 are \t " +  totalT1_seconds);	

		//System.out.println(" total seconds in time 2 are \t " +  totalT2_seconds);	

		//System.out.println(" time difference in seconds is \t " +  TimeDifference);	

		//System.out.println(" Time difference in HH format is \t " +  HoursTimeDiff);	

		//System.out.println(" Time difference in MM format is \t " +  Minutes_TimeDiff2);

		//System.out.println(" Time difference in SS format is \t " +  Seconds_TimeDiff);

		System.out.println(" Time difference in HHMMSS format is \t " + Time_Difference);





		

	} 

		
	}
