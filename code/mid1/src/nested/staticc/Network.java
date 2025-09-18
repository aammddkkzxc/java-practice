package nested.staticc;

public class Network {

    public void sendMessage(String text) {
        NetworkMessage msg = new NetworkMessage(text);
        msg.print();
    }

    private static class NetworkMessage {
        private final String content;

        public NetworkMessage(String content) {
            this.content = content;
        }

        public void print() {
            System.out.println(content);
        }
    }

}
