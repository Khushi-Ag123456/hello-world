/*
 * Represents Book
 */
package model;

public class Book {
	private int id;
	private String title;
	private String writer; 
	private String publisher;
	private int published_year;
	
	
	public Book() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublished_year() {
		return published_year;
	}

	public void setPublished_year(int published_year) {
		this.published_year = published_year;
	}

	public Book(int id, String title, String writer, String publisher,
			int published_year) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.published_year = published_year;
	}
	
	public Book(String title, String writer, String publisher,
			int published_year) {
		super();
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.published_year = published_year;
	}
}
