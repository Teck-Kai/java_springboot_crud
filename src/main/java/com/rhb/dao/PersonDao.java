package com.rhb.dao;

import com.rhb.entity.PersonBean;

import java.util.List;

public interface PersonDao {
    void create(PersonBean personBean);
    List<PersonBean> getAll();
    PersonBean read(String username);
    void update(PersonBean personBean);
    void delete(String username);
}
