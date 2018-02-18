import java.io.*;
import java.util.*;

public class cadenasInputGenerator {

    public static final String INPUT_ROOT = "./docs/inputCadenas.txt";
    static PrintWriter printer;
    static Random rdm;

    public static void main(String[] args) throws IOException {
        printer = new PrintWriter(new File(INPUT_ROOT));
        rdm = new Random();
        int veces = 250;
        printer.write(veces + "\n");

        while (veces > 0) {
            int stringLength = 10 + rdm.nextInt(90);

            for (int i = 0; i < stringLength; i++)
                printer.write((char) (65 + rdm.nextInt(25)));
            printer.write("\n");

            stringLength = 1 + rdm.nextInt(49);

            for (int i = 0; i < stringLength; i++) {
                int random = rdm.nextInt(3);
                switch (random) {
                    case 0:
                        printer.write('+');
                        break;
                    case 1:
                        printer.write('-');
                        break;
                    default:
                        printer.write('x');
                        break;
                }
            }
            printer.write("\n");
            veces--;
        }

        printer.close();
    }
}
