package infrastructure;

import domain.IWantToQuitException;
import domain.Ohce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.List;

public class OhceConsole {
    private static final String NO_ARGUMENT_ERROR_MESSAGE = "Not enough arguments, I need your name as first and only arguments. Usage : Ohce <your name>";
    private static final String TOO_MUCH_ARGUMENTS_ERROR_MESSAGE = "Too much arguments, I need your name as first and only arguments. Usage : Ohce <your name>";
    private static final String BYE = "Bye!";
    private static final String CONSOLE_PROMPT = "$ ";
    static final String CONSOLE_LINE_BEGINNING = "> ";
    private static final String NEW_LINE = "\n";

    public static String checkInputArguments(String[] args) {
        return switch (args.length) {
            case 0 -> NO_ARGUMENT_ERROR_MESSAGE;
            case 1 -> null;
            default -> TOO_MUCH_ARGUMENTS_ERROR_MESSAGE;
        };
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
                System.out.println(formatMessages(ohce.process(input)));
            }
        } catch (IWantToQuitException e) {
            System.out.println(CONSOLE_LINE_BEGINNING + BYE);
            return;
        }
    }

    public static String formatMessages(List<String> messages) {
        return OhceConsole.CONSOLE_LINE_BEGINNING + messages.get(0)+(messages.size()>1? NEW_LINE + OhceConsole.CONSOLE_LINE_BEGINNING+messages.get(1):"");
    }
}
