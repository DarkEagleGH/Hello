import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageTranslator {
    private static final Logger logger = LoggerFactory.getLogger(MessageTranslator.class);


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
            logger.debug("Translated message: {}", res);
            return res;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ResourceBundle getResourceBundle(String str, Locale locale) {
        ResourceBundle bundle;
        String res = "msg_".concat(str.substring(0, str.indexOf(".")));
        bundle = ResourceBundle.getBundle(res, locale);
        logger.debug("Message: {}", str);
        logger.debug("Bundle: {}", bundle.getBaseBundleName());
        return bundle;
    }
}
