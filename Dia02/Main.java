import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cuenta = 0;
        String round;
        while (sc.hasNextLine()) {
            round = sc.nextLine();
            cuenta += switch (round.charAt(0) + 'X' - 'A' - round.charAt(2)) {
                case 2, -1 -> 6;
                case 0 -> 3;
                default -> 0;
            };
            cuenta += round.charAt(2) - 'W';
        }
        System.out.println(cuenta);
        sc.close();
    }
}