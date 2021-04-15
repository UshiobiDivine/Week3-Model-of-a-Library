package library.libraryImplementation;

import model.Person;
import model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibrarySecondImpTest {

    Person teacher = new Person("Collins Obiora", Position.TEACHER);
    Person seniorStudent = new Person("John Pele", Position.SENIOR_STUDENT);
    Person juniorStudent = new Person("Muna Abang", Position.JUNIOR_STUDENT);

    Book book = new Book("The Grass is Always Greener", "Jeffrey Archer", 1-86092-7);
    Book book1=new Book("Murder", "Arnold Bennett", 1-88092-1);
    Book book2=new Book("The Higgler", "A. E. Coppard", 1-86392-9);
    Book book3=new Book("The Signalman", "Charles Dickens", 1-86047-1);

    LibrarySecondImp librarySecondImp = new LibrarySecondImp();

    @Test
    void getBooksList() {
        librarySecondImp.addBook(book);
        librarySecondImp.addBook(book1);
        librarySecondImp.addBook(book);
        assertTrue(librarySecondImp.getBooksList().size()==3);
    }

    @Test
    void getTheQueue() {
        librarySecondImp.userQueue(teacher);
        Position position = librarySecondImp.getTheQueue().peek().getPosition();
        assertTrue(position==Position.TEACHER);
    }

    @Test
    void userQueue() {
        librarySecondImp.userQueue(teacher);
        librarySecondImp.userQueue(seniorStudent);
        librarySecondImp.userQueue(juniorStudent);
        assertEquals(3,librarySecondImp.getTheQueue().size());
    }

    @Test
    void addBook() {
        librarySecondImp.addBook(book);
        assertTrue(librarySecondImp.getBooksList().size()==1);
    }

    @Test
    void requestForBook() {
        librarySecondImp.userQueue(seniorStudent);
        librarySecondImp.userQueue(teacher);
        librarySecondImp.userQueue(juniorStudent);
        librarySecondImp.addBook(book);
        String name = librarySecondImp.requestForBook(book,juniorStudent ,seniorStudent);
        assertTrue(name.equals("John Pele"));
    }
    @Test
    void getCopiesOfBookTest(){
        librarySecondImp.addBook(book1);
        librarySecondImp.addBook(book2);
        librarySecondImp.addBook(book1);
        librarySecondImp.addBook(book3);
        assertTrue(librarySecondImp.getCopiesOfBook(book1)==2);
        assertTrue(librarySecondImp.getCopiesOfBook(book3)==1);
        assertTrue(librarySecondImp.getCopiesOfBook(book2)==1);
    }
}