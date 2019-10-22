/*
 * Query Class
 */
package dao;

public class Query {

	/**
	 * Inserts book in table
	 * @return query
	 */
	public static String insert(){
		String query = "insert into book(title,writer,publisher,published_year) values(?,?,?,?)";
		return query;
	}
	
	/**
	 * Gets All books from table
	 * @return query
	 */
	public static String getAll(){
		String query = "select * from book ";
		return query;
	}
	
	/**
	 * Gets All books from table by title
	 * @return query
	 */
	public static String getByTitle(String title){
		String query = "select * from book where title = '" + title + "'";
		return query;
	}
	
	/**
	 * Updates Book
	 * @return query
	 */
	public static String update(){
		String query = "update book set title =? and published_year=? where id=?";
		return query;
	}
	
	/**
	 * Deletes book from table by id
	 * @return query
	 */
	public static String deleteById(int id){
		String query = "delete from book where id =" + id;
		return query;
	}
	

	/**
	 * Deletes All books from table
	 * @return query
	 */
	public static String deleteAll(){
		String query = "delete from book";
		return query;
	}
}
