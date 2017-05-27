package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.Book;


public class BookDao {
	// 数据插入
		public void insert(Book book) {
				String sql = "insert into t_bookinfo values(?,?,?,?,?,?,?,?);";
				Connection con = DBUtils.getConnection();
				
				try {
					// 预编译
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, book.getBookid());
					ps.setString(2, book.getIsbn13());
					ps.setString(3, book.getIsbn10());
					ps.setString(4, book.getTitle());
					ps.setString(5, book.getPublisher());
					ps.setString(6, book.getPubdate());
					ps.setString(7, book.getAuthor());
					ps.setString(8, book.getPrice());
					// 执行
					ps.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

}
