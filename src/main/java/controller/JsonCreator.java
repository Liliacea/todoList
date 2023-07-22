package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.TaskObject;
import servise.CRUDaoImplTasks;
import servise.HibernateUtil;

import java.io.IOException;


import java.util.List;

import java.util.concurrent.CopyOnWriteArrayList;

public class JsonCreator {

    private static List<TaskObject> createObjToJson() {
        CRUDaoImplTasks crudao = new CRUDaoImplTasks(HibernateUtil.getSessionFactory());
        List<TaskObject> personList = new CopyOnWriteArrayList<>();

       personList = crudao.select();
        return personList;
    }


    public static   String createJson() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            return objectMapper.writeValueAsString(createObjToJson());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
