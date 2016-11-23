import org.junit.BeforeClass;
import org.junit.Test;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import static org.junit.Assert.*;

public class MessageTranslatorTest {
    private static MessageTranslator msg;

    @BeforeClass
    public static void init() {
        msg = new MessageTranslator();
    }

    @Test
    public void testTranslateMessage() throws UnsupportedEncodingException {
        if (Locale.getDefault().getLanguage() == "ru") {
            assertEquals("Утро", msg.translateMessage("pod.morning"));
        } else {
            assertEquals("Morning", msg.translateMessage("pod.morning"));
        }
    }
    @Test
    public void testTranslateMessageEn() throws UnsupportedEncodingException {
        assertEquals("Morning", msg.translateMessage("pod.morning", Locale.ENGLISH));
    }
    @Test
    public void testTranslateMessageRu() throws UnsupportedEncodingException {
        assertEquals("Утро", msg.translateMessage("pod.morning", new Locale("ru")));
    }
}