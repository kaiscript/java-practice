package mock;

/**
 * Created by kaiscript on 2018/8/12.
 */
public class Book {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public Book setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
