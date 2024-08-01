package appGroups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group <T extends Number>{
    private String name;
    private Discipline subject;
    private ArrayList<Student>students;
    private Map<Student, List<T>> grades;

    public Group(String name,Discipline subject) {
        this.name = name;
        this.subject= subject;
        this.students = new ArrayList<>();
        this.grades=new HashMap<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Discipline getSubject() {
        return subject;
    }
    public void setSubject(Discipline subject) {
        this.subject = subject;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public Map<Student, List<T>> getGrades() {
        return grades;
    }

    public void setGrades(Map<Student, List<T>> grades) {
        this.grades = grades;
    }

    public void addStudent(Student student){
        students.add(student);
        grades.put(student,new ArrayList<>());

    }
    public void addGrade(Student student, T value) {
        if (!grades.containsKey(student)) {
            addStudent(student);
        }
        grades.get(student).add(value);
    }
}



