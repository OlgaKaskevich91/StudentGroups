package stationery;

public class Paper extends Stationery {

    public Paper(String color, double price, String type) {
        super(color, price, type);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Paper:\n" + "color - ")
                .append(getColor())
                .append('\n')
                .append("price - ")
                .append(getPrice())
                .append('\n')
                .append("type - ")
                .append(getType())
                .append('\n')
                .toString();
    }
}
