package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.Exception.INVALID_BONUS_NUMBER_INPUT_TYPE;
import static lotto.Exception.INVALID_WINNING_NUMBERS_INPUT_TYPE;
import static lotto.Exception.ONLY_NUMERIC_INPUT_FOR_MONEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Nested
    class 구입금액_입력_테스트 extends NsTest {

        @Test
        void 구입금액이_숫자가_아닌_경우_예외() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("input"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ONLY_NUMERIC_INPUT_FOR_MONEY.getMessage());
            });
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            inputView.inputMoney();
        }
    }

    @Nested
    class 당첨번호_입력_테스트 extends NsTest {
        @Test
        void 당첨번호_입력시_숫자와_구분자_공백이_아닌_다른_문자가_포함된_경우_예외() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("1.2.3.4.8.6"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_WINNING_NUMBERS_INPUT_TYPE.getMessage());
            });
        }

        @Test
        void 당첨번호에_공백이_있는_경우_제거() {
            assertSimpleTest(() -> {
                run("1,2,3,4,  5, 7");
                assertThat(output()).contains("1", "2", "3", "4", "5", "7");
            });
        }

        @Test
        void 당첨번호가_숫자가_아닌_경우_예외() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("1,2,3,4, a, 6"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_WINNING_NUMBERS_INPUT_TYPE.getMessage());
            });
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            System.out.println(winningNumbers);
        }
    }

    @Nested
    class 보너스번호_입력_테스트 extends NsTest {
        @Test
        void 보너스_번호가_숫자가_아닌_경우_예외() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(INVALID_BONUS_NUMBER_INPUT_TYPE.getMessage());
            });
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            inputView.inputBonusNumber();
        }
    }
}
