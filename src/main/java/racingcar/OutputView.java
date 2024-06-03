package racingcar;

import java.util.List;

public class OutputView {
    public static void printResultRound(List<String> cars, List<Integer> scores) {
        // scores 만큼 출력
        for (int i = 0; i < cars.size(); i++) {
            System.out.print(cars.get(i) + " : ");
            for (int j = 0; j < scores.get(i); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void printResultGame(List<String> winner) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winner.size(); i++) {
            System.out.print(winner.get(i));
            if (i != winner.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
