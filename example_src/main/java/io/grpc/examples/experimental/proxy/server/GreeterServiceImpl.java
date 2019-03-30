package io.grpc.examples.experimental.proxy.server;

import io.grpc.examples.experimental.proxy.share.GreeterService;
import io.grpc.examples.experimental.proxy.share.HelloRequest;
import io.grpc.examples.experimental.proxy.share.HelloResponse;

public class GreeterServiceImpl implements GreeterService {

	@Override
	public HelloResponse hello(HelloRequest request1, HelloRequest request2) {
		System.out.println("request1 :" + request1.getName() + " request2:" + request2.getName());

		HelloResponse resultResponse = new HelloResponse("success");

		return resultResponse;
	}

}
