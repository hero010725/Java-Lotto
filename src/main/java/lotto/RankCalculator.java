package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCalculator {

    public Map<Rank, Integer> calculateRanks(List<Lotto> tickets, WinningNumbersManaging winningNumbers, BonusNumber bonusNumber) {
        Map<Rank, Integer> rankResults = new HashMap<>();
        for (Lotto ticket : tickets) {
            int matchCount = ticket.matchCount(winningNumbers.getnumbers());
            boolean bonusMatch = ticket.contains(bonusNumber.getBonusNumber());
            Rank rank = Rank.determineRank(matchCount, bonusMatch);
            rankResults.put(rank, rankResults.getOrDefault(rank, 0) + 1);
        }
        return rankResults;
    }
}
