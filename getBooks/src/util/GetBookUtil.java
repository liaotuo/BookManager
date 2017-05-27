package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import dao.BookDao;
import entity.Book;

public class GetBookUtil {
	
	/**
	 * 
	 * @param isbn
	 * XHH
	 */
	public Book getBook(String isbn){
		Book result = null;
		String url_str="https://api.douban.com/v2/book/isbn/:"+isbn;
		URL url = null;
		try {
			url = new URL(url_str);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String charset = "utf-8";
		try {
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);// �����ܲ���д  
			conn.setRequestMethod("GET");// ����ʽ�����д  
			conn.setReadTimeout(5000);// �������˶�ȡ��ʱ��ʱ��  
            conn.setConnectTimeout(5000);// �������ӳ�ʱʱ��5s  
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
			if(conn.getResponseCode()==200){

				InputStream htm_in = conn.getInputStream();
				
				String htm_str = InputStream2String(htm_in,charset);
				System.out.println(htm_str);
				//����json
				JSON json =(JSON)JSON.parse(htm_str);
				//jsonתjava����
				result = (Book)JSON.toJavaObject(json, Book.class);
				System.out.println(result);
				htm_in.close();
			}
			conn.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String InputStream2String(InputStream in_st,String charset) throws IOException{
        BufferedReader buff = new BufferedReader(new InputStreamReader(in_st, charset));
        StringBuffer res = new StringBuffer();
        String line = "";
        while((line = buff.readLine()) != null){
            res.append(line);
        }
        return res.toString();
    }
	@Test
	public void test(){
		for(int i=0;i<100;i++){
			Random r = new Random();
			String isbn="9787302314912";
//			for(int j=0;j<4;j++){
//				isbn+=String.valueOf(r.nextInt(10));
//			}
			System.out.println(isbn);
			Book book = getBook(isbn);
			if(book!=null){
				book.setBookid(UUID.randomUUID().toString());
				String author = book.getAuthor();
				author = author.substring(1,author.length()-1);
				book.setAuthor(author);
				BookDao dao = new BookDao();
				dao.insert(book);
			}
				

		}
	}
}

