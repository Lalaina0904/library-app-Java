package operations;

import entity.Book;
import entity.Subscriber;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriberCrudOperations implements CrudOperations<Subscriber>{

    @Override
    public List<Subscriber> findAll() {
        List<Subscriber> subscribers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM subscriber";
            PreparedStatement preparedStatement = Connection_DB.getInstance().ConnectToDatabase().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){

                subscribers.add(
                        new Subscriber(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("sex")
                        )
                );
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return subscribers;
    }

    @Override
    public List<Subscriber> saveAll(List<Subscriber> entity) {
        try {
            String sql = "INSERT INTO subscriber (id, name, sex) VALUES (?,?,?)";
            PreparedStatement preparedStatement = Connection_DB.getInstance().ConnectToDatabase().prepareStatement(sql);

            for (Subscriber subscriber : entity){
                preparedStatement.setInt(1, subscriber.getId());
                preparedStatement.setString(2, subscriber.getName());
                preparedStatement.setString(3, subscriber.getSex());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }

    @Override
    public Subscriber save(Subscriber entity) {
        try {
            String sql = "INSERT INTO subscriber (id, name, sex) VALUES (?, ?, ?)";
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
            String sql = "DELETE FROM subscriber WHERE id = ?";
            PreparedStatement preparedStatement = Connection_DB.getInstance().ConnectToDatabase().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
