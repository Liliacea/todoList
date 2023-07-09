package servise;

import model.Person;
import model.TaskObject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.function.Function;

public class CRUDAOImpl implements CRUDao<Person, Integer> {

    static SessionFactory sessionFactory;

    public CRUDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    public <T> T tx(Function<Session, T> command) {
        final Session session = sessionFactory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    @Override
    public Person add (Person person){
        return tx(session -> {
            session.save(person);
            return person;
        });
    }

    @Override
    public List<Person> select() {
        return tx(session -> {
            List<Person> persons = null;
            Criteria criteria = session.createCriteria(Person.class);
            persons = criteria.list();
            for (Person person : persons) {
                System.out.println(person.toString());
            }
            return persons;
        });
    }

    @Override
    public Person update(Person person) {
        return tx(session -> {

            session.update(person);
            return person;
        });
    }

    @Override
    public Person delete(Person person) {
        return tx(session -> {

            session.delete(person);
            return person;
        });
    }

    @Override
    public List<Person> findById(Integer id) {
        return tx(session -> {
            List<Person> persons = null;
            Criteria criteria = session.createCriteria(Person.class);
            criteria.add(Restrictions.eq("id", id));
            persons = criteria.list();
            for (Person person : persons) {
                System.out.println(person.toString());


            }
            return persons;
        });
    }
    }

