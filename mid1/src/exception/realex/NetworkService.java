package exception.realex;

public class NetworkService {

    public void sendMessage(String data) {
        String address = "https://example.com";

        NetworkClient client = new NetworkClient(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
        } finally {
            client.disconnect();
        }
    }

}
