package encryptdecryptshift;

import encryptdecrypt.EncDec;
import encryptdecrypt.Message;

public class EncryptShift implements EncDec {

    @Override
    public void process(Message message) {
        String data = message.getInput();
        String encoded = "";
        for (int i = 0; i < data.length(); i++)
        {
            int code = data.charAt(i);
            if (code >= MIN_SHIFT_UPPERCASE && code <= MAX_SHIFT_UPPERCASE) {
                if (code + message.key <= MAX_SHIFT_UPPERCASE) {
                    encoded += (char) (code + message.key);
                } else {
                    encoded += (char) (code - MAX_SHIFT_UPPERCASE + MIN_SHIFT_UPPERCASE + (message.key-1));
                }

            } else if (code >= MIN_SHIFT_LOWERCASE && code <= MAX_SHIFT_LOWERCASE) {
                if (code + message.key <= MAX_SHIFT_LOWERCASE) {
                    encoded += (char) (code + message.key);
                } else {
                    encoded += (char) (code - MAX_SHIFT_LOWERCASE + MIN_SHIFT_LOWERCASE + (message.key-1));
                }
            }
            else {
                encoded += (char) code;
            }

        }
        message.produceOutput(encoded);
    }
}
