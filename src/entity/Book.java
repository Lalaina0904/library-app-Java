package entity;

public class Book extends  CrupdateBook {
    Author author;
    public Book(int id, String bookName, String pageNumbers, String topic, String releaseDate, Author author) {
        super(id, bookName, pageNumbers, topic, releaseDate);
        this.author = author;
    }
}
