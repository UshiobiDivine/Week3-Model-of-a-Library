import library.libraryImplementation.Book;
import library.libraryImplementation.LibrarySecondImp;
import model.Position;
import model.Person;
import library.libraryImplementation.LibraryFirstImp;

public class Main {
    public static void main(String[] args) {

        Person teacher = new Person("Collins Obiora", Position.TEACHER);
        Person teacher2 = new Person("Mr Paul", Position.TEACHER);
        Person seniorStudent = new Person("John Pele", Position.SENIOR_STUDENT);
        Person juniorStudent = new Person("Muna Abang", Position.JUNIOR_STUDENT);

        Book book = new Book("The Grass is Always Greener", "Jeffrey Archer", 1-86092-7);
        Book book1=new Book("Murder", "Arnold Bennett", 1-88092-1);
        Book book2=new Book("The Higgler", "A. E. Coppard", 1-86392-9);
        Book book3=new Book("The Signalman", "Charles Dickens", 1-86047-1);
        Book book4=new Book("Murder", "Arnold Bennett", 1-86092-1);
        Book book5=new Book("The Hostage", "C.S Forester", 1-83492-3);
        Book book6 = new Book("An Occurrence at Owl Creek Bridge", "Ambrose Bierce", 1-86092-03);

        /////////////FIRST IMPLEMENTATION///////////////////////////////////
        LibraryFirstImp libraryFirstImp = new LibraryFirstImp();

        libraryFirstImp.addBook(book);
        libraryFirstImp.addBook(book);
        libraryFirstImp.addBook(book1);
        libraryFirstImp.addBook(book1);
        libraryFirstImp.addBook(book1);
        libraryFirstImp.addBook(book2);
        libraryFirstImp.addBook(book2);
        libraryFirstImp.addBook(book2);
        libraryFirstImp.addBook(book3);
        libraryFirstImp.addBook(book4);
        libraryFirstImp.addBook(book4);
        libraryFirstImp.addBook(book5);
        libraryFirstImp.addBook(book5);
        libraryFirstImp.addBook(book5);
        libraryFirstImp.addBook(book5);
        libraryFirstImp.addBook(book6);

        //Users come into the library and sorted, two teachers are on the queue therefore priority doesn't come into play
        libraryFirstImp.userQueue(seniorStudent);
        libraryFirstImp.userQueue(teacher2);
        libraryFirstImp.userQueue(juniorStudent);
        libraryFirstImp.userQueue(teacher);

        /*System.out.println();
        libraryFirstImp.requestForBook(book4, juniorStudent, teacher2, teacher);
        System.out.println("\nThe next people on the queue are: ");
        libraryFirstImp.printTheQueue();
        System.out.println("\nThe remaining copies of the book after borrowing are :");
        System.out.println(libraryFirstImp.getCopiesOfBook(book4));*/

        ////////////////SECOND IMPLEMENTATION//////////////////////////////////
        LibrarySecondImp librarySecondImp = new LibrarySecondImp();

        librarySecondImp.addBook(book);
        librarySecondImp.addBook(book);
        librarySecondImp.addBook(book1);
        librarySecondImp.addBook(book1);
        librarySecondImp.addBook(book1);
        librarySecondImp.addBook(book2);
        librarySecondImp.addBook(book3);
        librarySecondImp.addBook(book3);
        librarySecondImp.addBook(book4);
        librarySecondImp.addBook(book5);
        librarySecondImp.addBook(book5);

        librarySecondImp.userQueue(seniorStudent);
        librarySecondImp.userQueue(juniorStudent);
        librarySecondImp.userQueue(teacher);

        System.out.println();
        librarySecondImp.requestForBook(book1, juniorStudent, teacher);
        System.out.println("\nThe next people on the queue are: ");
        librarySecondImp.printTheQueue();
        System.out.println("\nThe remaining copies of the book after borrowing are :");
        System.out.println(librarySecondImp.getCopiesOfBook(book1));

    }
}
