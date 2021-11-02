package homework1;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        Locale locale = new Locale(args[0], args[1]);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("MessagesBundle", locale);
        System.out.println(resourceBundle.getString("cd"));
        System.out.println(resourceBundle.getString(".."));
        System.out.println(resourceBundle.getString("fileName"));
        TerminalImpl terminal = new TerminalImpl();
        terminal.manageTerminal();

    }
}
