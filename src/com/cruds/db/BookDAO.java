package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cruds.book.Book;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class BookDAO 
{
	public boolean create(Book book)
	{
		String sql = "insert into book(isbn,title,category,No_of_books) values(?,?,?,?)";
		String sql2 = "insert into author(authorname,Authormailid,isbn) values(?,?,?)"; 
		
		int rows = 0, rows1 = 0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getCategory());
			ps.setInt(4, book.getNo_of_books());
			
			rows = ps.executeUpdate();
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, book.getAuthor().getAuthorname());
			ps2.setString(2, book.getAuthor().getAuthormailid());
			ps2.setInt(3, book.getIsbn());
			
			rows1 = ps2.executeUpdate();
			
		} 
		catch(MySQLIntegrityConstraintViolationException e)
		{
			System.out.println(book.getIsbn() + "ALready Exixts");
			
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows > 0 && rows1 > 0;
	}
	public void search(String searchTitle)
	{		
		String sql = "select s.Title, s.Isbn, s.No_of_books, s.Category,a.Authorname,a. Authormailid from book s, author a where Title like? and s.Isbn = a.Isbn";
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" +searchTitle + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs!=null && rs.next())
			{
				int isbn = rs.getInt("Isbn");
				String title = rs.getString("Title");
				String category = rs.getString("Category");
				int no_of_books = rs.getInt("No_of_books");
				String author_name = rs.getString("Authorname");
				String author_mailid = rs.getString("Authormailid");
				
				System.out.println("Book ID : " + isbn + "\n" + "Book Title : " + title + "\n" + "Book Category : " + category + "\n" + "No. Books Available : " + no_of_books + "\n" + "Author Name : " + author_name + "\n" + "Author Mail ID : " + author_mailid + "\n");
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
		
		public void searchCat(String searchCategory)
		{
			String sql2 = "select s.Title, s.Isbn, s.No_of_books, s.Category,a.Authorname,a. Authormailid from book s, author a where Category like? and s.Isbn = a.Isbn";
			
			try(Connection conn = DBConnectionManager.getConnection())
			{
				PreparedStatement ps = conn.prepareStatement(sql2);
				ps.setString(1, "%" +searchCategory + "%");
				ResultSet rs = ps.executeQuery();
				
				while(rs!=null && rs.next())
				{
					int isbn = rs.getInt("Isbn");
					String title = rs.getString("Title");
					String category = rs.getString("Category");
					int no_of_books = rs.getInt("No_of_books");
					String author_name = rs.getString("Authorname");
					String author_mailid = rs.getString("Authormailid");
					
					System.out.println("Book ID : " + isbn + "\n" + "Book Title : " + title + "\n" + "Book Category : " + category + "\n" + "No. Books Available : " + no_of_books + "\n" + "Author Name : " + author_name + "\n" + "Author Mail ID : " + author_mailid + "\n" );
				}

			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

	}
		
		public void searchAuth(String searchAuthor)
		{
			String sql2 = "select s.Title, s.Isbn, s.No_of_books, s.Category,a.Authorname,a. Authormailid from book s, author a where Authorname like? and s.Isbn = a.Isbn";
			
			try(Connection conn = DBConnectionManager.getConnection())
			{
				PreparedStatement ps = conn.prepareStatement(sql2);
				ps.setString(1, "%" +searchAuthor + "%");
				ResultSet rs = ps.executeQuery();
				
				while(rs!=null && rs.next())
				{
					int isbn = rs.getInt("Isbn");
					String title = rs.getString("Title");
					String category = rs.getString("Category");
					int no_of_books = rs.getInt("No_of_books");
					String author_name = rs.getString("Authorname");
					String author_mailid = rs.getString("Authormailid");
					
					System.out.println("Book ID : " + isbn + "\n" + "Book Title : " + title + "\n" + "Book Category : " + category + "\n" + "No. Books Available : " + no_of_books + "\n" + "Author Name : " + author_name + "\n" + "Author Mail ID : " + author_mailid + "\n" );
				}

			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

	}
		
		public void list(String listAllBooks)
		{
			String sql2 = "select s.Title, s.Isbn, s.No_of_books, s.Category,a.Authorname,a. Authormailid from book s, author a where  s.Isbn = a.Isbn";
			
			try(Connection conn = DBConnectionManager.getConnection())
			{
				PreparedStatement ps = conn.prepareStatement(sql2);
				ResultSet rs = ps.executeQuery();
				
				while(rs!=null && rs.next())
				{
					int isbn = rs.getInt("Isbn");
					String title = rs.getString("Title");
					String category = rs.getString("Category");
					int no_of_books = rs.getInt("No_of_books");
					String author_name = rs.getString("Authorname");
					String author_mailid = rs.getString("Authormailid");
					
					System.out.println("Book ID : " + isbn + "\n" + "Book Title : " + title + "\n" + "Book Category : " + category + "\n" + "No. Books Available : " + no_of_books + "\n" + "Author Name : " + author_name + "\n" + "Author Mail ID : " + author_mailid + "\n" );
				}

			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}

	}
		
				
		
}
	
	

