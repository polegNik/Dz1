import java.util.Objects;
import java.util.function.Function;

public class HomeWork1 {

    /*
    Домашнее задание #1:

    У всех полей выставить модфикатор доступа private

    Реализовать класс «Student»
        Поля класса - name:String, grade:Integer (+конструктор, +геттеры)
        Метод announce - String announce() {} - возвращает строку в формате "/name/ учится в /grade/ классе"

    Реализовать класс «Teacher»
        Поля класса - name:String, students:Student[30] (+конструктор из name, +геттеры)
        Метод - void addStudent(Student student) {} - добавляет студента в массив студентов,
            если колличество студентов достигло максимального колличества, ничего не делать
        Метод - String[] rollCall() {} - возвращает массив строк из результатов вызова метода
            announce всех встудентов преподавателя
     */
    public static class Student {
        private String name;
        private int grade;

        void setGrade(int grade) {
            if (grade > 0 && grade < 12) {
                this.grade = grade;
            } else {
                System.out.println("Incorrect grade");
            }
        }

        int getGrade() {

            return this.grade;
        }

        void setName(String name) {
            this.name = name;
        }

        String getName() {
            return this.name;
        }

        Student(){
            this.name = "default";
            this.grade = 8;
        }

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
            System.out.println("Student name&grade Constructor");
        }

        Student(int grade, String name) {
            this.grade = grade;
            this.name = name;
            System.out.println("Student grade&name Constructor");
        }
        String announce() {
            String st = name + " studying in " + grade + " class";
            System.out.println(st);
            return st;
        }

    }

    public static class Teacher {
        private final String name;
        private final Student[] students = new Student[30];

        Student[] getStudents() {
            return this.students;
        }

        String getName() {
            return this.name;
        }

        Teacher(String name) {
            this.name = name;
            System.out.println("Teacher name Constructor");

        }

        void addStudent(Student student) {

            for (int i = 0; i < 30; i++) {
                students[i] = student;
            }
        }

        String[] rollCall() {
            String[] arraySt = new String[1];
            for (int i = 0; i < 1; i++) {

               arraySt[i] = students[i].announce();

            }
            return arraySt;
        }


    }

    /*
    Это метод main - нажми play что бы запустить тесты
    Ничего не меняй в тестах, они уже написаны так что бы проверить твое решение
    Некторые методы в тесте подсвечены красным, это значит что компилятор не может их найти
    и тебе необходимо их релизовать, пока ты это не сделаешь, тесты не запустятся
    */
    public static void main(String[] args) {

        var student = new Student(STUDENT_NAME, STUDENT_GRADE);
        print("Student: Студент создался", true);
        print("Student: Геттер имени", Objects.equals(student.getName(), STUDENT_NAME));
        print("Student: Геттер класса", Objects.equals(student.getGrade(), STUDENT_GRADE));
        print("Student: announce содержит имя", student.announce().contains(STUDENT_NAME));
        print("Student: announce содержит класс", student.announce().contains(STUDENT_GRADE.toString()));

        var teacher = new Teacher(TEACHER_NAME);
        print("Teacher: Уичтель создался", true);
        print("Teacher: Геттер имени", teacher.getName() == TEACHER_NAME);
        print("Teacher: Геттер студентов", teacher.getStudents() != null);
        print("Teacher: Массив учеников должен быть размером 30", teacher.getStudents().length == 30);

        teacher.addStudent(student);
        print("Teacher: Студент сохранился в массив", teacher.getStudents()[0] == student);
        String[] calls = teacher.rollCall();
        print("Teacher: Массив rollCall состоит из одиного элемента", calls.length == 1);
        print("Teacher: В строке содержится имя студента", calls[0].contains(STUDENT_NAME));
    }

    /* Техническая секция - сюда писать ничего не надо */

    private static void print(String condition, Boolean act) {
        Function<String, String> yellow = str -> "\u001B[33m" + str + "\u001B[0m";
        System.out.print("TEST CASE " + yellow.apply(constLen(condition, 55)));
        if (act) System.out.print("✅");
        else System.out.print("❌");
        System.out.println();
    }

    private static String constLen(String str, int len) {
        StringBuilder sb = new StringBuilder(str);
        while (len-- - str.length() > 0) sb.append(" ");
        return sb.toString();
    }

    private final static String STUDENT_NAME = "NameStudent";
    private final static String TEACHER_NAME = "NameStudent";
    private final static Integer STUDENT_GRADE = 1;
}
