package mailMerger;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalTime;
public class Student {
	private String name;
	private int studentNumber;
	private String logOnTime;
	private String logOffTime;
	private String email;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the studentNumber
	 */
	public int getStudentNumber() {
		return studentNumber;
	}
	/**
	 * @param studentNumber the studentNumber to set
	 */
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	/**
	 * @return the logOnTime
	 */
	public String getLogOnTime() {
		return logOnTime;
	}
	/**
	 * @param logOnTime the logOnTime to set
	 */
	public void setLogOnTime(String logOnTime) {
		this.logOnTime = logOnTime;
	}
	/**
	 * @return the logOffTime
	 */
	public String getLogOffTime() {
		return logOffTime;
	}
	/**
	 * @param logOffTime the logOffTime to set
	 */
	public void setLogOffTime(String logOffTime) {
		this.logOffTime = logOffTime;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	                
	public long getDuration() throws DateTimeException{
		// Parse logon and logoff times into LocalTime objects
		LocalTime logonTime = LocalTime.parse(this.logOnTime);
		LocalTime logoffTime = LocalTime.parse(this.logOffTime);
		
		// calculate the difference between the times 
		Duration duration = Duration.between(logonTime, logoffTime);

	// get the difference in minutes
		return duration.toMinutes();
	}
	
	public void displayAll() {
		System.out.println("Student: "+this.name);
		System.out.println("Student Number: "+ this.studentNumber);
		System.out.println("Log on time: "+this.logOnTime);
		System.out.println("Log off time: "+this.logOffTime);
		System.out.println("Email: "+this.email);
		System.out.println();
	}
}
