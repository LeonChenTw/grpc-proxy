package io.grpc.proxy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.grpc.MethodDescriptor.Marshaller;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

public class ResponseMarshaller<T> implements Marshaller<Object> {

    private Class<T> returnType;

    public ResponseMarshaller(Class<T> returnType) {
        this.returnType = returnType;
    }

	@SuppressWarnings("unchecked")
    @Override
	public InputStream stream(Object value) {
		ByteArrayOutputStream outputstream = new ByteArrayOutputStream();

        @SuppressWarnings("rawtypes")
        Schema objSchema = RuntimeSchema.getSchema(value.getClass());
		LinkedBuffer writeBuffer1 = LinkedBuffer.allocate(1000000);
		try {
			ProtobufIOUtil.writeTo(outputstream, value, objSchema, writeBuffer1);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		byte[] arr = outputstream.toByteArray();
		InputStream messageIs = new ByteArrayInputStream(arr);
		return messageIs;
	}

	@Override
	public T parse(InputStream stream) {
		Schema<T> respSchema = RuntimeSchema.getSchema(returnType);
		T response = respSchema.newMessage();
		try {
			ProtobufIOUtil.mergeFrom(stream, response, respSchema);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return response;
	}
}
