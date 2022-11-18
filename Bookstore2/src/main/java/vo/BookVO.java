package vo;

public class BookVO {
	
	private int bookId;
	private String bookname;
	private String publisher;
	private int price;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
		
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setBookId(String bookId) {
		this.bookId = Integer.parseInt(bookId);
	}
	public void setPrice(String price) {
		this.price = Integer.parseInt(price);
	}
	
}
