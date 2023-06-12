package servise;

import model.TaskObject;
import model.TaskState;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CRUDAOImplTest {
    CRUDAOImpl crudao = new CRUDAOImpl(HibernateRollBack.create(HibernateUtil.getSessionFactory()));
    TaskObject doingSomething = new TaskObject.Builder()
            .name("doingSomething")
            .description("do_do_do_do")
            .state(TaskState.CLOSED)

            .build();

    @Test
    void add() {

        assertThat(crudao.add(doingSomething).getName(), is("doingSomething"));
    }

    @Test
    void update() {


        crudao.add(doingSomething);
        doingSomething.setName("yahz");

        assertThat(crudao.update(doingSomething).getName(),is("yahz"));
    }
    @Test
    void select() {


        crudao.add(doingSomething);
        assertThat(crudao.select().contains(doingSomething), is(true));
    }


    @Test
    void delete() {
        crudao.add(doingSomething);
        crudao.delete(doingSomething);
        assertThat(crudao.select().contains(doingSomething), is(false));
    }
}