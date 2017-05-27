package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Book;


public class BookDao {
	// ���ݲ���
		public void insert(Book book) {
				String sql = "insert into t_bookinfo values(?,?,?,?,?,?,?,?);";
				Connection con = DBUtils.getConnection();
				
				try {
					// Ԥ����
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, book.getBookid());
					ps.setString(2, book.getIsbn13());
					ps.setString(3, book.getIsbn10());
					ps.setString(4, book.getTitle());
					ps.setString(5, book.getPublisher());
					ps.setString(6, book.getPubdate());
					ps.setString(7, book.getAuthor());
					ps.setString(8, book.getPrice());
					// ִ��
					ps.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

}
