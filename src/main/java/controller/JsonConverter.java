package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import servise.CRUDaoImplTasks;
import servise.HibernateUtil;

public class JsonConverter {

        public CRUDaoImplTasks crudao;
        public ObjectMapper objectMapper;

        public JsonConverter(CRUDaoImplTasks crudao, ObjectMapper objectMapper) {
            this.crudao = crudao;
            this.objectMapper = objectMapper;

    }
    public void convert(){
            crudao = new CRUDaoImplTasks(HibernateUtil.getSessionFactory());
            objectMapper = new ObjectMapper();
    }
}
