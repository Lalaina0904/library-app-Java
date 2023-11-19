import entity.Book;
import operations.BookCrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
           BookCrudOperations bookCrudOperations1 = new BookCrudOperations();
            List<Book> books = bookCrudOperations1.findAll();
            for (Book book : books) {
                System.out.println(book);
            }
//        BookCrudOperations bookCrudOperations2 = new BookCrudOperations();
//        List<Book> books2 = bookCrudOperations2.saveAll(books);



    }
}