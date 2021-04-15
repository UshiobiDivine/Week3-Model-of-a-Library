package library;
import model.Person;
import library.libraryImplementation.Book;

import java.security.InvalidParameterException;

public interface Library {

    String requestForBook(Book book, Person... p);
    boolean userQueue(Person person) throws InvalidParameterException;
    int addBook(Book book) throws NullPointerException;
    void printTheQueue() throws NullPointerException;
    int getCopiesOfBook(Book b);
}
