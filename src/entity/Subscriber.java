package entity;

public class Subscriber extends  User{
    public Subscriber(int id, String name, String sex) {
        super(id, name, sex);
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", sex=" + getSex() +
                '}';
    }
}
