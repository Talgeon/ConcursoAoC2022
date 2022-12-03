import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cuenta = 0;
        String rucksack, partOne;
        while (sc.hasNextLine()) {
            rucksack = sc.nextLine();
            partOne = rucksack.substring(0, rucksack.length()/2);
            String partTwo = rucksack.substring(rucksack.length()/2);
            char commonChar = (char) partOne.chars()
            .filter((int n) -> partTwo.indexOf(n) > -1)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Algo ha salido mal."));
            cuenta += (commonChar >= 'a' && commonChar <= 'z') ? commonChar - 'a' + 1: commonChar - 'A' + 27;
        }
        System.out.println(cuenta);
    }
}