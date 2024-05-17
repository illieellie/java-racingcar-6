package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
    private String[] cars;
    private int[] scores;
    private final int MOVING_FORWARD = 4;
    private final String INPUT_COMMENT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_COMMENT_ROUNDS = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {

        final int ROUNDS;

        // TODO: 프로그램 구현
        Application game = new Application();

        game.userInputCarsName();
        ROUNDS = game.userInputRounds();
        for (int i = 0; i < ROUNDS; i++) {
            game.startRound();
            game.resultPrintRound();
        }
        game.resultPrintAll();
    }

    private void userInputCarsName() {
        comment(INPUT_COMMENT_CARS);
        String inputString = Console.readLine();
        // 쉼표 기준으로 String 배열에 넣기
        cars = inputString.split(",");
        scores = new int[cars.length];

        // validation
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        // 기본 예외0. 이름이 5글자 이상인 문자가 있을 경우
        // 조건 예외1. 입력에 쉼표가 없을 경우 -> 없을 수 있음. 한사람만 참여할 수 있기 때문
        // 조건 예외2. 입력에 쉼표가 연달아 들어올 경우
    }

    private int userInputRounds() {
        comment(INPUT_COMMENT_ROUNDS);
        int inputInt;
        try {
            inputInt = Integer.parseInt(Console.readLine());
            // validation
            // 기본 예외1. 숫자가 들어와야 하는데 문자가 들어왔다면
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return inputInt;
    }

    private void comment(String s) {
        System.out.println(s);
    }

    private void startRound() {
        // 참가자 수 만큼
        for (int i = 0; i < cars.length; i++) {
            int temp = Randoms.pickNumberInRange(0, 9);
            if (temp >= MOVING_FORWARD) {
                scores[i]++;
            }
        }
    }

    private void resultPrintRound() {
        // scores 만큼 출력
        for (int i = 0; i < cars.length; i++) {
            System.out.print(cars[i] + " : ");
            for (int j = 0; j < scores[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private void resultPrintAll() {
        // 최종 우승자 : pobi
        // 최종 우승자 : pobi, jun
        List<String> temp = new ArrayList<>();
        int maxScore = 0;
        // temp 에 담고 clear
        for (int i = 0; i < cars.length; i++) {
            if (maxScore < scores[i]) {
                temp.clear();
                maxScore = scores[i];
                temp.add(cars[i]);
            } else if (maxScore == scores[i]) {
                temp.add(cars[i]);
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < temp.size(); i++) {
            System.out.print(temp.get(i));
            if (i != temp.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
