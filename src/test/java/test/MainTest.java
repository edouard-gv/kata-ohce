package test;

import domain.Ohce;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MainTest {
    @Test
    public void checkNoArgs() {
        assertEquals("Not enough arguments, I need your name as first and only arguments. Usage : Ohce <your name>", Ohce.checkInputArguments(new String[]{}));
    }

    @Test
    public void TooMuchNoArgs() {
        assertEquals("Too much arguments, I need your name as first and only arguments. Usage : Ohce <your name>", Ohce.checkInputArguments(new String[]{"Pedro", "Maria"}));
    }

    @Test
    public void checkOneArgs() {
        assertNull(Ohce.checkInputArguments(new String[]{"Pedro"}));
    }
}
