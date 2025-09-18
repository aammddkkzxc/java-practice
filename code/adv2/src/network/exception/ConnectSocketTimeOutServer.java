package network.exception;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectSocketTimeOutServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();
        Thread.sleep(1000000);
        //서버 연결은 하지만 아무런 응답도 주지 않는다
    }

}
