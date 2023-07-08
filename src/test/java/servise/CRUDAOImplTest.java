package servise;

import model.TaskObject;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CRUDAOImplTest {
    CRUDAOImpl crudao = new CRUDAOImpl(HibernateRollBack.create(HibernateUtil.getSessionFactory()));
    TaskObject doingSomething = new TaskObject("aaa","aaa");


    @Test
    public void add() {

        assertThat(crudao.add(doingSomething).getName(), is("aaa"));
    }

    @Test
    public void update() {


        crudao.add(doingSomething);
        doingSomething.setName("yahz");

        assertThat(crudao.update(doingSomething).getName(),is("yahz"));
    }
    @Test
    public void select() {


        crudao.add(doingSomething);
        assertThat(crudao.select().contains(doingSomething), is(true));
    }


    @Test
    public void delete() {
        crudao.add(doingSomething);
        crudao.delete(doingSomething);
        assertThat(crudao.select().contains(doingSomething), is(false));
    }
}