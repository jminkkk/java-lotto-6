package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Ranking;
import lotto.WinningStatistics;

public class OutputView {
    private static final String LOTTO_PURCHASE_QUANTITY = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String SEPARATOR_LINE = "---";
    private static final String NEW_LINE = "";

    public static void println(String message) {
        System.out.println(message);
    }

    public static void println() {
        println(NEW_LINE);
    }

    public static void printLottoList(List<Lotto> lottos) {
        println(lottos.size() + LOTTO_PURCHASE_QUANTITY);
        lottos.forEach(OutputView::printLotto);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printLottoStatistics(WinningStatistics winningStatistics) {
        println(WINNING_STATISTICS);
        println(SEPARATOR_LINE);

        printRankingDetails(winningStatistics.rankingNumber());
        printReturnRate(winningStatistics);
    }

    private static void printRankingDetails(Map<Ranking, Integer> rankingNumber) {
        for (Ranking ranking : Ranking.values()) {
            println(ranking.getCriteria() + " - " + rankingNumber.getOrDefault(ranking, 0) + "개");
        }
    }

    private static void printReturnRate(WinningStatistics winningStatistics) {
        println("총 수익률은 " + winningStatistics.getReturnRate() + "%입니다.");
    }
}
