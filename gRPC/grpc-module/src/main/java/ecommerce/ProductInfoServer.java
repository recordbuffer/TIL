package ecommerce;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ProductInfoServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        int port = 50051;
        Server server = ServerBuilder.forPort(port)
                .addService(new ProductInfoImpl())
                .build()
                .start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {                                 // JVM 종료시 gRPC 서버도 종료 => 런타임 종료 후크
            System.err.println("Shutting down gRPC server since JVM is " + "shutting down");
            if (server != null) {
                server.shutdown();
            }
            System.err.println("Server shut down");
        }));
        server.awaitTermination();
    }
}
