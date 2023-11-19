//package operations;
//
//import entity.Subscriber;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//
//public class SubscriberCrudOperations implements CrudOperations<Subscriber>{
//    static Connection_DB connectionDB = new Connection_DB("prog_admin", System.getenv("password"), "library_management");
//
//    Statement statement;
//    {
//        try {
//            statement = connectionDB.getConnection().createStatement();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void resultSet(String sql) throws SQLException {
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        while (resultSet.next()) {
//            System.out.println("ID: " + resultSet.getInt("id"));
//            System.out.println("BookName: " + resultSet.getString("bookName"));
//            System.out.println("PageNumber: " + resultSet.getString("pageNumbers"));
//            System.out.println("Topic: " + resultSet.getString("topic"));
//            System.out.println("ReleaseDate: " + resultSet.getString("releaseDate"));
//            System.out.println("Author: " + resultSet.getInt("author"));
//        }
//    }
//    @Override
//    public List findAll() {
//        return null;
//    }
//
//    @Override
//    public Subscriber save(Subscriber entity) {
//        return null;
//    }
//
//    @Override
//    public List saveAll(List entity) {
//        return null;
//    }
//
//    @Override
//    public void delete(int id) {
//
//    }
//}
