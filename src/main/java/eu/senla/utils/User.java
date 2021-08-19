package eu.senla.utils;

public class User {
    private int id;
    private String first_name;
    private String last_name;
    private String town;

    public User(int id, String first_name, String last_name, String town) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.town = town;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getTown() {
        return town;
    }

}
