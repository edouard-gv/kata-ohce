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
    public void firstTest() {
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
}
