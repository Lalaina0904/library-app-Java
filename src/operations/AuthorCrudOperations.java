package operations;

import entity.Author;
import entity.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperations implements CrudOperations<Author>  {
    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        try {
            String sql = "SELECT * FROM author";
            PreparedStatement preparedStatement = Connection_DB.getInstance().ConnectToDatabase().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){

                authors.add(
                        new Author(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("sex")
                        )
                );
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public List<Author> saveAll(List<Author> entity) {
        try {
            String sql = "INSERT INTO author (id, name, sex) VALUES (?,?,?)";
            PreparedStatement preparedStatement = Connection_DB.getInstance().ConnectToDatabase().prepareStatement(sql);

            for (Author author : entity){
                preparedStatement.setInt(1, author.getId());
                preparedStatement.setString(2, author.getName());
                preparedStatement.setString(3, author.getSex());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }


    @Override
    public Author save(Author entity) {
        try {
            String sql = "INSERT INTO author (id, name, sex) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = Connection_DB.getInstance().ConnectToDatabase().prepareStatement(sql);

            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getSex());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM author WHERE id = ?";
            PreparedStatement preparedStatement = Connection_DB.getInstance().ConnectToDatabase().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
