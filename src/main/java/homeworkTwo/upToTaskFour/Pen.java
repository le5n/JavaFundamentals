package homeworkTwo.upToTaskFour;

class Pen extends Stationery {
    private String colour;
    private String type;
    private String firm;

    void setType(String type) {
        this.type = type;
    }

    void setColour(String colour) {
        this.colour = colour;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    @Override
    public boolean equals(Object o) {
        Pen pen = (Pen) o;

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        if (colour != null ? !colour.equals(pen.colour) : pen.colour != null) {
            return false;
        }
        if (type != null ? !type.equals(pen.type) : pen.type != null) {
            return false;
        }
        return firm != null ? firm.equals(pen.firm) : pen.firm == null;

    }

    @Override
    public int hashCode() {
        int result = colour != null ? colour.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (firm != null ? firm.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "colour: " + colour + "\ntype: " + type + "\nfirm: " + firm + "\nprice: " + getPrice();
    }
}
