package domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ohce {
    private final LocalTime time;

    public Ohce(LocalTime time) {
        this.time = time;
    }

    public static String checkInputArguments(String[] args) {
        return switch (args.length) {
            case 0 -> "Not enough arguments, I need your name as first and only arguments. Usage : Ohce <your name>";
            case 1 -> null;
            default -> "Too much arguments, I need your name as first and only arguments. Usage : Ohce <your name>";
        };
    }

    public String greet(String name) {
        int hours = Integer.parseInt(time.format(DateTimeFormatter.ofPattern("HH")));
        if (hours < 6 || hours >= 20) {
            return greetFormat(name, "noches");
        }
        if (hours < 12) {
            return greetFormat(name, "dias");
        }
        return greetFormat(name, "tardes");
    }

    private String greetFormat(String name, String dayPeriod) {
        return "¡Buenas "+dayPeriod+" "+ name + "!";
    }

    public static void main(String[] args) {
        String check = checkInputArguments(args);
        if (check != null) {
            System.err.println(check);
            return;
        }

        String name = args[0];

        System.out.println(new Ohce(LocalTime.now()).greet(name));
    }

    public String process(String flip) {
        char[] flipArray = flip.toCharArray();
        StringBuilder flippedBuffer = new StringBuilder();
        for (int pos = flipArray.length -1 ; pos >= 0; pos--) {
            flippedBuffer.append(flipArray[pos]);
        }
        return flippedBuffer.toString();
    }
}
