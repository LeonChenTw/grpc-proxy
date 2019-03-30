


Grpc With Java Proxy instead of generating stubs, without restriction of single method param and cross language RPC.

Fork from https://github.com/supercharger/grpc-proxy, and remove HelloResponse depedency from ResponseMarshaller, so it can support any response type.

Now it only supports 5 parameters, and you can modify MessageTransfer.java to add more parameters.

Build
==============================================

To build the Grpc Proxy Example, run in this directory:

```
$ gradle installDist
```

This creates the scripts `java-proxy-server` and `java-proxy-client`, in the
`build/install/grpc-proxy/bin/` directory that run the examples. Each
example requires the server to be running before starting the client.

For example, to try the hello world example first run:

```
$ ./build/install/<project name>/bin/java-proxy-server
```

And in a different terminal window run:

```
$ ./build/install/<project name>/bin/java-proxy-client
```
