package BookingApp;

public class Lessons {
	
	private int lesson_id;
	private String lesson_name;
	private int lesson_price;
	
	public Lessons(int lessonId, String lessonName, int lessonPrice) {
		super();
		this.lesson_id = lessonId;
		this.lesson_name = lessonName;
		this.lesson_price = lessonPrice;
	}
	public int get_Lesson_id() {
		return lesson_id;
	}
	public void set_Lesson_id(int lessonId) {
		this.lesson_id = lessonId;
	}
	public String get_Lesson_name() {
		return lesson_name;
	}
	public void set_Lesson_name(String lessonName) {
		this.lesson_name = lessonName;
	}
	public int get_Lesson_price() {
		return lesson_price;
	}
	public void set_Lesson_price(int lessonPrice) {
		this.lesson_price = lessonPrice;
	}
	@Override
	public String toString() {
		return "Lessons [Lesson id: "+ lesson_id + ", Lesson Name: " + lesson_name + ", Lesson Price: "+ lesson_price +"]"; 
	
	}
	

}
