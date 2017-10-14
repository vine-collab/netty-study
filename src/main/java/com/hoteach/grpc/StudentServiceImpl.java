package com.hoteach.grpc;

import com.hoteach.proto.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

/**
 * @author hekai
 * @create 2017-10-06-17:44
 */
public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase{

    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接受到客户端信息:" + request.getUsername());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("sam").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接受到客户端信息:" + request.getAge());
        responseObserver.onNext(StudentResponse.newBuilder().setName("sam").setAge(20).setCity("shanghai").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("tom").setAge(20).setCity("shanghai").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("ross").setAge(20).setCity("shanghai").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("jack").setAge(20).setCity("shanghai").build());

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return new StreamObserver<StudentRequest>() {
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("onNext:" + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError:" +  t.getMessage());
            }

            @Override
            public void onCompleted() {
                StudentResponse build = StudentResponse.newBuilder().setName("rose").setAge(20).setCity("上海").build();
                StudentResponse build1 = StudentResponse.newBuilder().setName("jack").setAge(20).setCity("上海").build();
                StudentResponse build2 = StudentResponse.newBuilder().setName("tom").setAge(20).setCity("上海").build();
                StudentResponse build3 = StudentResponse.newBuilder().setName("sam").setAge(20).setCity("上海").build();

                StudentResponseList responseList = StudentResponseList.newBuilder().addStudentResponse(build).addStudentResponse(build1).addStudentResponse(build2).addStudentResponse(build3).build();
                responseObserver.onNext(responseList);
                responseObserver.onCompleted();
            }
        };

    }


    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
