package com.wewe.mockitoExample;

/**
 * Author: fei2
 * Date:  18-10-24 上午9:48
 * Description:
 * Refer To:
 */
public class Person {

    private final Integer personID;
    private final String personName;

    public Person(Integer personID, String personName) {
        this.personID = personID;
        this.personName = personName;
    }

    public Integer getPersonID() {
        return personID;
    }

    public String getPersonName() {
        return personName;
    }
}
