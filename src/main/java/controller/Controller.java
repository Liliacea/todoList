package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.TaskObject;
import servise.CRUDAOImpl;
import servise.HibernateUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Controller {

    private static List<TaskObject> createObjToJson() {
        CRUDAOImpl crudao = new CRUDAOImpl(HibernateUtil.getSessionFactory());
        List<TaskObject> taskObjects;
        taskObjects = new CopyOnWriteArrayList<>();

        taskObjects = crudao.select();
        return taskObjects;
    }


    public static String createJson() {

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            return objectMapper.writeValueAsString(createObjToJson());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
