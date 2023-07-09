package model;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonbPropertyOrder({"id","firstname", "lastName","task", "taskState"})
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
    public static class Builder {

        private String firstName;

        private String lastName;




        public Builder() {


        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName (String val) {
            lastName = val;
            return this;
        }





        public Person build() {
            return new Person(this);
        }
    }

    private Person(Builder builder) {

        firstName = builder.firstName;
        lastName = builder.lastName;



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
                "фамилия " + lastName +
                "id " + id +
                "Таска " + taskObjectSet;
    }
}

