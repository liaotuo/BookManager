package entity;

public class Book{
	private String bookid;
	private String author;
	private String isbn10;
	private String isbn13;
	private String price;
	private String pubdate;
	private String publisher;
	private String title;

	public Book() {
	}

	public String getBookid() {
		return this.bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn10() {
		return this.isbn10;
	}

	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}

	public String getIsbn13() {
		return this.isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "TBookinfo [bookid=" + bookid + ", author=" + author + ", isbn10=" + isbn10 + ", isbn13=" + isbn13
				+ ", price=" + price + ", pubdate=" + pubdate + ", publisher=" + publisher + ", title=" + title + "]";
	}

	
}