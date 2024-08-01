package stationery;
import java.util.Objects;

public class Stationery  {
    private String color;
    private double price;
    private String type;

    public Stationery(String color, double price, String type) {
        this.color = color;
        this.price = price;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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
        Stationery that = (Stationery) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(color, that.color) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, price, type);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Stationery:\n" + "color - ")
                .append(color)
                .append('\n')
                .append("price - ")
                .append(price)
                .append('\n')
                .append("type - ")
                .append(type)
                .append('\n')
                .toString();
    }

        }


