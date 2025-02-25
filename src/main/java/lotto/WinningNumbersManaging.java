package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class WinningNumbersManaging {
    private final List<Integer> numbers;

    public WinningNumbersManaging() {
        this.numbers = inputAndValidateWinningNumbers();
    }

    private List<Integer> inputAndValidateWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        String[] tokens = inputWinningNumbers.split(",");
        if(tokens.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 6개여야 합니다.");
        }
        List<Integer> winningNumbers = new ArrayList<>();
        for (String token : tokens) {
            int number = Integer.parseInt(token.trim());
            if (number < 1 || number > 45) { // 당첨번호 숫자 범위 확인
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이여야 합니다.");
            }
            if (winningNumbers.contains(number)) { // 당첨번호에 중복검사
                throw new IllegalArgumentException("[ERROR] 당첨번호에 중복이 존재합니다.");
            }
            winningNumbers.add(number);
        }
        return winningNumbers;
    }

    // 당첨번호 반환
    public List<Integer> getnumbers() {
        return numbers;
    }

    public void addnumber(int number) {
        numbers.add(number);
    }

}
