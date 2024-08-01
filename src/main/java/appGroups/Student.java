package appGroups;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Discipline> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();

    }
    public String getName() {
        return name;
    }

    public ArrayList<Discipline> getSubjects() {
        return subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(ArrayList<Discipline> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
