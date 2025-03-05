package lotto;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;      // 일치하는 번호의 개수
    private final boolean bonusMatch;  // 보너스 번호 일치 여부
    private final int prize;           // 상금

    Rank(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank determineRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && bonusMatch) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return NONE;
    }

    @Override
    public String toString() {
        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 불 일치 (%s원)", matchCount, String.format("%,d", prize));
        }
        if (this == NONE) {
            return "";
        }
        return String.format("%d개 일치 (%s원)", matchCount, String.format("%,d", prize));
    }
}
