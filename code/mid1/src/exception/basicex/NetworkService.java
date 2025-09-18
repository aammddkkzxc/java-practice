package exception.basicex;

public class NetworkService {

    public void sendMessage(String data) {
        String address = "https://example.com";
        NetworkClient client = new NetworkClient(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
        } catch (ConnectException e) {
            System.out.println("[연결 오류] 주소: " + e.getAddress() + ", 메시지: " + e.getMessage());
        } catch (SendException e) {
            System.out.println("[전송 오류] 전송 데이터: " + e.getSendData() + ", 메시지: " + e.getMessage());
        } finally {
            client.disconnect();
        }
    }

}
