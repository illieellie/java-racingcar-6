package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    final static int NUM_LENGTH_LOWER_LIMIT = 0;
    final static int NUM_LENGTH_UPPER_LIMIT = 5;
    final static String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.";

    private InputView() {

    }

    public static List<String> carsName() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] s = Console.readLine().split(","); // 차 이름 입력, 쉼표 구분

        // validation
        carsNameValidation(s);

        return Arrays.stream(s).toList();
    }

    public static void carsNameValidation(String[] s) {
        // 기본 예외 0. 이름이 5글자 이상인 문자가 있을 경우
        // 추가 예외 0. 이름을 비어서 넣을 경우
        for (int i = 0; i < s.length; i++) {
            if (!(NUM_LENGTH_LOWER_LIMIT < s[i].length() && s[i].length() <= NUM_LENGTH_UPPER_LIMIT)) {
                System.out.println(ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
        // 추가 예외 1. 동일한 이름이 있을 경우 -> 어떻게 할까?
    }

    public static int rounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            // 기본 예외 0. 숫자가 들어와야 하는데 문자가 들어왔다면
            // 추가 예외 0. 숫자가 0이면? -> test 해보기
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
