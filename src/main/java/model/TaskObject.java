package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import model.state.TaskContext;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;
@JsonbPropertyOrder({"id","name", "description","taskState","person_id"})
@Entity
@Table(name = "taskObjects")
public class TaskObject {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
    private Integer id;
   @Column
    private String name;
   @Column
    private String description;
    @Column(name = "taskState")
    private String state;
   @JsonBackReference
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;




    public TaskObject() {
    }
    public TaskObject(String name, String description) {
        this.name = name;
        this.description = description;
        this.state = (new TaskContext()).getStatusName();
        this.person = new Person();
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Задача: " +
                "id: " + id +
                " наименование: " + name +
                " Описание: " + description +
                " Состояние: " + state;
    }
}


