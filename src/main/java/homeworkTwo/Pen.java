package homeworkTwo;

class Pen {
    private String colour;
    private String type;
    private boolean multiplyUse; //true - если можно заменять стержень
    private int price;


    void setType(String type) {
        this.type = type;
    }

    void setColour(String colour) {
        this.colour = colour;
    }

    void setMultiplyUse(boolean multiplyUse) {
        this.multiplyUse = multiplyUse;
    }

    void setPrice(int price) {
        this.price = price;
    }

    String getFullPen() {
        String multUse = " with multiply usage";
        String notMultUse = " without multiply usage";
        if (multiplyUse == true) {
            return colour + " " + type + multUse + " costs " + price;
        }
        return colour + " " + type + notMultUse + " costs " + price;
    }

    @Override
    public boolean equals(Object o) {
        Pen pen = (Pen) o;

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        if (multiplyUse != pen.multiplyUse) {
            return false;
        }
        if (price != pen.price){
            return false;
        }
        if (colour != null ? !colour.equals(pen.colour) : pen.colour != null) {
            return false;
        }
        return type != null ? type.equals(pen.type) : pen.type == null;

    }

    @Override
    public int hashCode() {
        int result = colour != null ? colour.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (multiplyUse ? 1 : 0);
        result = 31 * result + price;

        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "colour='" + colour + '\'' +
                ", type='" + type + '\'' +
                ", multiplyUse=" + multiplyUse +
                ", price=" + price +
                '}';
    }
}
