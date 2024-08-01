package stationery;

public class StationeryService {
    public double calculateTotalCost(Employee employee) {
        return employee.getStationeries()
                .stream()
                .mapToDouble(Stationery::getPrice)
                .sum();
    }
}
