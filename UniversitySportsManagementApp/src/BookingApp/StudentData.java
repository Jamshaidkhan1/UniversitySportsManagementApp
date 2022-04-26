package BookingApp;

public class StudentData {
	private String student_name;
	private String student_id;
	private String student_status;
	public StudentData(String std_name, String std_id, String std_status)
	{
		super();
		this.student_name   =   std_name;
		this.student_id     =   std_id;
		this.student_status =   std_status;
	}
	public String get_student_name() {
		return student_name;
	}
	public void set_student_name(String stdName) {
		this.student_name = stdName;
	}
	public String get_student_id() {
		return student_id;
	}
	public void setStudetid(String std_id) {
		this.student_id = std_id;
	}
	public String get_student_status() {
		return student_status;
	}
	public void set_student_status(String std_status) {
		this.student_status = std_status;
	}
	@Override
	public String toString()
	{
		return "Students [Student Name: " +student_name+"Student ID: "+student_id+"Student Status: "+student_status+"]";
	}	

}
