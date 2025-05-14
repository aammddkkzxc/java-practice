package network.exception;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ConnectSocketTimeOutClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        InputStream input = socket.getInputStream();
        try {
            socket.setSoTimeout(3000); // 타임아웃 시간 설정
            int read = input.read(); // 기본은 무한 대기
            System.out.println("read = " + read);
        } catch (Exception e) {
            e.printStackTrace();
        }

        socket.close();
    }

}
