package test.domain;

import domain.Reverser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverserTest {

    @Test
    public void emptyFlip() {
        assertEquals("", Reverser.reverse(""));
    }

    @Test
    public void aFirstFlip() {
        assertEquals("pilF", Reverser.reverse("Flip"));
    }

    @Test
    public void anotherFlip() {
        assertEquals("drauodE", Reverser.reverse("Edouard"));
    }
}
