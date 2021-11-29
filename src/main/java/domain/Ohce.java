package domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ohce {
    private LocalTime time;

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
        if (Integer.parseInt(time.format(DateTimeFormatter.ofPattern("HH"))) == 16) {
            return "¡Buenas tardes " + name + "!";
        }
        if (Integer.parseInt(time.format(DateTimeFormatter.ofPattern("HH"))) == 23) {
            return "¡Buenas noches " + name + "!";
        }
        return "¡Buenas dias " + name + "!";
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


}
