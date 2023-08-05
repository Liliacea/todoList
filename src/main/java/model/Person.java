package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonbPropertyOrder({"id","firstname", "lastName","task", "taskObjectSet"})
@Entity
@Table(name = "ToDoList")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @JsonManagedReference
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
   private List<TaskObject> taskObjectSet = new ArrayList<>();
    public List<TaskObject> getTaskObjectSet() {
        return taskObjectSet;
    }
    public void setTaskObjectSet(List<TaskObject> taskObjectSet) {
        this.taskObjectSet = taskObjectSet;
    }


    public Person() {
    }
    public Person(String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.taskObjectSet = taskObjectSet;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "Имя: " + firstName +
                " фамилия " + lastName +
                " id " + id +
                " Таска " + taskObjectSet;
    }
}

