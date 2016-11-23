import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

public class Hello {
    public static void main(String[] args) throws UnsupportedEncodingException {
        LocalTime testTime = LocalTime.of(11,0,0);
        MessageTranslator messageTranslator = new MessageTranslator();
        PartOfTheDay pod = new PartOfTheDay();
        String answer = messageTranslator.translateMessage(pod.getPartOfTheDay(), Locale.ENGLISH);
        System.out.println("Now: ".concat(answer));
        answer = messageTranslator.translateMessage(pod.getPartOfTheDay(testTime));
        System.out.println("Test: ".concat(answer));
    }
}

class MessageTranslator {
    public String translateMessage(String str, Locale locale) {
        try {
            return getMessage(str, locale);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String translateMessage(String str) {
        Locale locale = Locale.getDefault();
        try {
            return getMessage(str, locale);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getMessage(String str, Locale locale) throws UnsupportedEncodingException {
        ResourceBundle bundle;
        bundle = getResourceBundle(str, locale);
        try {
            String res = new String(bundle.getString(str).getBytes("ISO-8859-1"), "UTF-8");
            return res;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ResourceBundle getResourceBundle(String str, Locale locale) {
        ResourceBundle bundle = null;
        String res = "msg_".concat(str.substring(0, str.indexOf(".")));
        bundle = ResourceBundle.getBundle(res, locale);
        return bundle;
    }
}