package encryptdecryptshift;

import encryptdecrypt.EncDec;
import encryptdecrypt.Message;

public class DecryptShift implements EncDec {
    @Override
    public void process(Message message) {
        String data = message.getInput();
        String decoded = "";
        for (int i = 0; i < data.length(); i++) {
            int code = data.charAt(i);
            if (code - message.key < MIN_SHIFT_UPPERCASE && code > MIN_SHIFT_UPPERCASE) {
                decoded += (char) (MAX_SHIFT_UPPERCASE - (message.key - (code - MIN_SHIFT_UPPERCASE) - 1));
            } else if (code - message.key < MIN_SHIFT_LOWERCASE && code > MIN_SHIFT_LOWERCASE) {
                    decoded += (char) (MAX_SHIFT_LOWERCASE - (message.key - (code - MIN_SHIFT_LOWERCASE) - 1));
            } else if (code < MIN_SHIFT_UPPERCASE || code > MAX_SHIFT_UPPERCASE && code < MIN_SHIFT_LOWERCASE) {
                decoded += (char) code;
            } else {
                decoded += (char) (code - message.key);
            }

        }
        message.produceOutput(decoded);;
    }
}
