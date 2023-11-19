package entity;

public class Book extends  CrupdateBook {
    int author;
    public Book(int id, String bookName, int pageNumbers, String topic, String releaseDate, int author) {
        super(id, bookName, pageNumbers, topic, releaseDate);
        this.author = author;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", pageNumbers=" + pageNumbers +
                ", topic='" + topic + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", author=" + author +
                '}';
    }
}
