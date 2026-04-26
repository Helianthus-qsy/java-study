import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class arraydemo1 {
    static void main() {
        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(23);
        register(s1);
    }

    public static void register(Person p) {
        p.show();
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show() {
        System.out.println(name + "," + age);
    }
}

class Student extends Person {
    @Override
    public void show() {
        System.out.println("学生的信息为：" + getName() + "," + getAge());
    }
}

