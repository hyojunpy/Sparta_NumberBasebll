package Lv1;

import java.util.*;

public class BaseballGame {
    Scanner sc = new Scanner(System.in);
    //게임을 진행할 숫자
    List<Integer> Attack = new ArrayList<>();
    //들어온 숫자
    String input;
    //난수 생성하기 위한 객체 생성
    Random random = new Random();
    //난수 담기
    List<Integer> randomNum = new ArrayList<>();
    //스트라이크 카운트
    int strike = 0;
    // 볼 카운트
    int ball = 0;
    //난이도 조절
    int level = 3;
    //게임 횟수
    private static int gameCount = 0;
    // 게임 진행 횟수
    private static int count = 0;
    //게임 횟수 별 진행 횟수 저장
    static List<Integer> gameCounter = new ArrayList<>();


    //객체 생성시 정답 생성
    public BaseballGame() {
        //난수 생성(중복없이 난이도에 맞는 갯수가 채워질때 까지 )
        while (true) {
            int randomNumber = random.nextInt(8) + 1;
            if (!randomNum.contains(randomNumber)) {
                randomNum.add(randomNumber);
            }
            if (randomNum.stream().distinct().count() == level) break;
        }
    }

    public void play() {
        count = 0;
        gameCounter = new ArrayList<>();
        System.out.println("< 게임을 시작합니다 >");
        while (true) {
            System.out.println("숫자를 입력하세요 : ");
            System.out.println(randomNum);
            input = sc.nextLine();
            //게임 진행 횟수 추가
            count++;
            // 게밍 진행 횟수 초기화
            if (validateInput(input)) {
                //스트라이크,볼 개수 계산 다 맞췄을시 정답 출력 후 종료
                countStrikeAndBall(randomNum, Attack);

                if (strike == level) {
                    System.out.println("정답입니다 축하드립니다.");
                    break;
                } else if(strike == 0 && ball == 0) {
                    System.out.println("아웃");
                }
                else  BaseballGameDisplay.displayHint(strike, ball);
                Attack.clear();
            }
        }
        //게임 횟수 추가
        gameCount++;
        //게임 진행 횟수 저장
        gameCounter.add(count);
    }

    protected boolean validateInput(String input) {
        //숫자 외 다른 문자 검사
        if (input.matches("^[0-9]*$")) {
            for (int i = 0; i < input.length(); i++) {
                Attack.add((int) input.charAt(i) - '0');
                //0이 들어왔을때 false
                if (Attack.contains(0)) {
                    System.out.println("올바르지 않은 입력값입니다.");
                    Attack.clear();
                    return false;
                }
            }
        } else System.out.println("올바르지 않은 입력값입니다.");

        //중복된 값 검사 : distinct()로 중복요소 제거 => 난이도와 같을 시 true
        if (Attack.stream().distinct().count() == level) {
            return true;
        }
        // 중복값 있을시 요소 초기화
        else {
            System.out.println("올바르지 않은 입력값입니다.");
            Attack.clear();
            return false;
        }
    }

    private void countStrikeAndBall(List<Integer> random, List<Integer> attackNum) {
        ball = 0;
        strike = 0;
        //스트라이크 볼 카운트
        for (int i = 0; i < random.size(); i++) {
            for (int j = 0; j < attackNum.size(); j++) {
                if (random.get(i).equals(attackNum.get(j))) {
                    if (i != j) {
                        ball++;
                    } else strike++;
                }
            }
        }
    }

    public static int getGameCount() {
        return gameCount;
    }

    public static int getCount() {
        return count;
    }
}