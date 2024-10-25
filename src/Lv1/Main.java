package Lv1;

import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseballGame baseballGame;

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");

        while (true) {
            System.out.println("1.게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            String input = sc.nextLine();
            //1일시 게임 시작
            if(input.equals("1") ) {
                baseballGame = new BaseballGame();
            }
            else if(input.equals("2")) {
                //Lv2 아직 기능 없음
            } // 3일시 종료
            else  if(input.equals("3")) break;
            // 1,2,3이 아닐시 경고
            else System.out.println("올바른 입력값이 아닙니다.");
        }
    }
}