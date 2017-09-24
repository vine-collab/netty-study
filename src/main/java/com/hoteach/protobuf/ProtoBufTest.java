package com.hoteach.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author hekai
 * @create 2017-09-24 上午10:41
 */

public class ProtoBufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        DataInfo.Student student = DataInfo.Student.newBuilder().setAddress("shanghai").setAge(25).setName("hekai").build();

        byte[] bytes = student.toByteArray();

        DataInfo.Student student1 = DataInfo.Student.parseFrom(bytes);

        System.out.println(student1.getAddress());
        System.out.println(student1.getName());
        System.out.println(student1.getAge() );
    }

}
