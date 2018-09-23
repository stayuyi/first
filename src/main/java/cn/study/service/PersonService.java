package cn.study.service;

import cn.study.entity.Person;

import java.util.List;



public interface PersonService {

     Person getPerson(String id);

     List<Person> getAllPerson();

     void addPerson(Person person);

     boolean delPerson(String id);

     boolean updatePerson(Person person);
}