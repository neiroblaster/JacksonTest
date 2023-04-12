package model;

public class Order {
    private int id;
    private String name;
    private boolean inProgress;

    public Order(int id, String name, boolean inProgress) {
        this.id = id;
        this.name = name;
        this.inProgress = inProgress;
    }

//    public Order() {
//    }

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

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }
}
