package model;

public class Repairer {
    private int id;
    private String name;

    public Repairer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Repairer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
