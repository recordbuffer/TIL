package ecommerce;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ProductClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder              // 연결하려는 서버 주소와 포트 채널 생성
                .forAddress("localhost", 50051)
                .usePlaintext()                             // 클라이언트와 서버 사이 보안되지 않은 연결 (평문) 사용
                .build();

        ProductInfoGrpc.ProductInfoBlockingStub stub = ProductInfoGrpc.newBlockingStub(channel);        // 클라이언트 스텁 생성 => Blocking Stub : 서버 응답받을 때까지 대기
                                                                                                        // NonBlocking stub : 서버 응답 기다리지 않고 옵저버를 등록해 응답 받음
        ProductInfoOuterClass.ProductID productID = stub.addProduct(    // add 메서드 호출
                ProductInfoOuterClass.Product.newBuilder()
                        .setName("Apple iPhone 14")
                        .setDescription("Meet Apple iPhone 14. " + "All-new dual-camera system with " + "Ultra Wide and Night mode.")
                        .setPrice(1000.0f)
                        .build());
        System.out.println(productID.getValue());

        ProductInfoOuterClass.Product product = stub.getProduct(productID);     // Product ID로 Product 정보 반환 (get 메서드 호출)
        System.out.println(product.toString());
        channel.shutdown();         // JVM 종료시 gRPC 채널도 종료
    }
}
