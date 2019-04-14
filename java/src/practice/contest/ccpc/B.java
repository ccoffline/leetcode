package practice.contest.ccpc;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        LocalDateTime to = LocalDateTime.of(2050, 1, 1, 0, 0, 0);
        s.nextLine();
        while (T-- > 0) {
            String[] t = s.nextLine().split(" ");
            System.out.println(Duration.between(LocalDateTime.of(LocalDate.parse(t[0]), LocalTime.parse(t[1])), to).getSeconds() % 100);
        }
    }
}
