package eugene.boldyrev._1_tickets;

import eugene.boldyrev.testit.TestRunner;

public class Main {

    public static void main(String[] args) {
        String testsPath = "C:\\Books\\Алгоритмы\\otus\\hw_2\\1.Tickets";

        TestRunner testRunner = new TestRunner(testsPath, new TestableLuckyTickets());
        testRunner.runTests();
    }

}