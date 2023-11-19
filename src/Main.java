import entity.Author;
import entity.Book;
import operations.AuthorCrudOperations;
import operations.BookCrudOperations;
import operations.SubscriberCrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Book crud
        BookCrudOperations bookCrudOperations = new BookCrudOperations();
        System.out.println(bookCrudOperations.findAll());
        /*
        List<Book> books = new ArrayList<>();
        Book book1=new Book(4,"name",200,"topic","2023",1);
        Book book2=new Book(5,"name2",200,"roman","2022",2);
        books.add(book1);
        books.add(book2);
        System.out.println(bookCrudOperations.saveAll(books));

        bookCrudOperations.delete(5);

         */

        // Author crud
        AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations();
        System.out.println(authorCrudOperations.findAll());
        /*

        List<Author> authors = new ArrayList<>();
        Author author1=new Author(4,"Nadia","F");
        Author author2=new Author(5,"Toto","M");
        authors.add(author1);
        authors.add(author2);
        System.out.println(authorCrudOperations.saveAll(authors));


        authorCrudOperations.delete(5);

         */

        // Subscriber crud
        SubscriberCrudOperations subscriberCrudOperations = new SubscriberCrudOperations();
        System.out.println(subscriberCrudOperations.findAll());

    }
}