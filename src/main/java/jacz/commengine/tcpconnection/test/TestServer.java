package jacz.commengine.tcpconnection.test;

import jacz.util.concurrency.task_executor.ThreadExecutor;
import jacz.util.io.IOUtil;

import java.util.concurrent.Future;

/**
 * test
 */
public class TestServer {


    public static void main(String args[]) {

        final int port = 50000;

        Server server = new Server(port);
        ThreadExecutor.registerClient(TestServer.class.getName());
        Future future = ThreadExecutor.submit(server);

        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        IOUtil.pauseEnter("press enter");
        server.stop();

        System.out.println("FIN");
        ThreadExecutor.shutdownClient(TestServer.class.getName());
    }
}
