package io.grpc.examples.experimental.proxy.share;

import java.io.Serializable;

public class HelloRequest implements Serializable{

    private static final long serialVersionUID = -7233640528512433585L;

    private String name;

	public HelloRequest() {
	    // no impl.
	}

	public HelloRequest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
