package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Person;
import model.TaskObject;
import servise.CRUDAOImpl;
import servise.HibernateUtil;

import java.io.IOException;


import java.util.List;

import java.util.concurrent.CopyOnWriteArrayList;

public class Controller {

    private static List<Person> createObjToJson() {
        CRUDAOImpl crudao = new CRUDAOImpl(HibernateUtil.getSessionFactory());
        List<Person> personList = new CopyOnWriteArrayList<>();

       personList = crudao.select();
        return personList;
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
