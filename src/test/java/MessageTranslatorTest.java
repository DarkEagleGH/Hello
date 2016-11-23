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
            assertEquals("Доброе утро, мир!", msg.translateMessage("pod.morning"));
        } else {
            assertEquals("Good morning, World!", msg.translateMessage("pod.morning"));
        }
    }
    @Test
    public void testTranslateMessageEn() throws UnsupportedEncodingException {
        assertEquals("Good morning, World!", msg.translateMessage("pod.morning", Locale.ENGLISH));
    }
    @Test
    public void testTranslateMessageRu() throws UnsupportedEncodingException {
        assertEquals("Доброе утро, мир!", msg.translateMessage("pod.morning", new Locale("ru")));
    }
}