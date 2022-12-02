import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cuenta = 0;
        String round;
        while (sc.hasNextLine()) {
            round = sc.nextLine();
            switch(round.chars().sum() - ' ') {
                case 154,157 -> cuenta += 1 + 3 * (round.charAt(2) - 'X');
                case 155 -> cuenta += 2 + 3 * (round.charAt(2) - 'X');
                case 153, 156 -> cuenta += 3 * (round.charAt(2) - 'W');
                default -> throw(new InputMismatchException("Algo ha salido mal"));
            }
        }
        System.out.println(cuenta);
        sc.close();
    }
}
