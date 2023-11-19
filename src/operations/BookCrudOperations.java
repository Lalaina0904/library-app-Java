package operations;

import entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book>  {
    static Connection_DB connectionDB = new Connection_DB("prog_admin", System.getenv("password"), "library_management");

    Statement statement;
    {
        try {
            statement = connectionDB.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void resultSet(String sql) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("BookName: " + resultSet.getString("bookName"));
            System.out.println("PageNumber: " + resultSet.getString("pageNumbers"));
            System.out.println("Topic: " + resultSet.getString("topic"));
            System.out.println("ReleaseDate: " + resultSet.getString("releaseDate"));
            System.out.println("Author: " + resultSet.getInt("author"));
        }
    }
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            String sql = "SELECT * FROM book";
            statement.execute(sql);
            resultSet(sql);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    return books;
    }

    @Override
    public List<Book> saveAll(List<Book> entity) {
        List<Book> savedBooks = new ArrayList<>();
        try {
            String sql = "INSERT INTO book (id, bookName, pageNumbers, topic, releaseDate, author) VALUES (?,?,?,?,?,?)";
            statement.execute(sql);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return savedBooks;
    }

    @Override
    public Book save(Book entity) {
        try {
            String sql = "INSERT INTO book (id, bookName, pageNumbers, releaseDate, topic, author) VALUES (?, ?, ?, ?, ?, ?)";
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM book WHERE id = " + id;
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
