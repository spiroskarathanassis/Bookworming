import java.util.ArrayList;

public class Shoppingbasket {
	private int userId;
	private int purchaseId;
	private double purchaseSum;
	private ArrayList<Book> purchasedBooks;
	
	public Shoppingbasket(int userId, int purchaseId, ArrayList<Book> purchasedBooks) {
		this.userId = userId;
		this.purchaseId = purchaseId;
		this.purchaseSum = 0;
		this.purchasedBooks = purchasedBooks;
	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public double getPurchaseSum() {
		return purchaseSum;
	}

	public void setPurchaseSum(double sum) {
		this.purchaseSum += sum;
	}

	public int getUserId() {
		return userId;
	}

	public ArrayList<Book> getPurchasedBooks() {
		return purchasedBooks;
	}
	
	public void addΤοBasket(Book b) {
		this.purchaseSum += b.getprice();
		this.purchasedBooks.add(b);
	}
	
	public void addListToBasket(ArrayList<Book> bookList) {
		for (Book b : bookList) {
			this.purchaseSum += b.getprice();
			this.purchasedBooks.add(b);
		}
	}
	
	public boolean checkForBooks() {
		for (Book b : this.purchasedBooks) {
			if (!b.checkAvailability(b.id)) {
				return false;
			}
		}
		
		return true;
	}
	
	public double applyDiscount(User user) {
		int currentPoints = user.getPoints();
		
		if (currentPoints > 30) {
			return 0.05;
		}
		if (currentPoints > 70) {
			return 0.20;
		}
		if (currentPoints > 100) {
			return 0.5;
		}
		
		return 0;
	}
	
	
}
