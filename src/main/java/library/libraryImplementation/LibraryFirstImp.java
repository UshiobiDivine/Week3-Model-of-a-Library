package library.libraryImplementation;

import model.Person;
import library.Library;

import java.security.InvalidParameterException;
import java.util.*;

public class LibraryFirstImp implements Library {

    private List<Book> booksList = new ArrayList<>();
    private Queue<Person> theQueue;

    //Constructs a library sorting the users based on their levels (giving priorities)
    public LibraryFirstImp(){
        theQueue = new PriorityQueue<>(Comparator.comparingInt(Person::getLevel));
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public Queue<Person> getTheQueue() {
        return theQueue;
    }

    //processes the requests for a particular book based on priority
    @Override
    public String requestForBook(Book book, Person... p) throws NullPointerException {
        //checks for a valid book
        if (book==null||book.getName().isBlank()||
                book.getAuthor().isBlank()||
                String.valueOf(book.getIsbn()).isBlank()||
                !booksList.contains(book)) {
            throw new NullPointerException("Book not available");
        }

        //Removes the person from the queue (if in queue)

        int i = 0;
        while (i< p.length){
            if (theQueue.peek()==p[i]){
                booksList.remove(book);
                theQueue.poll();
                System.out.println("The "+p[i].getName()+" gets the book ("+book.getName()+")");
                return p[i].getName();
            }
            i++;
        }
        return null;
    }

    //puts any person in the right place on the queue
    //makes sure its a valid person
    public boolean userQueue(Person person) throws InvalidParameterException {
        if (theQueue.contains(person)){
            System.out.println("The person is on the queue already");
            return false;
        }else if (person!=null||!person.getName().isBlank()||!person.getPosition().name().isBlank()||
        person.getPosition()!=null||person.getName()!=null){
            theQueue.add(person);
            return true;
        }else {
            throw new InvalidParameterException();
        }
    }
    //adds books to the list of books in the library
    public int addBook(Book book) throws NullPointerException {
        if (book==null||book.getName().isBlank()||book.getAuthor().isBlank()||String.valueOf(book.getIsbn()).isBlank()){
            throw new NullPointerException("Book cannot be added because its either null or has incomplete details");
        }
        booksList.add(book);
        return booksList.size();
    }

    //prints the queue
    public void printTheQueue() throws NullPointerException {
        if (theQueue==null)
            throw new NullPointerException("Queue is null");
        if (theQueue.size()==0) {
            System.out.println("The queue is empty");
        }
        for (Person p:theQueue) {
            System.out.println(p.getPosition()+" "+ p.getName());
        }
    }
    //gets the copies of a particular book
    @Override
    public int getCopiesOfBook(Book b) {
        int count = 0;
        for (Book book:booksList) {
            if (b==book)
                count++;
        }
        return count;
    }
    /*public void showListOfBooks() throws NullPointerException {
        if (booksList==null){
            throw new NullPointerException("Book list is null");
        }
        if (booksList.size()==0) {
            System.out.println("The Book list is empty");
        }
        for (Book b:booksList) {
            System.out.println(b.getName()+", "+b.getAuthor()+" ("+b.getIsbn()+")");
        }
    }*/

}
