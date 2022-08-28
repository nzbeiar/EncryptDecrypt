package encryptdecrypt;

import encryptdecryptshift.DecryptShift;
import encryptdecryptshift.EncryptShift;
import encryptdecryptunicode.DecryptUnicode;
import encryptdecryptunicode.EncryptUnicode;

public class StrategyEncryptorDecryptor {
    private EncDec algorithm;

    public StrategyEncryptorDecryptor(Message message) {
        if ("shift".equals(message.alg)) {
            if ("enc".equals(message.mode)){
                this.algorithm = new EncryptShift();
            } else {
                this.algorithm = new DecryptShift();
            }
        } else if ("unicode".equals(message.alg)) {
            if ("enc".equals(message.mode)){
                this.algorithm = new EncryptUnicode();
            } else {
                this.algorithm = new DecryptUnicode();
            }
        }
    }

    public void process(Message message) {
        this.algorithm.process(message);
    }
}
