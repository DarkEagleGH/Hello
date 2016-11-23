import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PartOfTheDay {
    private static final Logger logger = LoggerFactory.getLogger(PartOfTheDay.class);
    private static final LocalTime NIGHT_LIM = LocalTime.of(6,0,0);
    private static final LocalTime MORNING_LIM = LocalTime.of(9,0,0);
    private static final LocalTime DAY_LIM = LocalTime.of(19,0,0);
    private static final LocalTime EVENING_LIM = LocalTime.of(23,0,0);

    public String getPartOfTheDay() {
        LocalTime time = LocalTime.now();
        return findPart(time);
    }

    public String getPartOfTheDay(LocalTime time) {
        return findPart(time);
    }

    private String findPart(LocalTime time) {
        logger.info("Time: {}", time.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        if (time.isAfter(NIGHT_LIM.minusNanos(1)) && time.isBefore(MORNING_LIM)) {
            return "pod.morning";
        } else if (time.isAfter(MORNING_LIM.minusNanos(1)) && time.isBefore(DAY_LIM)) {
            return "pod.day";
        } else if (time.isAfter(DAY_LIM.minusNanos(1)) && time.isBefore(EVENING_LIM)) {
            return "pod.evening";
        } else {
            return "pod.night";
        }
    }
}
