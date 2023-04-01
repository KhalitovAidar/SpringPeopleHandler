package org.firstMVC.DAO;

import org.firstMVC.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Component
public class PersonDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        List<Person> people = session.createQuery("select p from Person p", Person.class)
                .getResultList();
        return people;
    }

    public Optional<Person> show(String email) {
        return null;
    }

    public Person show(int id) {
        return null;
    }

    public void save(Person person) {

    }

    public void update(int id, Person updatedPerson) {

    }

    public void delete(int id) {

    }

//    public void testMultipleUpdate() {
//        List<Person> peopleList =  create1000people();
//
//        long before = System.currentTimeMillis();
//
//        for (Person person: peopleList) {
//            jdbcTemplate.update("INSERT INTO Person VALUES(1, ?)", person.getName());
//        }
//
//        long after = System.currentTimeMillis();
//        System.out.println("Time: " + (after - before));
//    }

//    public void testBatchMultipleUpdate() {
//        List<Person> peopleList =  create1000people();
//        long before = System.currentTimeMillis();
//
//        jdbcTemplate.batchUpdate("INSERT INTO Person VALUES(1, ?)", new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps, int i) throws SQLException {
//                ps.setInt(1, peopleList.get(i).getId());
//                ps.setString(1, peopleList.get(i).getName());
//            }
//
//            @Override
//            public int getBatchSize() {
//                return peopleList.size();
//            }
//
//        });
//
//        long after = System.currentTimeMillis();
//        System.out.println(after - before);
//    }
//
//    private List<Person> create1000people() {
//        List<Person> people = new ArrayList<>();
//
//        for (int i = 1; i <= 1000; ++i) {
//            people.add(new Person(i, "Name " + i));
//        }
//
//        return people;
//    }


}