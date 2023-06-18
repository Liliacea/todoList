package model;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;
@JsonbPropertyOrder({"id","name", "description","taskState"})
@Entity
@Table(name = "taskObjects")
public class TaskObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "taskState")

    private TaskState state;

    public TaskObject() {
    }
    public static class Builder {

        private String name;

        private String description;

        private TaskState state;


        public Builder() {


        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder description (String val) {
            description = val;
            return this;
        }

        public Builder state (TaskState val) {
            state = val;
            return this;
        }



        public TaskObject build() {
            return new TaskObject(this);
        }
    }

    private TaskObject(Builder builder) {

        name = builder.name;
        description = builder.description;
        state = builder.state;


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

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Задача: " +
                "id " + id +
                "наименование " + name +
                "Описание " + description;
    }
}


