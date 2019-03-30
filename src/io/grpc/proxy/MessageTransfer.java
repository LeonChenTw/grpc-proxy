package io.grpc.proxy;

import java.io.Serializable;

public class MessageTransfer implements Serializable {

    private static final long serialVersionUID = -6702135751544209116L;

    private int length;
    private Object requestParam1;
    private Object requestParam2;
    private Object requestParam3;
    private Object requestParam4;
    private Object requestParam5;

    public MessageTransfer() {
        // no impl.
    }

    public MessageTransfer(Object[] args) {
        this.length = args.length;

        switch(args.length) {
        case 1:
            requestParam1 = args[0];
            break;
        case 2:
            requestParam1 = args[0];
            requestParam2 = args[1];
            break;
        case 3:
            requestParam1 = args[0];
            requestParam2 = args[1];
            requestParam3 = args[2];
            break;
        case 4:
            requestParam1 = args[0];
            requestParam2 = args[1];
            requestParam3 = args[2];
            requestParam4 = args[3];
            break;
        case 5:
            requestParam1 = args[0];
            requestParam2 = args[1];
            requestParam3 = args[2];
            requestParam4 = args[3];
            requestParam5 = args[4];
            break;
        }

    }

    public int getLength() {
        return length;
    }

    public Object[] retriveRequestParams() {
        Object[] requestParams = new Object[this.length];
        switch(this.length) {
            case 1:
                requestParams[0] = this.requestParam1;
                break;
            case 2:
                requestParams[0] = this.requestParam1;
                requestParams[1] = this.requestParam2;
                break;
            case 3:
                requestParams[0] = this.requestParam1;
                requestParams[1] = this.requestParam2;
                requestParams[2] = this.requestParam3;
            case 4:
                requestParams[0] = this.requestParam1;
                requestParams[1] = this.requestParam2;
                requestParams[2] = this.requestParam3;
                requestParams[3] = this.requestParam4;

            case 5:
                requestParams[0] = this.requestParam1;
                requestParams[1] = this.requestParam2;
                requestParams[2] = this.requestParam3;
                requestParams[3] = this.requestParam4;
                requestParams[4] = this.requestParam5;

        }
        return requestParams;
    }
}
