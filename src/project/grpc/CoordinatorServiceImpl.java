package project.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

import project.annotations.EngineAPI;

public class CoordinatorServiceImpl
        extends CoordinatorServiceGrpc.CoordinatorServiceImplBase {

    private final EngineAPI engine;

    public CoordinatorServiceImpl(EngineAPI engine) {
        this.engine = engine;
    }

    @Override
    public void runJob(
            RunJobRequest request,
            StreamObserver<RunJobResponse> responseObserver) {

        List<String> outputs = new ArrayList<>();

        for (int input : request.getInputsList()) {
            try {
                if (input < 0) {
                    outputs.add("ERROR");
                } else {
                    outputs.add(engine.calculatePrimes(input));
                }
            } catch (Exception e) {
                outputs.add("ERROR");
            }
        }

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        DatastoreServiceGrpc.DatastoreServiceBlockingStub datastore =
                DatastoreServiceGrpc.newBlockingStub(channel);

        datastore.writeOutput(
                WriteOutputRequest.newBuilder()
                        .addAllOutputs(outputs)
                        .build()
        );

        channel.shutdown();

        RunJobResponse response = RunJobResponse.newBuilder()
                .setStatus("SUCCESS")
                .addAllOutputs(outputs)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}