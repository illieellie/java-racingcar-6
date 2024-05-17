package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
    String[] cars;
    int[] scores;
    final String INPUT_COMMENT_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final String INPUT_COMMENT_ROUNDS = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {


        final int ROUNDS;

        // TODO: 프로그램 구현
        Application game = new Application();

        game.userInputCarsName();
        ROUNDS = game.userInputRounds();

    }

    public void userInputCarsName(){
        comment(INPUT_COMMENT_CARS);
        String inputString = Console.readLine();
        // 쉼표 기준으로 String 배열에 넣기
        cars = inputString.split(",");

        // validation
        for(int i = 0;i<cars.length; i++){
            // 디버깅 해보기
            if(cars[i].length()>5){
                throw new IllegalArgumentException();
            }
        }
        // 기본 예외0. 이름이 5글자 이상인 문자가 있을 경우
        // 조건 예외1. 입력에 쉼표가 없을 경우 -> 없을 수 있음. 한사람만 참여할 수 있기 때문
        // 조건 예외2. 입력에 쉼표가 연달아 들어올 경우
    }

    public int userInputRounds(){
        comment(INPUT_COMMENT_ROUNDS);
        int inputInt = Integer.parseInt(Console.readLine());

            // validation
            // 조건 예외1. 숫자가 들어와야 하는데 문자가 들어왔다면 -> (현상황) 그냥 정상적으로 끝남
        return inputInt;
    }

    public void comment(String s) {
        System.out.println(s);
    }


}

// Randoms.pickNumberInRange(0,9);
// readLine()