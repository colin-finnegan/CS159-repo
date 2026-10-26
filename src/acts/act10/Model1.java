package acts.act10;

import java.time.LocalDate;

public class Model1 {

    public static void main(String[] args) {
        Person p = new Person("Alan", LocalDate.parse("1912-06-23"));
        Student s = new Student("Grace", LocalDate.parse("1906-12-09"));
        Teacher t = new Teacher("John", LocalDate.parse("1903-12-28"), 123456);

        System.out.println(p);
        System.out.println(s);
        System.out.println(t);

        // Question 8
        System.out.println(p.equals(p));
        System.out.println(s.equals(s));
        System.out.println(t.equals(t));
    }

}
