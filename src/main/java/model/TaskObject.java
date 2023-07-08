package model;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;
@JsonbPropertyOrder({"id","name", "description","taskState"})
@Entity
@Table(name = "taskObjectssssss")
public class TaskObject {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
    private Integer id;
   @Column
    private String name;
   @Column
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




}


