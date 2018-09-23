package cn.study.service.impl;

import cn.study.dao.PersonDao;
import cn.study.entity.Person;
import cn.study.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;
    @Override
    public Person getPerson(String id) {
        return personDao.getPerson(id);
    }
    @Override
    public List<Person> getAllPerson() {
        List<Person> list = personDao.getAllPerson();
        return list;
    }

    @Override
    public void addPerson(Person person) {
        personDao.addPerson(person);
    }
    @Override
    public boolean delPerson(String id) {
        return personDao.delPerson(id);
    }
    @Override
    public boolean updatePerson(Person person) {
        return personDao.updatePerson(person);
    }
}