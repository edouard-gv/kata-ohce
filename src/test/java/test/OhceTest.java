package test;

import static org.junit.jupiter.api.Assertions.*;

import domain.Ohce;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class OhceTest {

    @Test
    public void inTheAfternoon() {
        Clock clock = Clock.fixed(Instant.parse("2020-04-16T16:00:00Z"), ZoneId.of("UTC"));
        LocalTime time = LocalTime.now(clock);
        Ohce ohce = new Ohce(time);
        assertEquals("¡Buenas tardes Pedro!", ohce.greet("Pedro"));
    }

    @Test
    public void testWithAnotherName() {
        Clock clock = Clock.fixed(Instant.parse("2020-04-16T16:00:00Z"), ZoneId.of("UTC"));
        LocalTime time = LocalTime.now(clock);
        Ohce ohce = new Ohce(time);
        assertEquals("¡Buenas tardes Eduardo!", ohce.greet("Eduardo"));
    }

    @Test
    public void inTheMorning() {
        Clock clock = Clock.fixed(Instant.parse("2020-04-16T10:00:00Z"), ZoneId.of("UTC"));
        LocalTime time = LocalTime.now(clock);
        Ohce ohce = new Ohce(time);
        assertEquals("¡Buenas dias Eduardo!", ohce.greet("Eduardo"));
    }

    @Test
    public void inTheNight() {
        Clock clock = Clock.fixed(Instant.parse("2020-04-16T23:00:00Z"), ZoneId.of("UTC"));
        LocalTime time = LocalTime.now(clock);
        Ohce ohce = new Ohce(time);
        assertEquals("¡Buenas noches Eduardo!", ohce.greet("Eduardo"));
    }

}
