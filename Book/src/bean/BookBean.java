package bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.BookDao;
import entity.TBookinfo;

@ManagedBean
@SessionScoped
public class BookBean {
	@EJB
	BookDao bookDao;
	
	private List<TBookinfo> books = new ArrayList<TBookinfo>();
	private String bookid;
	private String author;
	private String isbn10;
	private String isbn13;
	private String price;
	private String pubdate;
	private String publisher;
	private String title;
	
	private String msg;
	//每页记录数 默认10
	private int pageSize = 10;
	//当前页号
	private int currentPage;
	
	//上页
	public void previousPage(){
		currentPage --;
		if(currentPage < 0){
			currentPage = 0;
		}
	}
	//下页
	public void nextPage(){
		currentPage ++;
		if(currentPage > getLastPageNum()){
			currentPage = getLastPageNum();
		}
	}
	//第一页
	public void fistPage(){
		currentPage = 0;
	}
	//最后一页
	public void lastPage(){
		currentPage = getLastPageNum();
	}
	
	//删除书籍
	public void delete(TBookinfo book){
		bookDao.deleteTBookinfo(book);
		msg = "删除书籍成功";
	}
	//增加书籍
	public void add(){
		bookid = UUID.randomUUID().toString();
		TBookinfo book = new TBookinfo(bookid, author, isbn10, isbn13, price, pubdate, publisher, title);
		bookDao.addTBookinfo(book);
		msg = "添加书籍成功";
	}
	//编辑书籍
	public void edit(){
	}
	//查找
	public void find(){
		
	}
	
	//获取当前页书籍
	public List<TBookinfo> getBooks() {
		return bookDao.getBookList(currentPage * pageSize, pageSize);
//		return bookDao.findTBookinfos();
	}
	
	//计算最后一页的页数
	private int getLastPageNum() {
		int totalRow = bookDao.getRowCount();
		int result = totalRow / pageSize;
		if(totalRow % pageSize == 0){
			result = 0;
		}
		return result;
	}
	

	public void setBooks(List<TBookinfo> books) {
		this.books = books;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public BookDao getBookDao() {
		return bookDao;
	}
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn10() {
		return isbn10;
	}
	public void setIsbn10(String isbn10) {
		this.isbn10 = isbn10;
	}
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
