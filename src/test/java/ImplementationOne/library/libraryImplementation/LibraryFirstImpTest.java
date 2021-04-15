package ImplementationOne.library.libraryImplementation;

import library.libraryImplementation.Book;
import library.libraryImplementation.LibraryFirstImp;
import model.Person;
import model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryFirstImpTest {

    Person teacher = new Person("Collins Obiora", Position.TEACHER);
    Person teacher2 = new Person("Mr Sabina", Position.TEACHER);
    Person seniorStudent = new Person("John Pele", Position.SENIOR_STUDENT);
    Person juniorStudent = new Person("Muna Abang", Position.JUNIOR_STUDENT);

    Book book = new Book("The Grass is Always Greener", "Jeffrey Archer", 1-86092-7);
    Book book1=new Book("Murder", "Arnold Bennett", 1-88092-1);
    Book book2=new Book("The Higgler", "A. E. Coppard", 1-86392-9);
    Book book3=new Book("The Signalman", "Charles Dickens", 1-86047-1);

    LibraryFirstImp libraryFirstImp = new LibraryFirstImp();

    @Test
    void getBooksList() {
        libraryFirstImp.addBook(book);
        libraryFirstImp.addBook(book1);
        assertTrue(libraryFirstImp.getBooksList().size()==2);
    }

    @Test
    void getTheQueue() {
        libraryFirstImp.userQueue(teacher);
        libraryFirstImp.userQueue(seniorStudent);
        libraryFirstImp.userQueue(juniorStudent);
        assertTrue(libraryFirstImp.getTheQueue().size()==3);
    }

    @Test
    void requestForBook() {
        libraryFirstImp.userQueue(teacher);
        libraryFirstImp.userQueue(seniorStudent);
        libraryFirstImp.userQueue(juniorStudent);
        libraryFirstImp.userQueue(teacher2);
        libraryFirstImp.addBook(book);
        String name = libraryFirstImp.requestForBook(book, teacher, juniorStudent);

        assertTrue(name.equals("Collins Obiora"));
        assertTrue(libraryFirstImp.getTheQueue().size()==3);
        assertTrue(libraryFirstImp.getTheQueue().peek().getName().equals("Mr Sabina"));
    }

    @Test
    void userQueue() {
        libraryFirstImp.userQueue(seniorStudent);
        libraryFirstImp.userQueue(teacher2);
        libraryFirstImp.userQueue(teacher);
        libraryFirstImp.userQueue(juniorStudent);

        assertTrue(libraryFirstImp.getTheQueue().size()==4);
        assertTrue(libraryFirstImp.getTheQueue().peek().getName().equals("Mr Sabina"));
    }

    @Test
    void addBook() {
        libraryFirstImp.addBook(book1);
        libraryFirstImp.addBook(book2);
        libraryFirstImp.addBook(book1);
        libraryFirstImp.addBook(book3);
        assertTrue(libraryFirstImp.getBooksList().size()>0);
        assertTrue(libraryFirstImp.getBooksList().size()==4);
        assertTrue(libraryFirstImp.getCopiesOfBook(book1)==2);
    }
    @Test
    void getCopiesOfBookTest(){
        libraryFirstImp.addBook(book1);
        libraryFirstImp.addBook(book2);
        libraryFirstImp.addBook(book1);
        libraryFirstImp.addBook(book3);
        assertTrue(libraryFirstImp.getCopiesOfBook(book1)==2);
        assertTrue(libraryFirstImp.getCopiesOfBook(book3)==1);
        assertTrue(libraryFirstImp.getCopiesOfBook(book2)==1);
    }
}