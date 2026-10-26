package acts.act10;

import java.time.LocalDate;

public class Model2 {

    public static void main(String[] args) {
        Person p1 = new Person("Helen", LocalDate.parse("2000-01-02"));
        Student s1 = new Student("John", LocalDate.parse("2000-03-04"));
        Person poly = new Student("Polly", LocalDate.parse("2000-05-06"));

        System.out.println(p1 instanceof Student);
        System.out.println(s1 instanceof Student);
        System.out.println(poly instanceof Student);
        System.out.println(p1 instanceof Person);
        System.out.println(p1 instanceof Object);
        System.out.println(s1 instanceof Person);
        System.out.println(s1 instanceof LocalDate);
        System.out.println(poly instanceof Person);
        System.out.println(poly instanceof Teacher);

        // Question 18
        LocalDate d = LocalDate.parse("1949-01-17");
        Object obj = new Teacher("Anita Borg", d, 123456);
        System.out.println(obj.toString());

        // Question 19
        Person j = new Student("John", LocalDate.parse("2000-03-04"));
        Person m = new Teacher("Mary", LocalDate.parse("2000-09-10"), 100000);
        System.out.println(j.equals(m));
        System.out.println(m.equals(j));
    }

}
