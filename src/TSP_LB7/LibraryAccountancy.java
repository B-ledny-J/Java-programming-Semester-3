package TSP_LB7;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Book {
	private String title;
	private String authorFullName;
	private String publisher;
	private int year;
	private float price;

	public Book(String title, String authorFullName, String publisher, int year, float price) {
		this.title = title;
		this.authorFullName = authorFullName;
		this.publisher = publisher;
		this.year = year;
		this.price = price;
	}

	public String getAuthorFullName() { return authorFullName; }

	public String getInfo() {
		return "Title: " + title +
				", Author: " + authorFullName +
				", Publisher: " + publisher +
				", Year: " + year +
				", Price: " + price;
	}
}

public class LibraryAccountancy {

	public static void main(String[] args) {

		HashMap<Integer, Book> library = new HashMap<>();
		TreeSet<String> authors = new TreeSet<>();

		library.put(97801, new Book("Effective Java", "Joshua Bloch", "Addison-Wesley", 2018, 45.5f));
		library.put(97802, new Book("Clean Code", "Robert C. Martin", "Prentice Hall", 2008, 40.0f));
		library.put(97803, new Book("Java Concurrency", "Brian Goetz", "Addison-Wesley", 2006, 50.0f));
		library.put(97804, new Book("Refactoring", "Martin Fowler", "Addison-Wesley", 2019, 47.3f));
		library.put(97805, new Book("Clean Architecture", "Robert C. Martin", "Prentice Hall", 2017, 42.8f));

		System.out.println("\nLibrary catalog:");
		for (Map.Entry<Integer, Book> entry : library.entrySet()) System.out.println("ISBN: " + entry.getKey() + " | " + entry.getValue().getInfo());

		for (Book book : library.values()) authors.add(book.getAuthorFullName());

		System.out.println("\nUnique authors:");
		for (String author : authors) System.out.println(author);
	}
}