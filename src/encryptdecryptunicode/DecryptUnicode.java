package encryptdecryptunicode;

import encryptdecrypt.EncDec;
import encryptdecrypt.Message;

public class DecryptUnicode implements EncDec {
    @Override
    public void process(Message message) {
        String data = message.getInput();
        String decoded = "";
        for (int i = 0; i < data.length(); i++) {
            int code = data.charAt(i);
            decoded += (char) (code - message.key);
        }
        message.produceOutput(decoded);
    }
}
