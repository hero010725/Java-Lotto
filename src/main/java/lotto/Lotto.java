package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = Collections.unmodifiableList(new ArrayList<>(numbers));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) { // 6개 입력됐는지 검사
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        long distinctCount = numbers.stream().distinct().count(); // 중복 검사
        if (distinctCount != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있으면 안됩니다.");
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int matchCount(List<Integer> otherNumbers) {
        int count = 0;
        for (Integer number : numbers) {
            if (otherNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}
