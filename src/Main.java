import entity.Book;
import operations.BookCrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookCrudOperations bookCrudOperations = new BookCrudOperations();

        System.out.println(bookCrudOperations.findAll());

        //créer une liste de book

        List<Book> books = new ArrayList<>();
       // Book book1=new Book(4,"name",200,"topic","2023",1);
        //Book book2=new Book(5,"name2",200,"roman","2022",2);
       // books.add(book1);
        //books.add(book2);
        System.out.println(bookCrudOperations.saveAll(books));
        bookCrudOperations.delete(5);

    }
}