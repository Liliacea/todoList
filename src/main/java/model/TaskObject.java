package model;

import controller.TaskState;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;
@JsonbPropertyOrder({"id","name", "description","taskState"})
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



    public TaskObject() {
    }

    public TaskObject(String name, String description) {

        this.name = name;
        this.description = description;
        this.state = (new TaskContext()).getStatusName();

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


