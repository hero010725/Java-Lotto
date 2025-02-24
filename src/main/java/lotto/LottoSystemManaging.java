package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSystemManaging {
    public List<Lotto> issueTickets(int ticketcount)
    {
        List<Lotto> tickets = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator();
        for (int i = 0; i < ticketcount; i++) {
            List<Integer> ticketnumbers = lottoGenerator.generateLottoNumbers(); // ticketnumbers : 번호 7개
            Lotto ticket = new Lotto(ticketnumbers);
            tickets.add(ticket);
        }
        return tickets;
    }
}
