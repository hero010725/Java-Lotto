package lotto;

import camp.nextstep.edu.missionutils.Console;


public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber() {
        this.bonusNumber = inputandValidateBonusNumber();
    }

    private int inputandValidateBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        String bonusNumberInput = Console.readLine().trim();

        if (!bonusNumberInput.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        }
        int number = Integer.parseInt(bonusNumberInput);

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
        return number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
