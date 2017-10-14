package com.hoteach.grpc;

import com.hoteach.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;

/**
 * @author hekai
 * @create 2017-10-06-20:34
 */
public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext(true).build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(channel);
        StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(channel);

        MyResponse response = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("tom").build());
        System.out.println(response.getRealname());

        System.out.println("---------------------------------------------");

        Iterator<StudentResponse> students = blockingStub.getStudentsByAge(StudentRequest.newBuilder().setAge(20).build());
        while (students.hasNext()) {
            StudentResponse studentResponse = students.next();
            System.out.println(studentResponse.toString());
        }

        System.out.println("---------------------------------------------");

        StreamObserver<StudentResponseList> studentResponseListStreamObserver = new StreamObserver<StudentResponseList>() {
            @Override
            public void onNext(StudentResponseList value) {
                value.getStudentResponseList().forEach(item -> {
                    System.out.println(item);
                });
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError:" + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed");
            }
        };

        StreamObserver<StudentRequest> studentRequestStreamObserver = stub.getStudentsWrapperByAges(studentResponseListStreamObserver);
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(20).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(30).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(40).build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(50).build());

        studentRequestStreamObserver.onCompleted();

        Thread.sleep(5000);
    }
}
