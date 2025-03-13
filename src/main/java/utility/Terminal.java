package utility;

public class Terminal {

    /// Runs the given command in the terminal.
    public static void runCommand(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (Exception e) {
            System.out.println("An error occurred while running the terminal code. Command: " + command +" Fehler -> "+ e);
        }
    }
}
