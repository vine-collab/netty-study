package com.hoteach.grpc;

import com.hoteach.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

/**
 * @author hekai
 * @create 2017-10-06-20:34
 */
public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext(true).build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(channel);
        MyResponse response = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("tom").build());
        System.out.println(response.getRealname());

        System.out.println("---------------------------------------------");

        Iterator<StudentResponse> students = blockingStub.getStudentsByAge(StudentRequest.newBuilder().setAge(20).build());
        while (students.hasNext()){
            StudentResponse studentResponse = students.next();
            System.out.println(studentResponse.toString());
        }
    }
}
