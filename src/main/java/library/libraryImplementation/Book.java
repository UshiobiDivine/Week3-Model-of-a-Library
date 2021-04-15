package library.libraryImplementation;

public class Book {
    private String name;
    private int isbn;
    private String author;

    public Book(String name, String author, int isbn) {
        this.name=name;
        this.author=author;
        this.isbn=isbn;
    }
    public String getName() {
        return name;
    }
    public int getIsbn() {
        return isbn;
    }
    public String getAuthor() {
        return author;
    }

}
