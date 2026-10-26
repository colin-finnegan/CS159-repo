package acts.act10;

import java.time.LocalDate;

public class Student extends Person {

    private static int nextId = 1;

    protected int sid;     // student id number
    protected boolean ta;  // teaching assistant?

    public Student(String name, LocalDate birth) {
        super(name, birth);
        this.sid = nextId++;
        this.ta = false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student other = (Student) obj;
            return sid == other.sid;
        }
        return super.equals(obj);
    }

    public int getSid() {
        return sid;
    }

    public boolean isTA() {
        return ta;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setTA(boolean ta) {
        this.ta = ta;
    }

    public String toString() {
        String str = super.toString();
        str += " [sid: " + sid + "]";
        if (ta) {
            str += " TA";
        }
        return str;
    }

}
