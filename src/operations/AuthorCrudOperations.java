package operations;

import entity.Author;
import entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperations implements CrudOperations<Author>  {
    static Connection_DB connectionDB = new Connection_DB("prog_admin", System.getenv("MotDePasseProgAdmin"), "library_management");

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
    public List<Author> findAll() {
        List<Author> Authors = new ArrayList<>();
        try {
            String sql = "SELECT * FROM author";
            statement.execute(sql);
            resultSet(sql);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Authors;
    }

    @Override
    public List<Author> saveAll(List<Author> entity) {
        List<Author> savedAuthors = new ArrayList<>();
        try{
            String sql = "insert into author (id, name, sex) values (?,?,?)";
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return savedAuthors;
    }

    @Override
    public Author save(Author entity) {
        try{
            String sql = "INSERT INTO author (id, name, sex) VALUES (?, ?, ?)";
            statement.execute(sql);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM author WHERE id = " + id;
            statement.execute(sql);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
