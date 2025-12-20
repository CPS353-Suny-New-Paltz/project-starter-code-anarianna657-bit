package project.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import project.annotations.EngineAPI;
import project.FastEngineAPIImpl;

public class CoordinatorServerMain {

    public static void main(String[] args) throws Exception {

        EngineAPI engine = new FastEngineAPIImpl();

        Server server = ServerBuilder
                .forPort(50051)
                .addService(new CoordinatorServiceImpl(engine))
                .build();

        server.start();

        System.out.println("Coordinator gRPC server started on port 50051");

        server.awaitTermination();
    }
}