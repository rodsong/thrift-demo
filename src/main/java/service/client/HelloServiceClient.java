package service.client;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import service.demo.Hello;

public class HelloServiceClient {
    /**
     * 调用 Hello 服务
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 设置调用的服务地址为本地，端口为 7911
            TTransport transport = new TSocket("localhost", 9813);
            transport.open();
            // 设置传输协议为 TBinaryProtocol
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);
            // 调用服务的 helloVoid 方法
            client.helloVoid();

            System.out.println(client.helloBoolean(true));
            System.out.println(client.helloString("demo"));
            System.out.println(client.helloInt(100));

            try {
                System.out.println(client.helloNull());
            } catch (TException e) {
                if (e instanceof TApplicationException && ((TApplicationException) e).getType() ==
                        TApplicationException.MISSING_RESULT) {
                    System.out.println("The result of helloNull function is NULL");
                }
            }

            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
