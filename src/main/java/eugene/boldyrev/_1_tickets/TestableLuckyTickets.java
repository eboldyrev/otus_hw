package eugene.boldyrev._1_tickets;

import eugene.boldyrev.testit.TestRunner;
import eugene.boldyrev.testit.Testable;

import java.util.List;

public class TestableLuckyTickets implements Testable {

    @Override
    public List<String> runTest(List<String> input) {
        LuckyTickets luckyTickets = new LuckyTickets(Integer.parseInt(input.get(0)));
        long count = luckyTickets.count();
        return List.of(""+ count);
    }

    public static void main(String[] args) {
        String testsPath = "C:\\Books\\Алгоритмы\\otus\\hw_2\\1.Tickets";

        TestRunner testRunner = new TestRunner(testsPath, new TestableLuckyTickets());
        testRunner.runTests();
    }
}
