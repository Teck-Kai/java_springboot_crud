package com.test.dao;

import com.test.entity.PersonBean;

import java.util.List;

public interface PersonDao {
    void create(PersonBean personBean);
    List<PersonBean> getAll();
    PersonBean read(String username);
    void update(PersonBean personBean);
    void delete(String username);
}
