import java.util.List;

public class Publisher {
	private String name;
	private String email;
	private List<Book> publishBooks;
	
	public Publisher(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public List<Book> getPublishBooks() {
		return publishBooks;
	}

	public void setPublishBooks(List<Book> pBooks) {
		this.publishBooks = pBooks;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	public void addBookToPublisher(Book book) {
		this.publishBooks.add(book);
	}
		
}
