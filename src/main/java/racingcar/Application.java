package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
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
