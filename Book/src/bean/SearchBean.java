package bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.BookDao;
import entity.SearchBook;
import entity.TBookinfo;

@ManagedBean
@SessionScoped
public class SearchBean {
	@EJB
	BookDao bookDao;
	
	private String searchTitle;
	private String searchISBN;
	private String searchAuthor;
	private String searchminPrice;
	private String searchmaxPrice;
	
	private String searchmsg;
	private List<TBookinfo> searchResult=new ArrayList<TBookinfo>();
	/**
	 * 根据输入的查询条件查询书籍
	 */
	public void search(){
		if((searchTitle!=null&&!"".equals(searchTitle))||(searchISBN!=null&&!"".equals(searchISBN))
			||(searchAuthor!=null&&!"".equals(searchAuthor))||(searchminPrice!=null&&!"".equals(searchminPrice))
			||(searchmaxPrice!=null&&!"".equals(searchmaxPrice))){
			searchResult = bookDao.search(
					new SearchBook(searchTitle, searchISBN, searchAuthor, searchminPrice, searchmaxPrice));
			System.out.println(searchResult.size());
			searchmsg=null;
		}else{
			System.out.println("请输入查询条件");
			searchmsg="请输入查询条件";
		}
		
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

	public List<TBookinfo> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<TBookinfo> searchResult) {
		this.searchResult = searchResult;
	}

	public String getSearchmsg() {
		return searchmsg;
	}

	public void setSearchmsg(String searchmsg) {
		this.searchmsg = searchmsg;
	}
	
}
