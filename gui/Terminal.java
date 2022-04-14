import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal {
    public void processCmd(String command) {
        if (command.equals("exit")) {
            System.exit(0);
        } else if (command != null && !command.isEmpty()) {
            execCommand(command);
        }
}

public void execCommand(String input) {
        try {
            Runtime r = Runtime.getRuntime();                    

            Process p = r.exec(input);

            BufferedReader in =
                new BufferedReader(new InputStreamReader(p.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
}
}
