import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;

public class MainDos {
    public static void main(String[] args) {
        ArrayList<ArrayDeque<Character>> piles = new ArrayList<ArrayDeque<Character>>(9);
        IntStream.range(0, 9).forEach((int i) -> piles.add(new ArrayDeque<>()));
        Scanner sc = new Scanner(System.in);
    for (String line = sc.nextLine(); line.charAt(0) == '['; line = sc.nextLine()) {
            for (int i = 1, j = 0; i <= 34; i += 4, j++) {
                if (line.charAt(i) != ' ') {
                    piles.get(j).addLast(line.charAt(i));
                }
            }
        }
        sc.nextLine();
        String order;
        Pattern P_ORDER = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
        while (sc.hasNextLine()) {
            order = sc.nextLine();
            Matcher m = P_ORDER.matcher(order);
            if (m.matches()) {
                int size = parseInt(m.group(1));
                ArrayDeque<Character> movenda = new ArrayDeque<>(size);
                IntStream
                    .range(0, size)
                    .forEach((int n) -> movenda.addLast(piles.get(parseInt(m.group(2)) - 1)
                    .pollFirst()));
                IntStream
                    .range(0, size)
                    .forEach((int n) -> piles.get(parseInt(m.group(3)) - 1)
                    .addFirst(movenda.pollLast()));
            } else {
                throw(new NoSuchElementException("Algo ha salido mal."));
            }
        }
        IntStream.range(0, 9)
        .mapToObj((int n) -> piles.get(n))
        .forEach((ArrayDeque<Character> arr) -> System.out.print(arr.getFirst()));
    }
}