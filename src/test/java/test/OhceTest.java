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

}
