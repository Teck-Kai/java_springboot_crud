package com.test.dao;

import com.test.entity.PersonBean;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class PersonDaoImpl implements PersonDao {

    private final EntityManager entityManager;

    public PersonDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected final Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public void create(PersonBean personBean) {
        getSession().save(personBean);
    }

    @Override
    public List<PersonBean> getAll() {
        final Session s = this.getSession();
        final Criteria c = s.createCriteria(PersonBean.class);
        return c.list();
    }

    @Override
    public PersonBean read(String username) {
        return getSession().get(PersonBean.class, username);
    }

    @Override
    public void update(PersonBean personBean) {
        getSession().merge(personBean);
    }

    @Override
    public void delete(String username) {
        final Session s = this.getSession();
        s.delete(s.load(PersonBean.class, username));
        s.flush();
    }
}
