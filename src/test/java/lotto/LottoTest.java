package lotto;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class LottoTest {

    @Test
    @DisplayName("Lotto 객체는 6개의 번호로 생성되어야 한다.")
    void createLottoSuccess() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // toString()이 오버라이드되어 있으므로 내부 번호 목록이 출력되어야 함
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘으면 예외가 발생해야 한다.")
    void invalidLottoSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개여야");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void duplicateLottoNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("contains 메서드는 Lotto 객체에 특정 숫자가 포함되어 있는지 올바르게 판단한다.")
    void containsTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.contains(3)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }

    @Test
    @DisplayName("matchCount 메서드는 다른 번호 리스트와 비교하여 일치하는 번호 개수를 반환한다.")
    void matchCountTest() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int count = lotto.matchCount(List.of(1, 2, 7, 8, 9, 10));
        // 1과 2가 일치하므로 count는 2여야 함
        assertThat(count).isEqualTo(2);
    }
}
