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
        assertEquals("", ohce.process(""));
    }

    @Test
    public void aFirstFlip() {
        Ohce ohce = new Ohce(LocalTime.now());
        assertEquals("pilF", ohce.process("Flip"));
    }

    @Test
    public void anotherFlip() {
        Ohce ohce = new Ohce(LocalTime.now());
        assertEquals("drauodE", ohce.process("Edouard"));
    }

    @Test
    public void blankIsAPalindrome() {
        Ohce ohce = new Ohce(LocalTime.now());
        assertTrue(ohce.isAPalindrome("",""));
    }
}
