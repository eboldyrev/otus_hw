package eugene.boldyrev._9_external_sort;

import eugene.boldyrev._8_simple_sorts.SortsMarket;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TestFileGenerator {

    private static final int MAX_LINES = 10_000;

    public static Path generateTestFile(int linesCount, int maxNumber) throws IOException {
        List<String> ints = SortsMarket.generateRandomStrings(linesCount, maxNumber);
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.write(tempFile, ints, StandardOpenOption.WRITE);
        return tempFile;
    }

    public static void main(String[] args) {

    }
}
