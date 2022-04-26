package BookingApp;



public class ReviewsAndRatings {
	
	private static int autoIncrementId=1;
	private int reviewId;
	private int reviewRate;
	private String review;
	private StudentData reviewdBy;
	private Lessons reviewedLesson;
	
	public ReviewsAndRatings(int reviewRate, String review, StudentData reviewdBy, Lessons reviewedLesson) {
		super();
		this.reviewId = autoIncrementId;
		this.reviewRate = reviewRate;
		this.review = review;
		this.reviewdBy = reviewdBy;
		this.reviewedLesson = reviewedLesson;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getReviewRate() {
		return reviewRate;
	}
	public void setReviewRate(int reviewRate) {
		this.reviewRate = reviewRate;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public StudentData getReviewdBy() {
		return reviewdBy;
	}
	public void setReviewdBy(StudentData reviewdBy) {
		this.reviewdBy = reviewdBy;
	}
	public Lessons getReviewedLesson() {
		return reviewedLesson;
	}
	public void setReviewedLesson(Lessons reviewedLesson) {
		this.reviewedLesson = reviewedLesson;
	}

}
