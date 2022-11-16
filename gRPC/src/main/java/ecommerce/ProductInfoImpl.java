package ecommerce;

import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductInfoImpl extends ProductInfoGrpc.ProductInfoImplBase{

    private Map productMap = new HashMap<String, ProductInfoOuterClass.Product>();
    @Override
    public void addProduct(ProductInfoOuterClass.Product request, StreamObserver<ProductInfoOuterClass.ProductID> responseObserver) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        request = request.toBuilder().setId(randomUUIDString).build();
        productMap.put(randomUUIDString, request);
        ProductInfoOuterClass.ProductID id = ProductInfoOuterClass.ProductID.newBuilder().setValue(randomUUIDString).build();
        responseObserver.onNext(id);        // 클라이언트에 응답
        responseObserver.onCompleted();     // 클라이언트 호출 종료
    }

    @Override
    public void getProduct(ProductInfoOuterClass.ProductID request, StreamObserver<ProductInfoOuterClass.Product> responseObserver) {
        String id = request.getValue();
        if (productMap.containsKey(id)) {
            responseObserver.onNext((ProductInfoOuterClass.Product) productMap.get(id));            // 클라이언트에 응답
            responseObserver.onCompleted();                                                         // 클라이언트 호출 종료
        } else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }
    }
}
