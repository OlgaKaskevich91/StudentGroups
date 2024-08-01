package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(100, "Ivan", "Bialotski", 5000);
        Employee employee2 = new Employee(10, "Olga", "Kaskevich", 8000);
        Employee employee3 = new Employee(18, "Denis", "Sotnikov", 7000);
        Employee employee4 = new Employee(258, "Bob", "Gold", 500);
        Employee employee5 = new Employee(1005, "Ivan", "Lord", 500);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        System.out.println("Before sorting \n" + employees);
        Collections.sort(employees,new NameComparator());
        System.out.println("After sorting \n" + employees);



    }

    public static class Employee implements Comparable<Employee> {
        int id;
        String name;
        String surName;
        int salary;

        public Employee(int id, String name, String surName, int salary) {
            this.id = id;
            this.name = name;
            this.surName = surName;
            this.salary = salary;
        }


        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surName='" + surName + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        @Override
        public int compareTo(Employee anotherEmployee) {
            if (this.id == anotherEmployee.id) {
                return 0;
            } else if (this.id > anotherEmployee.id) {
                return 1;
            } else {
                return -1;
            }
            //           return this.id-anotherEmployee.id;
//            int result= this.name.compareTo(anotherEmployee.name);
//            if (result==0){
//                this.surName.compareTo(anotherEmployee.surName);
//            }
//            return result;
//        }
        }

    }
    public static class NameComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee emp1, Employee emp2) {
            return emp1.name.compareTo(emp2.name);
        }
    }
    public static class SalaryComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee emp1, Employee emp2) {
            return emp1.salary-emp2.salary;
        }
    }
}
