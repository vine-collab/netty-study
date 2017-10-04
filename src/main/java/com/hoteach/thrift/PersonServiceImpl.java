package com.hoteach.thrift;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * @author hekai
 * @create 2017-10-04-10:19
 */
public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got Client Param: " + username);
        Person person = new Person();
        person.setAge(20);
        person.setMarried(false);
        person.setUsername("sam");
        return  person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println(person.toString());
    }
}
