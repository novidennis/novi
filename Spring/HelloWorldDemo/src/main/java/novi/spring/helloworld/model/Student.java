package novi.spring.helloworld.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Student() { }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
