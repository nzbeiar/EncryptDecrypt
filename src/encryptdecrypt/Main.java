package encryptdecrypt;

public class Main {

    public static void main(String[] args) {

        Message message = new Message(args);
        StrategyEncryptorDecryptor algorithm = new StrategyEncryptorDecryptor(message);
        algorithm.process(message);
    }
}
