package Lv1;

import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean switchs = true;

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");

        while (switchs) {
            System.out.println("1.게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            BaseballGame baseballGame = new BaseballGame();
            String input = sc.nextLine();
            //1일시 게임 시작
            switch (input) {
                //1 입력시 게임 진행
                case "1" -> baseballGame.play();
                //2 입력시 게임 회차 및 게임 진행 횟수 출력
                case "2" -> {
                    for (int j = 1; j <= BaseballGame.getGameCount(); j++) {
                        System.out.println(j + "번째 게임 : 시도 횟수 - " + BaseballGame.gameCounter.get(j -1));
                    }
                }
                //3입력 시 종료
                case "3" -> {System.out.println("< 숫자 야구 게임을 종료합니다 > "); switchs =false; }
                //1,2,3 이외에 다른 입력값 입력시
                default -> System.out.println("올바른 숫자를 입력해주세요!");
            }

        }
    }


}
