package entity;

public class SearchBook {
	private String searchTitle;
	private String searchISBN;
	private String searchAuthor;
	private String searchminPrice;
	private String searchmaxPrice;
	
	public SearchBook(String searchTitle, String searchISBN, String searchAuthor, String searchminPrice,
			String searchmaxPrice) {
		this.searchTitle = searchTitle;
		this.searchISBN = searchISBN;
		this.searchAuthor = searchAuthor;
		this.searchminPrice = searchminPrice;
		this.searchmaxPrice = searchmaxPrice;
	}
	public SearchBook(){
		
	}
	public String getSearchTitle() {
		return searchTitle;
	}
	public void setSearchTitle(String searchTitle) {
		this.searchTitle = searchTitle;
	}
	public String getSearchISBN() {
		return searchISBN;
	}
	public void setSearchISBN(String searchISBN) {
		this.searchISBN = searchISBN;
	}
	public String getSearchAuthor() {
		return searchAuthor;
	}
	public void setSearchAuthor(String searchAuthor) {
		this.searchAuthor = searchAuthor;
	}
	public String getSearchminPrice() {
		return searchminPrice;
	}
	public void setSearchminPrice(String searchminPrice) {
		this.searchminPrice = searchminPrice;
	}
	public String getSearchmaxPrice() {
		return searchmaxPrice;
	}
	public void setSearchmaxPrice(String searchmaxPrice) {
		this.searchmaxPrice = searchmaxPrice;
	}
	
}
