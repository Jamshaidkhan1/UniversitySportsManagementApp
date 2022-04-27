package BookingApp;

import java.util.ArrayList;

import BookingApp.Lessons;
import BookingApp.StudentData;

public class Schedular {
	private static int autoIncrementId=1;
	private int timeTableid;
	private String day;

	private Lessons moringLesson;
	private Lessons afternoonLesson;
	private Lessons eveningLesson;
	
	private ArrayList<StudentData> moringBatch;
	private ArrayList<StudentData> afternoonBatch;
	private ArrayList<StudentData> eveningBatch;
	
	public Schedular(String day,Lessons moringLesson,Lessons afternoonLesson, Lessons eveningLesson) {
		this.timeTableid = autoIncrementId;
		this.day = day;
		this.moringLesson = moringLesson;
		this.afternoonLesson = afternoonLesson;
		this.eveningLesson = eveningLesson;
		autoIncrementId++;
		moringBatch=new ArrayList<StudentData>();
		afternoonBatch=new ArrayList<StudentData>();
		eveningBatch=new ArrayList<StudentData>();
	}

	public int getTimeTableid() {
		return timeTableid;
	}

	public void setTimeTableid(int timeTableid) {
		this.timeTableid = timeTableid;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Lessons getMoringLesson() {
		return moringLesson;
	}

	public void setMoringLesson(Lessons moringLesson) {
		this.moringLesson = moringLesson;
	}

	public Lessons getAfternoonLesson() {
		return afternoonLesson;
	}

	public void setAfternoonLesson(Lessons afternoonLesson) {
		this.afternoonLesson = afternoonLesson;
	}

	public Lessons getEveningLesson() {
		return eveningLesson;
	}

	public void setEveningLesson(Lessons eveningLesson) {
		this.eveningLesson = eveningLesson;
	}

	public ArrayList<StudentData> getMoringBatch() {
		return moringBatch;
	}

	public boolean setMoringBatch(StudentData student) {
		if(!this.moringBatch.contains(student))
		{
			if(this.moringBatch.size()<4)
			{
				this.moringBatch.add(student);
				System.out.println("You added To "+this.getMoringLesson().get_Lesson_name()+" Batch On "+this.getDay());
				return true;
			}else
			{
				System.out.println(this.getMoringLesson().get_Lesson_name()+" Batch On "+this.getDay()+" Is Full");
				return false;
			}
		}
		else
		{
			System.out.println("You "+student.get_student_name()+" allready Booked This");
			return false;
		}
	}
	
	
	public void removeMoringBatch(StudentData student) {
		if(this.moringBatch.contains(student))
		{
			this.moringBatch.remove(student);
			System.out.println("You Removed From "+this.getMoringLesson().get_Lesson_name()+" Batch On "+this.getDay());
		}
		else
		{
			System.out.println("You "+student.get_student_name()+" Not Booked This");
		}
	}
	
	
	

	public ArrayList<StudentData> getAfternoonBatch() {
		return afternoonBatch;
	}

	public boolean setAfternoonBatch(StudentData student) {
		if(!this.afternoonBatch.contains(student))
		{
			if(this.afternoonBatch.size()<4)
			{
				this.afternoonBatch.add(student);
				System.out.println("You added To "+this.getAfternoonLesson().get_Lesson_name()+" Batch On "+this.getDay());
				return true;
			}else
			{
				System.out.println(this.getAfternoonLesson().get_Lesson_name()+" Batch On "+this.getDay()+" Is Full");
				return false;
			}
		}
		else
		{
			System.out.println("You "+student.get_student_name()+" allready Booked This");
			return false;
		}
	}
	
	
	public void removeAfternoonBatch(StudentData student) {
		if(this.afternoonBatch.contains(student))
		{
			this.afternoonBatch.remove(student);
			System.out.println("You Removed From "+this.getAfternoonLesson().get_Lesson_name()+" Batch On "+this.getDay());
		}
		else
		{
			System.out.println("You "+student.get_student_name()+" Not Booked This");
		}
	}
	
	public ArrayList<StudentData> getEveningBatch() {
		return eveningBatch;
	}

	public boolean setEveningBatch(StudentData student) {
		if(!this.eveningBatch.contains(student))
		{
			if(this.eveningBatch.size()<4)
			{
				this.eveningBatch.add(student);
				System.out.println("You added To "+this.getEveningLesson().get_Lesson_name()+" Batch On "+this.getDay());
				return true;
			}else
			{
				System.out.println(this.getEveningLesson().get_Lesson_name()+" Batch On "+this.getDay()+" Is Full");
				return false;
			}
		}
		else
		{
			System.out.println("You "+student.get_student_name()+" allready Booked This");
			return false;
		}
	}
	
	public void removeEveningBatch(StudentData student) {
		if(this.eveningBatch.contains(student))
		{
			this.eveningBatch.remove(student);
			System.out.println("You Removed From "+this.getEveningLesson().get_Lesson_name()+" Batch On "+this.getDay());
		}
		else
		{
			System.out.println("You "+student.get_student_name()+" Not Booked This");
		}
	}
	
	@Override
	public String toString() {
		return "TimeTable [timeTableid=" + timeTableid + ", day=" + day + ", moringLesson="
				+ moringLesson + ", afternoonLesson=" + afternoonLesson + ", eveningLesson=" + eveningLesson
				+ ", moringBatch=" + moringBatch + ", afternoonBatch=" + afternoonBatch + ", eveningBatch="
				+ eveningBatch + "]";
	}
	

}
