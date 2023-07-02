package model;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;
@JsonbPropertyOrder({"id","name", "description","taskState"})
@Entity
@Table(name = "taskObjectssssss")
public class TaskObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;



    public TaskObject() {
    }

    public TaskObject(String name, String description) {

        this.name = name;
        this.description = description;

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



    @Override
    public String toString() {
        return "Задача: " +
                "id " + id +
                "наименование " + name +
                "Описание " + description;
    }
}


