package model;

public class Operation {
    private String date;
    private String type;
    private String sum;
    private String from;
    private String where;
    private String category;
    private String description;

    public Operation(String date, String type, String sum, String from, String where, String category, String description) {
        this.date = date;
        this.type = type;
        this.sum = sum;
        this.from = from;
        this.where = where;
        this.category = category;
        this.description = description;
    }

    public Operation() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
