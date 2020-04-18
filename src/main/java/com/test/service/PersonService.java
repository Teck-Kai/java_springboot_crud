package com.test.service;

import com.test.entity.PersonBean;

import java.util.List;

public interface PersonService {
    void create(PersonBean personBean);
    List<PersonBean> getAll();
    PersonBean read(String username);
    boolean update(String username, PersonBean personBean);
    void delete(String username);
}
