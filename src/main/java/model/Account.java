package model;

public class Account {
    String name;
    String description;
    String sum;

    public Account(String name, String description, String sum) {
        this.name = name;
        this.description = description;
        this.sum = sum;
    }

    public Account() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

}
