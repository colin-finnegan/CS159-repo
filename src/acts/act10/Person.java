package acts.act10;

import java.time.LocalDate;

public class Person {

    protected String name;
    protected LocalDate birth;

    public Person(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person other = (Person) obj;
            return name.equals(other.name) && birth.equals(other.birth);
        }
        return false;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public String getName() {
        return name;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("%s (%s)", name, birth);
    }

}
