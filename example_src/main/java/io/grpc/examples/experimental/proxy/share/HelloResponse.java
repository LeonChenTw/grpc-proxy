package io.grpc.examples.experimental.proxy.share;

import java.io.Serializable;

public class HelloResponse implements Serializable {

    private static final long serialVersionUID = 372062355502147027L;

    private String message;

    public HelloResponse() {
        // no impl.
    }

    public HelloResponse(String message) {
        this.message = message;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
