package model;

public class Category {
    String name;
    String sum;
    String type;

    public Category(String name, String sum, String type) {
        this.name = name;
        this.sum = sum;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Category() {

    }
}
