package homeworkTwo;

abstract class Stationery {
    private int price;
    private String name;

    int getPrice() {
        return price;
    }

    void setPrice(int price) {
        this.price = price;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
