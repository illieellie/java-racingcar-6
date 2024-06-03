package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private final int MOVING_FORWARD = 4;
    List<String> cars; // 자동차 이름
    List<Integer> scores;

    public Car(List<String> cars) {
        this.cars = cars;
        //scores = new ArrayList<>(cars.size()); // 이렇게 하면 용량 지정만 되고 공간 할당이 안 됨
        scores = new ArrayList<>(Collections.nCopies(cars.size(), 0));
    }

    public List<Integer> playRound() {
        for (int i = 0; i < cars.size(); i++) {
            int temp = Randoms.pickNumberInRange(0, 9);

            if (temp >= MOVING_FORWARD) {
                scores.set(i, scores.get(i) + 1);
            }
        }
        return scores;
    }

    public List<String> findWinner() {
        List<String> temp = new ArrayList<>();
        int maxScore = 0;
        // temp 에 담고 clear
        for (int i = 0; i < cars.size(); i++) {
            if (maxScore < scores.get(i)) {
                temp.clear();
                maxScore = scores.get(i);
                temp.add(cars.get(i));
            } else if (maxScore == scores.get(i)) {
                temp.add(cars.get(i));
            }
        }
        return temp;
    }
}
