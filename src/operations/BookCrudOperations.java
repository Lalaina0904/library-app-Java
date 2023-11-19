package operations;

import entity.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book>  {
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try {
            String sql = "SELECT * FROM book";
            PreparedStatement preparedStatement = Connection_DB.getInstance().ConnectToDatabase().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){

                books.add(
                        new Book(
                                resultSet.getInt("id"),
                                resultSet.getString("bookname"),
                                resultSet.getInt("pagenumbers"),
                                resultSet.getString("topic"),
                                resultSet.getString("releasedate"),
                                resultSet.getInt("authorid")
                        )
                );
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    return books;
    }

    @Override
    public List<Book> saveAll(List<Book> entity) {
        try {
            String sql = "INSERT INTO book (id, bookName, pageNumbers, topic, releaseDate, authorid) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = Connection_DB.getInstance().ConnectToDatabase().prepareStatement(sql);

            for (Book book : entity){
                preparedStatement.setInt(1, book.getBookId());
                preparedStatement.setString(2, book.getBookName());
                preparedStatement.setInt(3, book.getPageNumbers());
                preparedStatement.setString(4, book.getTopic());
                preparedStatement.setString(5, book.getReleaseDate());
                preparedStatement.setInt(6, book.getAuthor());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }

    @Override
    public Book save(Book entity) {
        try {
            String sql = "INSERT INTO book (id, bookName, pageNumbers, releaseDate, topic, author) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = Connection_DB.getInstance().ConnectToDatabase().prepareStatement(sql);

            preparedStatement.setInt(1, entity.getBookId());
            preparedStatement.setString(2, entity.getBookName());
            preparedStatement.setInt(3, entity.getPageNumbers());
            preparedStatement.setString(4, entity.getTopic());
            preparedStatement.setString(5, entity.getReleaseDate());
            preparedStatement.setInt(6, entity.getAuthor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM book WHERE id = ?";
            PreparedStatement preparedStatement = Connection_DB.getInstance().ConnectToDatabase().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
