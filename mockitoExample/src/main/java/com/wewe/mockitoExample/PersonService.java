package com.wewe.mockitoExample;

/**
 * Author: fei2
 * Date:  18-10-24 上午9:50
 * Description:
 * Refer To:
 */
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean update(Integer personId, String name) {
        Person person = personDao.fetchPerson(personId);
        if (person != null) {
            Person updatedPerson = new Person(person.getPersonID(), name);
            personDao.update(updatedPerson);
            return true;
        } else {
            return false;
        }
    }
}
