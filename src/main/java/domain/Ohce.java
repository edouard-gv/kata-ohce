package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Ohce {
    private static final String NO_ARGUMENT_ERROR_MESSAGE = "Not enough arguments, I need your name as first and only arguments. Usage : Ohce <your name>";
    private static final String TOO_MUCH_ARGUMENTS_ERROR_MESSAGE = "Too much arguments, I need your name as first and only arguments. Usage : Ohce <your name>";
    private static final String NEW_LINE = "\n";
    private static final String CONSOLE_PROMPT = "$ ";
    private static final String CONSOLE_LINE_BEGINNING = "> ";
    private static final String QUIT_KEYWORD = "quit!";
    private static final String NOCHES = "noches";
    private static final String DIAS = "dias";
    private static final String TARDES = "tardes";
    private static final String BUENAS = "Buenas";
    private static final String EXCL_MARK_END = "!";
    private static final String EXCL_MARK_BEGINNING = "¡";
    private static final String BYE = "Bye!";
    private static final String BONITA_PALABRA = "¡Bonita palabra!";
    private static final int SUNRISE = 6;
    private static final int SUNSET = 20;
    private static final int MIDDAY = 12;

    private final LocalTime time;

    public Ohce(LocalTime time) {
        this.time = time;
    }

    public static String checkInputArguments(String[] args) {
        return switch (args.length) {
            case 0 -> NO_ARGUMENT_ERROR_MESSAGE;
            case 1 -> null;
            default -> TOO_MUCH_ARGUMENTS_ERROR_MESSAGE;
        };
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

    public static void main(String[] args) throws IOException {
        String check = checkInputArguments(args);
        if (check != null) {
            System.err.println(check);
            return;
        }

        String name = args[0];

        Ohce ohce = new Ohce(LocalTime.now());
        System.out.println(ohce.greet(name));
        try {
            while (true) {
                System.out.print(CONSOLE_PROMPT);
                String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
                System.out.println(ohce.formatMessages(ohce.process(input)));
            }
        } catch (IWantToQuitException e) {
            System.out.println(CONSOLE_LINE_BEGINNING + BYE);
            return;
        }
    }

    public List<String> process(String flip) throws IWantToQuitException {
        if (QUIT_KEYWORD.equals(flip)) throw new IWantToQuitException();
        char[] flipArray = flip.toCharArray();
        StringBuilder flippedBuffer = new StringBuilder();
        for (int pos = flipArray.length -1 ; pos >= 0; pos--) {
            flippedBuffer.append(flipArray[pos]);
        }
        String flippedString = flippedBuffer.toString();

        List<String> messageList = new ArrayList<>();
        messageList.add(flippedString);

        if (flip.equals(flippedString)) {
            messageList.add(BONITA_PALABRA);
        }

        return messageList;

    }

    public boolean isAPalindrome(String a, String b) {
        return true;
    }

    public String formatMessages(List<String> messages) {
        return CONSOLE_LINE_BEGINNING + messages.get(0)+(messages.size()>1? NEW_LINE + CONSOLE_LINE_BEGINNING+messages.get(1):"");
    }
}
