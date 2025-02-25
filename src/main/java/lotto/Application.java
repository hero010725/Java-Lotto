package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String inputMoney = Console.readLine();
            int ticketcount = validateTicketCount(inputMoney);
            LottoSystemManaging lottoSystemManaging = new LottoSystemManaging();
            WinningNumbersManaging winningNumbers = new WinningNumbersManaging();
            BonusNumber BonusNumber = new BonusNumber();

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return; // 애플리케이션 종료
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
