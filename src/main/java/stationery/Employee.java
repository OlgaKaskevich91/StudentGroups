package stationery;

import java.util.ArrayList;
import java.util.List;

public class Employee{
    private String name;
    private List<Stationery>stationeries;

    public Employee(String name) {
        this.name = name;
        this.stationeries = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stationery> getStationeries() {
        return stationeries;
    }

    public void setStationeries(List<Stationery> stationeries) {
        if (stationeries!=null){
            this.stationeries = new ArrayList<>(stationeries);
        }
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", stationeries=" + stationeries +
                '}';
    }
}
