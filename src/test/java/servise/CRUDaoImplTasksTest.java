package servise;

import junit.framework.TestCase;
import model.Person;
import model.TaskObject;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CRUDaoImplTasksTest {
    CRUDaoImplTasks cruDaoImplTasks = new CRUDaoImplTasks(HibernateRollBack.create(HibernateUtil.getSessionFactory()));

    TaskObject doingSomething = new TaskObject("doingSomething", "do_do_do_do");
    @Test
    public void add() {
        assertThat(cruDaoImplTasks.add(doingSomething).getName(),is("doingSomething"));
    }

    @Test
    public void select() {
        cruDaoImplTasks.add(doingSomething);
        assertThat(cruDaoImplTasks.select().contains(doingSomething), is(true));
    }

    @Test
    public void update() {
        cruDaoImplTasks.add(doingSomething);
        doingSomething.setName("aaa");
        assertThat(cruDaoImplTasks.update(doingSomething).getName(),is("aaa"));
    }

    @Test
    public void delete() {
        cruDaoImplTasks.add(doingSomething);
        cruDaoImplTasks.delete(doingSomething);
        assertThat(cruDaoImplTasks.select().contains(doingSomething), is(false));
    }

    @Test
    public void findById() {
        cruDaoImplTasks.add(doingSomething);
        assertThat(cruDaoImplTasks.findById(doingSomething.getId()).size(), is(1));
    }
}