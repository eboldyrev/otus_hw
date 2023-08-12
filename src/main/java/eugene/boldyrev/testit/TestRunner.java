package eugene.boldyrev.testit;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class TestRunner {
    enum TestResult {
        Passed,
        Failed,
        Error
    }
    private final String pathToTests;

    private final Testable testable;

    public TestRunner(String pathToTests, Testable testable) {
        this.pathToTests = pathToTests;
        this.testable = testable;
    }

    public void runTests(){
        int nr = 0;
        int failed= 0;
        int passed = 0;
        int error = 0;
        while(true){
            FileSystem fileSystem = FileSystems.getDefault();
            Path inFileName = fileSystem.getPath(pathToTests, String.format("test.%d.in", nr));
            Path outFileName = fileSystem.getPath(pathToTests, String.format("test.%d.out", nr));

            if (Files.notExists(inFileName) || Files.notExists(outFileName)) {
                System.out.printf("All %d tests finished: passed: %d, FAILED: %d, ERROR: %d%n", nr, passed, failed, error);
                return;
            }

            TestResult testResult = runTest(inFileName, outFileName);
            switch (testResult) {
                case Passed -> passed++;
                case Failed -> failed++;
                case Error -> error++;
            }

            System.out.println("Test "+nr+" : " + testResult.name());
            nr++;
        }
    }

    private TestResult runTest(Path inFile, Path outFile){
        try {
            List<String> inStrings = Files.readAllLines(inFile);
            List<String> expected = Files.readAllLines(outFile);

            List<String> actual = testable.runTest(inStrings);

            return Objects.equals(expected, actual)? TestResult.Passed : TestResult.Failed;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return TestResult.Error;
        }
    }

}
