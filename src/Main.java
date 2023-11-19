import entity.Book;
import operations.BookCrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {
           BookCrudOperations bookCrudOperations = new BookCrudOperations();
            List<Book> books = bookCrudOperations.findAll();
            for (Book book : books) {
                System.out.println(book);
            }


    }
}