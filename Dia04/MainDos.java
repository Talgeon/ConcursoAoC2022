import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Integer.parseInt;

public class MainDos {
    private static Pattern P_PAIR = Pattern.compile("(\\d+)-(\\d+),(\\d+)-(\\d+)");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cuenta = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Matcher m = P_PAIR.matcher(line);
            if (m.matches()) {
                int minUno = parseInt(m.group(1));
                int maxUno = parseInt(m.group(2));
                int minDos = parseInt(m.group(3));
                int maxDos = parseInt(m.group(4));
                if (!(maxUno < minDos || minUno > maxDos)) {
                    cuenta++;
                }
            }
        }
        System.out.println(cuenta);
        sc.close();
    }
}