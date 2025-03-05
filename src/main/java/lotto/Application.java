package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String inputMoney = Console.readLine();
            int ticketCount = validateTicketCount(inputMoney);
            LottoSystemManaging lottoSystemManaging = new LottoSystemManaging();
            List<Lotto> tickets = lottoSystemManaging.issueTickets(ticketCount);
            printTickets(tickets);
            // 당첨번호
            WinningNumbersManaging winningNumbers = new WinningNumbersManaging();
            // 보너스 넘버
            BonusNumber BonusNumber = new BonusNumber();
            winningNumbers.addnumber(BonusNumber.getBonusNumber());
            // 결과 출력
            RankCalculator rankCalculator = new RankCalculator();
            Map<Rank, Integer> results = rankCalculator.calculateRanks(tickets, winningNumbers, BonusNumber);
            printRankResults(results, inputMoney);
            // 결과 출력
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            //return;
        }
    }

    private static int validateTicketCount(String inputMoney) {
        int money;
        try {
            money = Integer.parseInt(inputMoney.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력되어야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위 이어야 합니다.");
        }
        return money / 1000;
    }

    private static void printTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket);
        }
    }

    private static void printRankResults(Map<Rank, Integer> results, String inputMoney) {
        System.out.println("당첨 통계 ");
        System.out.println("---");
        Rank[] order = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
        int totalPrize = 0;
        for (Rank rank : order) {
            int count = results.getOrDefault(rank, 0);
            if (!rank.toString().isEmpty()) {
                System.out.println(rank.toString() + " - " + count + "개");
                totalPrize += rank.getPrize() * count;
            }
        }
        int money = Integer.parseInt(inputMoney.trim());
        double yieldRate = ((double) totalPrize / money) * 100;
        System.out.println("총 수익률은 " + yieldRate + "%입니다.");
    }
}
