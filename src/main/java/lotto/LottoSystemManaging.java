package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSystemManaging {
    public List<Lotto> issueTickets(int ticketCount)
    {
        List<Lotto> tickets = new ArrayList<>();
        LottoGenerator lottoGenerator = new LottoGenerator();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> ticketNumbers = lottoGenerator.generateLottoNumbers(); // ticketNumbers : 번호 7개
            Lotto ticket = new Lotto(ticketNumbers);
            tickets.add(ticket);
        }
        return tickets;
    }
}
