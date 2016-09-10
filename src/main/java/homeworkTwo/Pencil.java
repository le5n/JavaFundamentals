package homeworkTwo;

public class Pencil extends Stationery {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pencil pencil = (Pencil) o;

        return type.equals(pencil.type);

    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }
}
