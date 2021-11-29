package test;

import domain.Ohce;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

public class OhceTest {

    @Test
    public void inTheAfternoon() {
        LocalTime time = LocalTime.now(Clock.fixed(Instant.parse("2020-04-16T16:00:00Z"), ZoneId.of("UTC")));
        Ohce ohce = new Ohce(time);
        assertEquals("¡Buenas tardes Pedro!", ohce.greet("Pedro"));
    }

    @Test
    public void testWithAnotherName() {
        LocalTime time = LocalTime.now(Clock.fixed(Instant.parse("2020-04-16T16:00:00Z"), ZoneId.of("UTC")));
        Ohce ohce = new Ohce(time);
        assertEquals("¡Buenas tardes Eduardo!", ohce.greet("Eduardo"));
    }

    @Test
    public void inTheMorning() {
        LocalTime time = LocalTime.now(Clock.fixed(Instant.parse("2020-04-16T10:00:00Z"), ZoneId.of("UTC")));
        Ohce ohce = new Ohce(time);
        assertEquals("¡Buenas dias Eduardo!", ohce.greet("Eduardo"));
    }

    @Test
    public void inTheNight() {
        LocalTime time = LocalTime.now(Clock.fixed(Instant.parse("2020-04-16T23:00:00Z"), ZoneId.of("UTC")));
        Ohce ohce = new Ohce(time);
        assertEquals("¡Buenas noches Eduardo!", ohce.greet("Eduardo"));
    }

    @ParameterizedTest
    @CsvSource({"05:59,noches", "06:00,dias", "11:59,dias", "12:00,tardes", "19:59,tardes", "20:00,noches"})
    public void timeBorderCases(String hourIn, String wordOut) {
        LocalTime time = LocalTime.now(Clock.fixed(Instant.parse("2020-04-16T"+hourIn+":00Z"), ZoneId.of("UTC")));
        Ohce ohce = new Ohce(time);
        assertEquals("¡Buenas "+wordOut+" Eduardo!", ohce.greet("Eduardo"));
    }

    @Test
    public void emptyFlip() {
        Ohce ohce = new Ohce(LocalTime.now());
        assertEquals("", ohce.process("").get(0));
    }

    @Test
    public void aFirstFlip() {
        Ohce ohce = new Ohce(LocalTime.now());
        List<String> flip = ohce.process("Flip");
        assertEquals(1, flip.size());
        assertEquals("pilF", flip.get(0));
    }

    @Test
    public void anotherFlip() {
        Ohce ohce = new Ohce(LocalTime.now());
        assertEquals("drauodE", ohce.process("Edouard").get(0));
    }

    @Test
    public void aFlipPalindrome() {
        Ohce ohce = new Ohce(LocalTime.now());
        List<String> flip = ohce.process("bob");
        assertEquals(2, flip.size());
        assertEquals("bob", flip.get(0));
        assertEquals("¡Bonita palabra!", flip.get(1));
    }

    @Test
    public void formattedSingleAnswer() {
        Ohce ohce = new Ohce(LocalTime.now());
        List<String> flip = ohce.process("bobo");
        assertEquals("> obob\n$ ", ohce.formatMessages(flip));
    }
}
