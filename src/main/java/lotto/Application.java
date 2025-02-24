package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String inputMoney = Console.readLine();
            int ticketcount = validateTicketCount(inputMoney);
            LottoSystemManaging lottoSystemManaging = new LottoSystemManaging();



        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            System.exit(1); // 애플리케이션 종료
        }


        // 테스트용
        // TEST
    }

    private static int validateTicketCount(String inputMoney) {
        int money;
        try {
            money = Integer.parseInt(inputMoney.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력되어야 합니다.");
        }
            if (money % 1000 !=0)
            {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위 이어야 합니다.");
            }
        return money/1000;
    }
}


/*
사용자에게 입력받음 -> Application
입력받은 돈으로 코인개수 정하거나 알맞게 들어갔는지 확인하기
복권 사스템 관리 ( 결과 출력까지 관리 )  LottoSystemManaging
복권 관리 LottoManaging
복권 Lotto
복권 추상 AbstractLotto


 */