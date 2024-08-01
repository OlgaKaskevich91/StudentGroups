package appGroups;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Student studentOlga = new Student("Olga");
        Student studentIvan = new Student("Ivan");
        Student studentDenis = new Student("Denis");

        Group<Double> mathGroup = new Group<>("Math Group", Discipline.MATH);
        Group<Integer> biologyGroup = new Group<>("Biology Group", Discipline.BIOLOGY);
        Group<Double> physicsGroup = new Group<>("Physics Group", Discipline.PHYSICS);
        Group<Integer> literatureGroup = new Group<>("Literature Group", Discipline.LITERATURE);
        Group<Integer> geographyGroup = new Group<>("Geography Group", Discipline.GEOGRAPHY);

        mathGroup.addStudent(studentOlga);
        mathGroup.addStudent(studentIvan);
        biologyGroup.addStudent(studentOlga);
        biologyGroup.addStudent(studentDenis);
        physicsGroup.addStudent(studentIvan);
        literatureGroup.addStudent(studentOlga);
        literatureGroup.addStudent(studentDenis);
        geographyGroup.addStudent(studentIvan);
        geographyGroup.addStudent(studentIvan);

        mathGroup.addGrade(studentOlga, 5.0);
        biologyGroup.addGrade(studentOlga, 4);
        literatureGroup.addGrade(studentOlga, 4);
        physicsGroup.addGrade(studentIvan, 5.0);
        mathGroup.addGrade(studentIvan, 4.3);
        geographyGroup.addGrade(studentIvan, 3);
        literatureGroup.addGrade(studentDenis, 5);
        geographyGroup.addGrade(studentDenis, 4);
        biologyGroup.addGrade(studentDenis, 4);

        List<Group<?>> groups = new ArrayList<>();
        groups.add(mathGroup);
        groups.add(biologyGroup);
        groups.add(physicsGroup);
        groups.add(literatureGroup);
        groups.add(geographyGroup);

        List<Group<?>> studentGroups = findStudentInGroups(studentDenis, groups);
        if (!studentGroups.isEmpty()) {
            System.out.println("Student " + studentDenis.getName() + " is in groups:");
            for (Group<?> group : studentGroups) {
                System.out.println(group.getName());
            }
        } else {
            System.out.println("Student not found");
        }

        Group<?> bestGroup = compareGrade(studentDenis, groups);
        if (bestGroup != null) {
            System.out.println("Group with the highest average grade for student " + studentDenis.getName() + " is: " + bestGroup.getName());
        } else {
            System.out.println("No group found for student " + studentDenis.getName());
        }
    }

    public static List<Group<?>> findStudentInGroups(Student student, List<Group<?>> groups) {
        return groups.stream()
                .filter(group -> group.getStudents().contains(student))
                .collect(Collectors.toList());
    }

    public static Group<?> compareGrade(Student student, List<Group<?>> groups) {
        return groups.stream()
                .filter(group -> group.getGrades().containsKey(student))
                .max((group1, group2) -> {
                    double total1 = group1.getGrades().get(student).stream()
                            .mapToDouble(Number::doubleValue)
                            .sum();
                    double total2 = group2.getGrades().get(student).stream()
                            .mapToDouble(Number::doubleValue)
                            .sum();

                    return Double.compare(total1, total2);
                })
                .orElse(null);
    }
}
