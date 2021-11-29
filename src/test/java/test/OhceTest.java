package test;

import static org.junit.jupiter.api.Assertions.*;

import domain.Ohce;
import org.junit.jupiter.api.Test;

public class OhceTest {

    @Test
    public void firstTest() {
        String time = "16:00";
        Ohce ohce = new Ohce(time);
        assertEquals("¡Buenas tardes Pedro!", ohce.greet("Pedro"));
    }

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
