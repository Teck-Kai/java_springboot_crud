package com.rhb.service;

import com.rhb.dao.PersonDao;
import com.rhb.entity.PersonBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public void create(PersonBean personBean) {
        personDao.create(personBean);
    }

    @Override
    public List<PersonBean> getAll() {
        return personDao.getAll();
    }

    @Override
    public PersonBean read(String username) {
        return personDao.read(username);
    }

    @Override
    public boolean update(String username, PersonBean personBean) {
        if(username.equals(personBean.getFirstName())) {
            personDao.update(personBean);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void delete(String username) {
        personDao.delete(username);
    }
}
