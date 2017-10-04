package com.hoteach.thrift;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import sun.misc.Cleaner;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * @author hekai
 * @create 2017-10-04-10:34
 */
public class ThriftClient {

    public static void main(String[] args) {
        TTransport tTransport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TCompactProtocol protocol = new TCompactProtocol(tTransport);
        PersonService.Client client = new PersonService.Client(protocol);
        try {
            tTransport.open();
            Person sam = client.getPersonByUsername("sam");
            System.out.println(sam.toString());

            Person person = new Person();
            person.setAge(20);
            person.setMarried(false);
            person.setUsername("tom");

            client.savePerson(person);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
