package io.grpc.proxy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.grpc.MethodDescriptor.Marshaller;
import io.protostuff.CodedInput;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

public class MsgTransReqMarshaller implements Marshaller<MessageTransfer>{
	private final int len;
	private Schema<MessageTransfer> messageTransSchema;

	@SuppressWarnings("rawtypes")
    private Schema[] paramSchemas;

	public MsgTransReqMarshaller(Class<?>[] classes) throws InstantiationException, IllegalAccessException {
		len = classes.length;
		paramSchemas = new Schema[len];
		for(int i = 0 ; i < len; i++) {
			paramSchemas[i] = RuntimeSchema.getSchema(classes[i]);
		}
	}

	@Override
	public InputStream stream(MessageTransfer messageTransfer) {
		ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
		LinkedBuffer writeBuffer1 = LinkedBuffer.allocate(1000000);
		try {
			ProtobufIOUtil.writeTo(outputstream, messageTransfer, messageTransSchema, writeBuffer1);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		byte[] arr = outputstream.toByteArray();
		InputStream messageIs = new ByteArrayInputStream(arr);
		return messageIs;
	}

	@SuppressWarnings("unchecked")
    public MessageTransfer parse(InputStream stream)  {
		final CodedInput input = new CodedInput(stream, false);
		MessageTransfer msgTransfer = null;
		try {
			input.readRawVarint32();
			final int size = input.readInt32();
			Object[] params = new Object[size];
			for(int i = 0; i < size; i++) {
				input.readRawVarint32();
				params[i] = paramSchemas[i].newMessage();
				input.mergeObject(params[i], paramSchemas[i]);
			}
			msgTransfer = new MessageTransfer(params);
			return msgTransfer;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
