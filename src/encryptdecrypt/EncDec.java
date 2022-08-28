package encryptdecrypt;

public interface EncDec {

    public static final int MAX_SHIFT_LOWERCASE = 122;
    public static final int MIN_SHIFT_LOWERCASE = 97;
    public static final int MAX_SHIFT_UPPERCASE = 90;
    public static final int MIN_SHIFT_UPPERCASE = 65;

    public static final int MIN = 32;
    public static final int MAX= 126;

    void process(Message message);

}

