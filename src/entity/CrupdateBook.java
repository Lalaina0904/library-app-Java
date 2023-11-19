package entity;

public abstract class CrupdateBook {

    int id;
    String bookName;
    String pageNumbers;
    String topic;
    String releaseDate;

    public CrupdateBook(int id, String bookName, String pageNumbers, String topic, String releaseDate) {
        this.id = id;
        this.bookName = bookName;
        this.pageNumbers = pageNumbers;
        this.topic = topic;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPageNumbers() {
        return pageNumbers;
    }

    public void setPageNumbers(String pageNumbers) {
        this.pageNumbers = pageNumbers;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", pageNumbers='" + pageNumbers + '\'' +
                ", topic='" + topic + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
