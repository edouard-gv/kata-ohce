package domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Ohce {
    private static final String BUENAS = "Buenas";
    private static final String NOCHES = "noches";
    private static final String DIAS = "dias";
    private static final String TARDES = "tardes";
    private static final String EXCL_MARK_END = "!";
    private static final String EXCL_MARK_BEGINNING = "¡";
    private static final String BONITA_PALABRA = "¡Bonita palabra!";
    private static final int SUNRISE = 6;
    private static final int SUNSET = 20;
    private static final int MIDDAY = 12;
    private static final String QUIT_KEYWORD = "quit!";

    private final LocalTime time;

    public Ohce(LocalTime time) {
        this.time = time;
    }

    public String greet(String name) {
        int hours = Integer.parseInt(time.format(DateTimeFormatter.ofPattern("HH")));
        if (hours < SUNRISE || hours >= SUNSET) {
            return greetFormat(name, NOCHES);
        }
        if (hours < MIDDAY) {
            return greetFormat(name, DIAS);
        }
        return greetFormat(name, TARDES);
    }

    private String greetFormat(String name, String dayPeriod) {
        return EXCL_MARK_BEGINNING + BUENAS + " " +dayPeriod+" "+ name + EXCL_MARK_END;
    }

    public List<String> process(String flip) throws IWantToQuitException {
        if (QUIT_KEYWORD.equals(flip)) throw new IWantToQuitException();

        String flippedString = Reverser.reverse(flip);

        List<String> messageList = new ArrayList<>();
        messageList.add(flippedString);

        if (flip.equals(flippedString)) {
            messageList.add(BONITA_PALABRA);
        }

        return messageList;

    }

}
