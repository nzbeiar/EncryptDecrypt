package encryptdecryptunicode;

import encryptdecrypt.EncDec;
import encryptdecrypt.Message;

public class EncryptUnicode implements EncDec {
    @Override
    public void process(Message message) {
        String data = message.getInput();
        String encoded = "";
        for (int i = 0; i < data.length(); i++) {
            int code = data.charAt(i);
            if (code + message.key <= MAX) {
                encoded += (char) (code + message.key);
            } else {
                encoded += (char) (code - MAX + MIN + (message.key - 1));
            }
        }
        message.produceOutput(encoded);
    }
}
