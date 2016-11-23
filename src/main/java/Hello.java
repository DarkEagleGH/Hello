import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello {
    private static final Logger logger = LoggerFactory.getLogger(Hello.class);

    public static void main(String[] args) {
        MessageTranslator messageTranslator = new MessageTranslator();
        PartOfTheDay pod = new PartOfTheDay();
        String answer = messageTranslator.translateMessage(pod.getPartOfTheDay());
        logger.info("Greeting: {}", answer);
        System.out.println("Now: ".concat(answer));
    }
}