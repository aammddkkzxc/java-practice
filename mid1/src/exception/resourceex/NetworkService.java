package exception.resourceex;

public class NetworkService {

    public void sendMessage(String data) {
        String address = "https://example.com";

        try (NetworkClient client = new NetworkClient(address)) {
            client.initError(data);
            client.connect();
            client.send(data);
        } catch (Exception e) {
            System.out.println("[예외 확인]: " + e.getMessage());
            throw e;
        }
    }

}
