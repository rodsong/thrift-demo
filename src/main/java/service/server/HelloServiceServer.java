package service.server;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import service.demo.Hello;
import service.demo.HelloServiceImpl;
import tutorial.Calculator;

public class HelloServiceServer {
    /**
     * 启动 Thrift 服务器
     * @param args
     */

    public static HelloServiceImpl handler;

    public static Hello.Processor processor;

    public static void main(String[] args) {

        handler = new HelloServiceImpl();
        processor = new Hello.Processor(handler);

        try {
            TServerTransport serverTransport = new TServerSocket(9813);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            System.out.println("Starting the simple server...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}