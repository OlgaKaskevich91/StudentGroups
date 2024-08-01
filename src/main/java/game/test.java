package game;

public class test {
    public static void main(String[] args) {
        Schoolboy schoolboy=new Schoolboy("Ivan",15);
        Schoolboy schoolboy1=new Schoolboy("Denis",13);
        Schoolboy schoolboy2=new Schoolboy("Jon",12);
        Schoolboy schoolboy3=new Schoolboy("Lola",14);

        Student student=new Student("Olga",25);
        Student student1=new Student("Oleg",18);

        Employee employee=new Employee("Bob",50);
        Employee employee1=new Employee("Ron",30);

        Team <Schoolboy>schoolboyTeam=new Team<>("Dragons");
        schoolboyTeam.addNewParticipant(schoolboy);
        schoolboyTeam.addNewParticipant(schoolboy1);

        Team<Student> studentTeam=new Team<>("Forward");
        studentTeam.addNewParticipant(student);
        studentTeam.addNewParticipant(student1);

        Team<Employee>employeeTeam=new Team<>("Workers");
        employeeTeam.addNewParticipant(employee);
        employeeTeam.addNewParticipant(employee1);

        Team <Schoolboy>schoolboyTeam2=new Team<>("Sages");
        schoolboyTeam2.addNewParticipant(schoolboy2);
        schoolboyTeam2.addNewParticipant(schoolboy3);

        schoolboyTeam.playWith(schoolboyTeam2);
    }
}
