package com.hoteach.grpc;

import com.hoteach.proto.*;
import io.grpc.stub.StreamObserver;

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

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        }

    }
}
