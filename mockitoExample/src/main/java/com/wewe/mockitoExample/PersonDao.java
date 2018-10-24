package com.wewe.mockitoExample;

/**
 * Author: fei2
 * Date:  18-10-24 上午9:49
 * Description:
 * Refer To:
 */
public interface PersonDao {
    public Person fetchPerson( Integer personID );
    public void update( Person person );
}
