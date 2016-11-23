import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class PartOfTheDayTest {
    private static PartOfTheDay pod;

    @BeforeClass
    public static void init() {
        pod = new PartOfTheDay();
    }

    @Test
    public void testGetPartOfTheDayMorning() {
        assertEquals("pod.morning", pod.getPartOfTheDay(LocalTime.of(7,0,0)));
    }
    @Test
    public void testGetPartOfTheDayDay() {
        assertEquals("pod.day", pod.getPartOfTheDay(LocalTime.of(13,0,0)));
    }
    @Test
    public void testGetPartOfTheDayEvening() {
        assertEquals("pod.evening", pod.getPartOfTheDay(LocalTime.of(20,0,0)));
    }
    @Test
    public void testGetPartOfTheDayNight() {
        assertEquals("pod.night", pod.getPartOfTheDay(LocalTime.of(2,0,0)));
    }
    @Test
    public void testGetPartOfTheDay() {
        assertNotNull(pod.getPartOfTheDay());
    }
}