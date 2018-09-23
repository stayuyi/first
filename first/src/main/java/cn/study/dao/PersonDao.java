package cn.study.dao;

import cn.study.entity.Person;

import java.util.List;

public interface PersonDao {
    Person getPerson(String id);

    List<Person> getAllPerson();

    void addPerson(Person person);

    boolean delPerson(String id);

    boolean updatePerson(Person person);
}