package entity;
public class Author extends  User {
    public Author(int id, String name, String sex) {
        super(id, name, sex);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", sex=" + getSex() +
                '}';
    }
}
