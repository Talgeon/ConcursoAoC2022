import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class MainDos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cuenta = 0;
        while (sc.hasNextLine()) {
            String[] lines = {sc.nextLine(), sc.nextLine(), sc.nextLine()};
            int commonChar = lines[0].chars()
            .filter(containsChar(lines[1]).and(containsChar(lines[2])))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Algo ha salido mal"));
            cuenta += (commonChar >= 'a' && commonChar <= 'z') ? commonChar - 'a' + 1: commonChar - 'A' + 27;
        }
        System.out.println(cuenta);
    }
    
    public static IntPredicate containsChar(String s) {
        return (int c) -> s.indexOf(c) != -1;
    }
}
