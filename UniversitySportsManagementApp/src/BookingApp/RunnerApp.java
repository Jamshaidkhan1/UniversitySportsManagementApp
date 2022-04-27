package BookingApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import BookingApp.Lessons;
import BookingApp.ReviewsAndRatings;
import BookingApp.Schedular;
import BookingApp.StudentData;



public class RunnerApp {
	
	
	
	

		
	public static List<StudentData> allStudent=new ArrayList<StudentData>();
	public static List<Lessons> allLessons=new ArrayList<Lessons>();
	public static List<Schedular> timeTable=new ArrayList<Schedular>();
	public static List<ReviewsAndRatings> reviewsAll=new ArrayList<ReviewsAndRatings>();
    public static void main(String[] args) {
        
       createStudents();
		createLessons();
		createTimetable();
		
		//printDetails();
		Scanner sc=new Scanner(System.in);
		int option = 0;
		while(true)
		{
			System.out.println("1 : Please Select this option for Booking your exercise");
			System.out.println("2 : Please use this option for chaning your bookings");
			System.out.println("3 : Please Select this option for participating in lessons");
			System.out.println("4 : Would you like to produce monthly Report for lesson?");
			System.out.println("5 : Would you like to produce Monthly income Report?");
			
			option=sc.nextInt();
			switch (option) {
				case 1:
					bookExercise();
					break;
				case 2:
					changeBooking();
					break;
				case 3:
					attendingALesson();
					break;
				case 4:
					monthlyLessonReport();
					break;
				case 5:
					MonthlyincomeExerciseReport();
					break;
				
				
				default:
					System.out.println("The entered option is not available?");
					break;
			}
			//printDetails();
	}
	
}
	
	public static void MonthlyincomeExerciseReport() {
		int option,timeTableID,timingId;
		Scanner sc=new Scanner(System.in);
		System.out.println("This is MONTHLY REPORT for University Sports center Booking Application");
		System.out.println("Please enter the month for which you want the report :");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		option =sc.nextInt();
		if(option>=1&&option<=12)
		{
			int weekEnd=option*4;
			int weekStart=weekEnd-3;
			int lesson1=0,lesson2=0,lesson3=0,lesson4=0;
			ArrayList<Integer> totalIncome=new ArrayList<Integer>();
			totalIncome.add(0);
			totalIncome.add(0);
			totalIncome.add(0);
			totalIncome.add(0);
			System.out.println(totalIncome);
			for(int i=weekStart;i<=weekEnd;i++)
			{
				Schedular temp=timeTable.get(i-1);
				//System.out.println(temp);
				//for Yoga Lesson
				
				if(temp.getMoringLesson().get_Lesson_id()==1)
					totalIncome.set(0, totalIncome.get(0)+temp.getMoringBatch().size()*temp.getMoringLesson().get_Lesson_price());
				if(temp.getAfternoonLesson().get_Lesson_id()==1)
					totalIncome.set(0, totalIncome.get(0)+temp.getAfternoonBatch().size()*temp.getAfternoonLesson().get_Lesson_price());
				if(temp.getEveningLesson().get_Lesson_id()==1)
							totalIncome.set(0, totalIncome.get(0)+temp.getEveningBatch().size()*temp.getEveningLesson().get_Lesson_price());
				
				
				if(temp.getMoringLesson().get_Lesson_id()==2)
					totalIncome.set(1, totalIncome.get(1)+temp.getMoringBatch().size()*temp.getMoringLesson().get_Lesson_price());
				if(temp.getAfternoonLesson().get_Lesson_id()==2)
					totalIncome.set(1, totalIncome.get(1)+temp.getAfternoonBatch().size()*temp.getAfternoonLesson().get_Lesson_price());
				if(temp.getEveningLesson().get_Lesson_id()==1)
							totalIncome.set(1, totalIncome.get(1)+temp.getEveningBatch().size()*temp.getEveningLesson().get_Lesson_price());
				
				if(temp.getMoringLesson().get_Lesson_id()==3)
					totalIncome.set(2, totalIncome.get(2)+temp.getMoringBatch().size()*temp.getMoringLesson().get_Lesson_price());
				if(temp.getAfternoonLesson().get_Lesson_id()==3)
					totalIncome.set(2, totalIncome.get(2)+temp.getAfternoonBatch().size()*temp.getAfternoonLesson().get_Lesson_price());
				if(temp.getEveningLesson().get_Lesson_id()==3)
							totalIncome.set(2, totalIncome.get(2)+temp.getEveningBatch().size()*temp.getEveningLesson().get_Lesson_price());
				
				if(temp.getMoringLesson().get_Lesson_id()==4)
					totalIncome.set(3, totalIncome.get(3)+temp.getMoringBatch().size()*temp.getMoringLesson().get_Lesson_price());
				if(temp.getAfternoonLesson().get_Lesson_id()==4)
					totalIncome.set(3, totalIncome.get(3)+temp.getAfternoonBatch().size()*temp.getAfternoonLesson().get_Lesson_price());
				if(temp.getEveningLesson().get_Lesson_id()==4)
							totalIncome.set(3, totalIncome.get(3)+temp.getEveningBatch().size()*temp.getEveningLesson().get_Lesson_price());
				
			}
			System.out.println("******MONTHLY INCOME EXERCISE REPORT**********");
			System.out.println("1: YOGA      \t\t"+"TOTAL INCOME : "+totalIncome.get(0));
			System.out.println("2: Zumba     \t\t"+"TOTAL INCOME : "+totalIncome.get(1));
			System.out.println("3: Aquacise  \t\t"+"TOTAL INCOME : "+totalIncome.get(2));
			System.out.println("4: Cycling   \t\t"+"TOTAL INCOME : "+totalIncome.get(3));
			
			
		}
		
	}

	public static void monthlyLessonReport() {
		int option,timeTableID,timingId;
		Scanner sc=new Scanner(System.in);
		System.out.println("*****MONTHLY REPORT*****");
		System.out.println("Please Enter Your Month Number :");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		option =sc.nextInt();
		if(option>=1&&option<=12)
		{
			int weekEnd=option*4;
			int weekStart=weekEnd-3;
			int lesson1=0,lesson2=0,lesson3=0,lesson4=0;
			ArrayList<Integer> totalStudents=new ArrayList<Integer>();
			totalStudents.add(0);
			totalStudents.add(0);
			totalStudents.add(0);
			totalStudents.add(0);
			System.out.println(totalStudents);
			for(int i=weekStart;i<=weekEnd;i++)
			{
				Schedular temp=timeTable.get(i-1);
				//System.out.println(temp);
				//for Yoga Lesson
				
				if(temp.getMoringLesson().get_Lesson_id()==1)
					totalStudents.set(0, totalStudents.get(0)+temp.getMoringBatch().size());
				if(temp.getAfternoonLesson().get_Lesson_id()==1)
					totalStudents.set(0, totalStudents.get(0)+temp.getAfternoonBatch().size());
				if(temp.getEveningLesson().get_Lesson_id()==1)
							totalStudents.set(0, totalStudents.get(0)+temp.getEveningBatch().size());
				
				
				if(temp.getMoringLesson().get_Lesson_id()==2)
					totalStudents.set(1, totalStudents.get(1)+temp.getMoringBatch().size());
				if(temp.getAfternoonLesson().get_Lesson_id()==2)
					totalStudents.set(1, totalStudents.get(1)+temp.getAfternoonBatch().size());
				if(temp.getEveningLesson().get_Lesson_id()==1)
							totalStudents.set(1, totalStudents.get(1)+temp.getEveningBatch().size());
				
				if(temp.getMoringLesson().get_Lesson_id()==3)
					totalStudents.set(2, totalStudents.get(2)+temp.getMoringBatch().size());
				if(temp.getAfternoonLesson().get_Lesson_id()==3)
					totalStudents.set(2, totalStudents.get(2)+temp.getAfternoonBatch().size());
				if(temp.getEveningLesson().get_Lesson_id()==3)
							totalStudents.set(2, totalStudents.get(2)+temp.getEveningBatch().size());
				
				if(temp.getMoringLesson().get_Lesson_id()==4)
					totalStudents.set(3, totalStudents.get(3)+temp.getMoringBatch().size());
				if(temp.getAfternoonLesson().get_Lesson_id()==4)
					totalStudents.set(3, totalStudents.get(3)+temp.getAfternoonBatch().size());
				if(temp.getEveningLesson().get_Lesson_id()==4)
							totalStudents.set(3, totalStudents.get(3)+temp.getEveningBatch().size());
				
			}
			
			ArrayList<Integer> hits=new ArrayList<Integer>();
			ArrayList<Integer> totalRating=new ArrayList<Integer>();
			for (int i = 0; i <5; i++) {
				hits.add(0);
				totalRating.add(0);
			}
			for (ReviewsAndRatings review : reviewsAll) {
				if(review.getReviewedLesson().get_Lesson_id()==1)
				{
					hits.set(0, hits.get(0)+1);
					totalRating.set(0, totalRating.get(0)+review.getReviewRate());
				}
				if(review.getReviewedLesson().get_Lesson_id()==2)
				{
					hits.set(1, hits.get(1)+1);
					totalRating.set(1, totalRating.get(1)+review.getReviewRate());
				}
				if(review.getReviewedLesson().get_Lesson_id()==3)
				{
					hits.set(2, hits.get(2)+1);
					totalRating.set(2, totalRating.get(2)+review.getReviewRate());
				}
				if(review.getReviewedLesson().get_Lesson_id()==4)
				{
					hits.set(3, hits.get(3)+1);
					totalRating.set(3, totalRating.get(3)+review.getReviewRate());
				}
			}
			int result1=0,result2 = 0,result3=0,result4=0;
			try {result1=totalRating.get(0)/hits.get(0);}catch (Exception e) {result1=0;}
			try {result2=totalRating.get(1)/hits.get(1);}catch (Exception e) {result1=0;}
			try {result3=totalRating.get(2)/hits.get(2);}catch (Exception e) {result1=0;}
			try {result4=totalRating.get(3)/hits.get(3);}catch (Exception e) {result1=0;}
			
			//System.out.println(totalStudents);
			System.out.println("MONTHLY LESSON REPORT");
			System.out.println("LESSON YOGA      \t\t"+"TOTAL STUDENTS : "+totalStudents.get(0)+"\t\t AVG REVIEW RATE :"+result1);
			System.out.println("LESSON Zumba     \t\t"+"TOTAL STUDENTS : "+totalStudents.get(1)+"\t\t AVG REVIEW RATE :"+result2);
			System.out.println("LESSON Aquacise  \t\t"+"TOTAL STUDENTS : "+totalStudents.get(2)+"\t\t AVG REVIEW RATE :"+result3);
			System.out.println("LESSON Cycling   \t\t"+"TOTAL STUDENTS : "+totalStudents.get(3)+"\t\t AVG REVIEW RATE :"+result4);
		}
		else
			System.out.println("Invalid Month..");
		
		
	}

	public static void attendingALesson() {
		StudentData student=signedStudent();
		Schedular temp = null;
		if(student==null)
			return;
		int option,timeTableID,timingId;
		Scanner sc=new Scanner(System.in);
		System.out.println("ATTENDING A LESSON");
		System.out.println("Please Enter Your Booking ID :");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		timeTableID =sc.nextInt();
		try
		{
			temp=timeTable.get(timeTableID-1);
			//System.out.println(temp);
		}catch (Exception e) {
			System.out.println("You have enterd Invalid Booking ID. Please try again later");
		}
		
		System.out.println("Please enter the session timings of your classes");
		System.out.println("1.Morning Session");
		System.out.println("2.Afternoon Session");
		System.out.println("3.Evening Session");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		timingId =sc.nextInt();
		if(timingId==1)
		{
			ArrayList<StudentData> allbatchStudent=temp.getMoringBatch();
			for (StudentData stud : allbatchStudent) {
				if(stud.get_student_id().equals(student.get_student_id()))
				{
					writeReview(stud,temp.getMoringLesson());
					
					stud.set_student_status("Attended");
					
					break;
				}
				else
				{
					System.out.println("You have not been book for this session");
				}
			}

		}else if(timingId==2)
		{
			ArrayList<StudentData> allbatchStudent=temp.getAfternoonBatch();
			for (StudentData stud : allbatchStudent) {
				if(stud.get_student_id().equals(student.get_student_id()))
				{
					writeReview(stud,temp.getAfternoonLesson());
					stud.set_student_status("You have Attended this session");
					break;
				}
				else
				{
					System.out.println("You have not been booked for this session");
				}
			}

		}else if(timingId==3)
		{
			ArrayList<StudentData> allbatchStudent=temp.getEveningBatch();
			for (StudentData stud : allbatchStudent) {
				if(stud.get_student_id().equals(student.get_student_id()))
				{
					writeReview(stud,temp.getEveningLesson());
					stud.set_student_status("You have Attended this session");
					break;
				}
				else
				{
					System.out.println("You have not been booked for this session");
				}
			}
		
		}
		else
			System.out.println("Your entered session timings are not valid. Please try again");	
		
	}

	public static void writeReview(StudentData stud, Lessons lesson) {
		int option,rating;
		Scanner sc=new Scanner(System.in);
		String review;
		System.out.println("Please leave your feedback here");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		review=sc.nextLine();
		System.out.println("Please enter the ratings for this lesson :");
		System.out.println("Important detail: Ratings Should be between 1-5 ");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		rating=sc.nextInt();
		if(rating<=5&&rating>=1)
		{
			ReviewsAndRatings r=new ReviewsAndRatings(rating, review, stud, lesson);
			reviewsAll.add(r);
			System.out.println("Your feedback is added to the system");
		}
		else
			System.out.println("Invalid Rating");
		
	}

	public static void changeBooking() {
		StudentData student=signedStudent();
		Schedular temp = null;
		if(student==null)
			return;
		int option,timeTableID,timingId;
		Scanner sc=new Scanner(System.in);
		System.out.println("MENU FOR NEW LESSON SELECTION");
		System.out.println("Please Enter Your Booking ID :");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		timeTableID =sc.nextInt();
		try
		{
			temp=timeTable.get(timeTableID-1);
		}catch (Exception e) {
			System.out.println("Your entered Booking ID is invalid. Please try again later...");
		}
		System.out.println("Please enter session timings");
		System.out.println("1.Morning session");
		System.out.println("2.Afternoon session");
		System.out.println("3.Evening session");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		timingId =sc.nextInt();
		int status=changeExercise(student);
		if(status==1)
		{
			if(timingId==1)
			{
				temp.removeMoringBatch(student);
				return;
			}else if(timingId==2)
			{
				temp.removeAfternoonBatch(student);
				return;
			}else if(timingId==3)
			{
				temp.removeEveningBatch(student);
				return;
			}
			else
				System.out.println("Your booking timings are invalid. Please try again later");	
			System.out.println("You have successfully changed your bookings");
			
		}else
		{
			System.out.println("STATUS : "+status);
		}
		
	}

	public static int changeExercise(StudentData student) {
		Scanner sc=new Scanner(System.in);
		int option,timeTableID,timingId;
		String choice,day,lesson;
		Schedular temp = null;
		System.out.println("Showing timetable using day");
		
		option =1;
		if(option==1)
		{
			System.out.println("Please Choose Saturday or Sunday");
			sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			day=sc.nextLine();
			System.out.println("You Selected : "+day);
			
			for (Schedular timetable : timeTable) {
				if(timetable.getDay().equalsIgnoreCase(day))
				{
					System.out.println("id :"+timetable.getTimeTableid()+" "+timetable.getDay()+" Morning :"+timetable.getMoringLesson().get_Lesson_name()
							+" After Noon :"+timetable.getAfternoonLesson().get_Lesson_name()
							+" Evening :"+timetable.getEveningLesson().get_Lesson_name());
					
				}
			}
			System.out.println("Please Select New Bookings session by using ID");
			sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			timeTableID =sc.nextInt();
			try {
				temp=timeTable.get(timeTableID-1);
			}catch (Exception e) {
				System.out.println("You Selected Invalid Time Table ID");
				return 0;
			}
			System.out.println("Please Select The Timing ");
			System.out.println("1.Morning session");
			System.out.println("2.Afternoon session");
			System.out.println("3.Evening session");
			timeTableID =sc.nextInt();
			System.out.println("***********Student Details/info*************");
			if(timeTableID==1)
			{
				temp.setMoringBatch(student);
				System.out.println("Here are Your booking details = Session Morning , BOOKING ID :"+temp.getTimeTableid()+" , Day "+temp.getDay()+" Lesson : "+temp.getMoringLesson().get_Lesson_name());
				return 1;
			}else if(timeTableID==2)
			{
				temp.setAfternoonBatch(student);
				System.out.println("Here are Your booking details = Session After Noon, BOOKING ID :"+temp.getTimeTableid()+" ,Day "+temp.getDay()+" Lesson : "+temp.getAfternoonLesson().get_Lesson_name());
				return 1;
			}else if(timeTableID==3)
			{
				temp.setEveningBatch(student);
				System.out.println("Here are Your booking details = Session Evening , BOOKING ID :"+temp.getTimeTableid()+" , Day "+temp.getDay()+" Lesson : "+temp.getEveningLesson().get_Lesson_name());
				return 1;
			}
			else
				System.out.println("You have entered Invalid session timing. Please try again later...");
				return 0;
		}
		return 0;
		}	
	
	public static StudentData signedStudent()
	{
		//System.out.println("@@@@@STUDENT LOGIN PAGE@@@@@");
		Scanner sc=new Scanner(System.in);
		StudentData temp = null;
		int studentId;
		System.out.println("***Please enter student ID between 1 & 12***:");
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		studentId =sc.nextInt();
		try {
			temp=allStudent.get(studentId-1);
		} catch (Exception e) {
			System.out.println("Your Entered Student ID is Wrong. Pleaes enter new student ID");
		}
		return temp;
	}
	public static void bookExercise() {
		StudentData student=signedStudent();
		if(student==null)
			return;
		Scanner sc=new Scanner(System.in);
		int option,timeTableID,timingId;
		String choice,day,lesson;
		Schedular temp = null;
		System.out.println("Please check the lesson schedule either day wise or lesson Name wise");
		System.out.println("1.Please enter this option if you want to book session using day");
		System.out.println("2.Please enter this option if you want to book session using lesson Name");
		option =sc.nextInt();
		if(option==1)
		{
			System.out.println("Saturday session or Sunday session");
			sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			day=sc.nextLine();
			System.out.println("Your Selected day is : "+day);
			
			for (Schedular timetable : timeTable) {
				if(timetable.getDay().equalsIgnoreCase(day))
				{
					System.out.println("id :"+timetable.getTimeTableid()+" "+timetable.getDay()+" Morning Session:"+timetable.getMoringLesson().get_Lesson_name()
							+" After Noon Session:"+timetable.getAfternoonLesson().get_Lesson_name()
							+" Evening Session:"+timetable.getEveningLesson().get_Lesson_name());
					
				}
			}
			System.out.println("Please enter the session ID for booking");
			sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			timeTableID =sc.nextInt();
			try {
				temp=timeTable.get(timeTableID-1);
			}catch (Exception e) {
				System.out.println("Your entered time table ID is invalid");
			}
			System.out.println("Please enter the session ");
			System.out.println("1.Morning session");
			System.out.println("2.Afternoon session");
			System.out.println("3.Evening session");
			timeTableID =sc.nextInt();
			System.out.println("***********Important info*************");
			if(timeTableID==1&&temp.setMoringBatch(student))
			{
				student.set_student_status("You been booked for session");
				
				
				System.out.println("Here are Your booking details = Session Morning , BOOKING ID :"+temp.getTimeTableid()+" , Day "+temp.getDay()+" Lesson : "+temp.getMoringLesson().get_Lesson_name());
				
			}else if(timeTableID==2 &&temp.setAfternoonBatch(student))
			{
				student.set_student_status("You have been booked for this session");
				
				System.out.println("Here are Your booking details = Session After Noon, BOOKING ID :"+temp.getTimeTableid()+" ,Day "+temp.getDay()+" Lesson : "+temp.getAfternoonLesson().get_Lesson_name());
				
			}else if(timeTableID==3&&temp.setEveningBatch(student))
			{
				student.set_student_status("You been booked for session");
				
				System.out.println("Here are Your booking details = Session Evening , BOOKING ID :"+temp.getTimeTableid()+" , Day "+temp.getDay()+" Lesson : "+temp.getEveningLesson().get_Lesson_name());
				
			}
			else
				System.out.println("Your session timings are Invalid. Please enter new timings");
			
			
		}
		else if(option==2)
		{
			System.out.println("Yoga,Zumba,Aquacise,Cycling");
			sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			lesson=sc.nextLine();
			System.out.println("You have Selected : "+lesson);
			for (Schedular timetable : timeTable) {
				if(timetable.getMoringLesson().get_Lesson_name().equalsIgnoreCase(lesson)||timetable.getAfternoonLesson().get_Lesson_name().equalsIgnoreCase(lesson)||timetable.getAfternoonLesson().get_Lesson_name().equalsIgnoreCase(lesson)) {
					System.out.println("id :"+timetable.getTimeTableid()+" "+timetable.getDay()+" Morning session :"+timetable.getMoringLesson().get_Lesson_name()
							+" Afternoon session :"+timetable.getAfternoonLesson().get_Lesson_name()
							+" Evening session :"+timetable.getEveningLesson().get_Lesson_name());
				}
				}
			System.out.println("Please Select The Booking by using timetable id");
			sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			timeTableID =sc.nextInt();
			try {
				temp=timeTable.get(timeTableID-1);
			}catch (Exception e) {
				System.out.println("You have entered Invalid Time Table ID");
			}
			System.out.println("Please enter the timing for : "+lesson);
			System.out.println("1.Morning session");
			System.out.println("2.Afternoon session");
			System.out.println("3.Evening session");
			timeTableID =sc.nextInt();
			if(timeTableID==1&&temp.setMoringBatch(student))
			{
				//temp.setMoringBatch(student);
				System.out.println("Here are Your booking details = Session Morning , BOOKING ID :"+temp.getTimeTableid()+" , Day "+temp.getDay()+" Lesson : "+temp.getMoringLesson().get_Lesson_name());
			}else if(timeTableID==2&&temp.setAfternoonBatch(student))
			{
				temp.setAfternoonBatch(student);
				System.out.println("Here are Your booking details = Session After Noon, BOOKING ID :"+temp.getTimeTableid()+" ,Day "+temp.getDay()+" Lesson : "+temp.getAfternoonLesson().get_Lesson_name());
				
			}else if(timeTableID==3&&temp.setEveningBatch(student))
			{
				//temp.setEveningBatch(student);
				System.out.println("Here are Your booking details = Session Evening , BOOKING ID :"+temp.getTimeTableid()+" , Day "+temp.getDay()+" Lesson : "+temp.getEveningLesson().get_Lesson_name());
				
			}
			else
				System.out.println("Your session timings are Invalid. Please enter new timings");
			
			
		}
		else
		{
			System.out.println("Your option is Invalid. Please reenter your new option");
		}
		}
	public static void printDetails() {

		for (Schedular timetable : timeTable) {
			System.out.println(timetable);
		}
		
	}

	public static boolean createTimetable() {
		int min=0;
		int max=allLessons.size()-1;
		String day = null;
		int totalWeeks=48;
		for(int i=0;i<totalWeeks;i++)
		{
			int moring = ThreadLocalRandom.current().nextInt(min, max + 1);
			int afternoon = ThreadLocalRandom.current().nextInt(min, max + 1);
			int evening = ThreadLocalRandom.current().nextInt(min, max + 1);
			//System.out.println(morning+"  "+afternoon+" "+evening);
			if(i%2==0)
			{
				day="Saturday";
			}
			else
				day="Sunday";
			Schedular t1=new Schedular(day,allLessons.get(moring),allLessons.get(afternoon) ,allLessons.get(evening));
			timeTable.add(t1);
		}
		return true;
	}
	public static boolean createLessons() {
		Lessons lesson_1=new Lessons(1, "Yoga", 100);
		Lessons lesson_2=new Lessons(2, "Zumba", 200);
		Lessons lesson_3=new Lessons(3, "Aquacise", 80);
		Lessons lesson_4=new Lessons(4, "Cycling", 30);
		allLessons.add(lesson_1);
		allLessons.add(lesson_2);
		allLessons.add(lesson_3);
		allLessons.add(lesson_4);
		return true;
	}
	public static boolean createStudents() {
		StudentData student_1=new StudentData("Ayaan", "1","Not booked");
		StudentData student_2=new StudentData("Khan",  "2","Not booked");
		StudentData student_3=new StudentData("Sophie","3","Not booked");
		StudentData student_4=new StudentData("Keren", "4","Not booked");
		StudentData student_5=new StudentData("Natasha","5","Not booked");
		StudentData student_6=new StudentData("Marie", "6","Not booked");
		StudentData student_7=new StudentData("Albana", "7","Not booked");
		StudentData student_8=new StudentData("Watson", "8","Not booked");
		StudentData student_9=new StudentData("Warner", "9","Not booked");
		StudentData student_10=new StudentData("Jacob", "10","Not booked");
		StudentData student_11=new StudentData("Priya", "11","Not booked");
		StudentData student_12=new StudentData("Rowland", "12","Not booked");
		allStudent.add(student_1);
		allStudent.add(student_2);
		allStudent.add(student_3);
		allStudent.add(student_4);
		allStudent.add(student_5);
		allStudent.add(student_6);
		allStudent.add(student_7);
		allStudent.add(student_8);
		allStudent.add(student_9);
		allStudent.add(student_10);
		allStudent.add(student_11);
		allStudent.add(student_12);
		return true;
	}


}