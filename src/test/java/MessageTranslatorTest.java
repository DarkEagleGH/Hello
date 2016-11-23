import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.*;

public class MessageTranslatorTest {
    private static MessageTranslator msg;

    @BeforeClass
    public static void init() {
        msg = new MessageTranslator();
    }

    @Test
    public void testTranslateMessage() throws Exception {
        System.out.println("Get Language: " + Locale.getDefault().getLanguage());
        if (Locale.getDefault().getLanguage() == "ru") {
            assertEquals("Утро", msg.translateMessage("pod.morning"));
        } else {
            assertEquals("Morning", msg.translateMessage("pod.morning"));
        }
    }
    @Test
    public void testTranslateMessageEn() throws Exception {
        assertEquals("Morning", msg.translateMessage("pod.morning", Locale.ENGLISH));
    }
    @Test
    public void testTranslateMessageRu() throws Exception {
        assertEquals("Утро", msg.translateMessage("pod.morning", new Locale("ru")));
    }
}