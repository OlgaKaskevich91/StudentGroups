package stationery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Stationery> stationeries = new ArrayList<>();

        stationeries.add(new Pen("Blue", 50, "Pen"));
        stationeries.add(new Paper("Black", 450, "Paper"));
        stationeries.add(new Scissors("White", 5250, "Scissors"));
        stationeries.add(new Pen("Red", 10, "Pen"));

        List<Stationery> beginnerSet = new ArrayList<>();
        beginnerSet.add(new Pen("Brown", 250, "Pen"));
        beginnerSet.add(new Pen("Pink", 230, "Pen"));
        beginnerSet.add(new Paper("Cream", 20, "Paper"));
        beginnerSet.add(new Scissors("Green", 80, "Scissors"));

        Employee employee1 = new Employee("Ivan");
        Employee employee2 = new Employee("Olga");
        employee2.setStationeries(beginnerSet);

        beginnerSet.sort(Comparator.comparing(Stationery::getPrice).thenComparing(Stationery::getType));
        System.out.println("After sorting:");
        for (Stationery stationery : beginnerSet) {
            System.out.println(stationery);
        }
    }
}
