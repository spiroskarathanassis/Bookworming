package com.example.Bookworming;

public class Reviews /* extends Book*/{
	private int id;
	private int stars;
	private int reviewers;
	private double sumBookReview = 0;
	
	public Reviews(int id) {
//		super(title);
		this.id = id;
		this.stars = 0;
		this.reviewers = 0;
	}
	
	public int getId() {
		return id;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars += stars;
	}

	public int getReviewrs() {
		return reviewers;
	}

	public void setReviewers() {
		this.reviewers++ ;
	}
	
	public void addReview(int reviewStars) {
		if (reviewStars > 0 && reviewStars <= 5) {
			this.stars += reviewStars;
			this.reviewers++;
			this.sumBookReview = stars / reviewers;
			saveReview(sumBookReview);
		} else {
			displayFailReviewMessage();
		}
	}
	
	public void saveReview(double sum) {
		// insert into database
	}
	
	public void displayFailReviewMessage() {
		System.out.println("Your review failed. Please set a star between 1-5!");
	}
	
	public void exportSum() {
		System.out.println("This book has " + this.sumBookReview + " stars");
	}
		
}
