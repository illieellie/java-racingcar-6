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
        List<String> cars = new ArrayList<>(); // 자동차 이름
        cars = InputView.carsName();
        ROUNDS = InputView.rounds();

        Car game = new Car(cars);

        for (int i = 0; i < ROUNDS; i++) {
            OutputView.printResultRound(cars, game.playRound()); // 라운드별 결과
        }
        OutputView.printResultGame(game.findWinner()); // 게임 결과
    }

}
