package CashierSystem;

import java.util.TimeZone;
import java.util.Timer;
import java.time.*;

public class TimeClass {

	public TimeZone tz;
	public Instant ins;
	public LocalTime localTime;
	public LocalDate localDate;
	public LocalDateTime localDateTime;
	public Timer timer;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TimeClass() {
		tz = TimeZone.getDefault();
		Instant.now();
		localDateTime = LocalDateTime.now();
		localTime = LocalTime.now();
		localDate = LocalDate.now();
		timer = new Timer();
		System.out.println(localTime);

	}
	
	public void startTimer()
	{
		
	}
	
	public void stopTimer()
	{}

	

}
