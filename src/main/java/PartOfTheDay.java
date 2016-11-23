import java.time.LocalTime;

public class PartOfTheDay {
    LocalTime NIGHT_LIM = LocalTime.of(6,0,0);
    LocalTime MORNING_LIM = LocalTime.of(9,0,0);
    LocalTime DAY_LIM = LocalTime.of(19,0,0);
    LocalTime EVENING_LIM = LocalTime.of(23,0,0);

    public String getPartOfTheDay() {
        LocalTime time = LocalTime.now();
        return findPart(time);
    }

    public String getPartOfTheDay(LocalTime time) {
        return findPart(time);
    }

    private String findPart(LocalTime time) {
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
