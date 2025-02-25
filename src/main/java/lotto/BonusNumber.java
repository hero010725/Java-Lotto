package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BonusNumber {

    private final int bonusNumber;
    public BonusNumber() {
        this.bonusNumber = inputandValidateBonusNumber();
    }
    private int inputandValidateBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        String inputbonusnumber = Console.readLine().trim();

        if (!inputbonusnumber.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        }
        int number = Integer.parseInt(inputbonusnumber);

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
        return number;
    }

}
