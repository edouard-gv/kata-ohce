package test.infrastructure;

import domain.IWantToQuitException;
import domain.Ohce;
import infrastructure.OhceConsole;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MainTest {
    @Test
    public void checkNoArgs() {
        assertEquals("Not enough arguments, I need your name as first and only arguments. Usage : Ohce <your name>", OhceConsole.checkInputArguments(new String[]{}));
    }

    @Test
    public void TooMuchNoArgs() {
        assertEquals("Too much arguments, I need your name as first and only arguments. Usage : Ohce <your name>", OhceConsole.checkInputArguments(new String[]{"Pedro", "Maria"}));
    }

    @Test
    public void checkOneArgs() {
        assertNull(OhceConsole.checkInputArguments(new String[]{"Pedro"}));
    }


    @Test
    public void formattedSingleAnswer() throws IWantToQuitException {
        Ohce ohce = new Ohce(LocalTime.now());
        List<String> flip = ohce.process("bobo");
        assertEquals("> obob", OhceConsole.formatMessages(flip));
    }

    @Test
    public void formattedMultipleAnswers() throws IWantToQuitException {
        Ohce ohce = new Ohce(LocalTime.now());
        List<String> flip = ohce.process("bob");
        assertEquals("> bob\n> ¡Bonita palabra!", OhceConsole.formatMessages(flip));
    }
}
