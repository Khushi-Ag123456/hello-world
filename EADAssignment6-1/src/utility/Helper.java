/*
 * Helper Class
 */
package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Query;
import model.Book;

public class Helper {

	/**
	 * Adds Book
	 * @param book
	 * @return 1 or 0 accordingly
	 */
	public static int addBook(Book book){
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.insert())){
			p.setString(1, book.getTitle());
			p.setString(2, book.getWriter());
			p.setString(3, book.getPublisher());
			p.setInt(4, book.getPublished_year());
			return p.executeUpdate();
		} catch (SQLException exc) {
			exc.printStackTrace();
			return 0;
		}
	}

	/**
	 * Gets All books 
	 * @return list of books
	 */
	public static List<Book> getAllBook(){
		List<Book> books = new ArrayList<Book>();
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.getAll())){
			ResultSet res = p.executeQuery();
			while(res.next()){
				int id = res.getInt("id");
				String title = res.getString("title");
				String writer= res.getString("writer"); 
				String publisher= res.getString("publisher");
				int published_year= res.getInt("published_year");
				books.add(new Book(id,title,writer,publisher,published_year));
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
		
		return books;
	}
	
	/**
	 * Gets Books by title
	 * @param title
	 * @return list of books
	 */
	public static List<Book> getBookByTitle(String title){
		List<Book> books = new ArrayList<Book>();
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.getByTitle(title))){
			ResultSet res = p.executeQuery();
			while(res.next()){
				int id = res.getInt("id");
				String writer= res.getString("writer"); 
				String publisher= res.getString("publisher");
				int published_year= res.getInt("published_year");
				books.add(new Book(id,title,writer,publisher,published_year));
			}
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
		
		return books;
	}
	
	/**
	 * Updates Book
	 * @param book
	 * @return 1 or 0 accordingly
	 */
	public static int updateBook(Book book){
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.update())){
			p.setString(1, book.getTitle());
			p.setInt(2, book.getPublished_year());
			p.setInt(3, book.getId());
			return p.executeUpdate();
		} catch (SQLException exc) {
			exc.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Deletes book by id
	 * @param id
	 * @return 1 or 0 accordingly
	 */
	public static int deleteBookById(int id){
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.deleteById(id))){
			return p.executeUpdate();
		} catch (SQLException exc) {
			exc.printStackTrace();
			return 0;
		}
	}
	

	/**
	 * Deletes all books
	 * @return 1 or 0 accordingly
	 */
	public static int deleteAllBook(){
		try(Connection c = JDBC.makeConnection();
				PreparedStatement p = c.prepareStatement(Query.deleteAll())){
			return p.executeUpdate();
		} catch (SQLException exc) {
			exc.printStackTrace();
			return 0;
		}
	}
}
