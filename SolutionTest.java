import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class SolutionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void out() throws FileNotFoundException {
        Solution sol = new Solution();
        System.setIn(new FileInputStream("src\\base\\input.txt"));
        sol.main(null);
        String s = System.lineSeparator();

        String expected = "Case #1: 6 5" +s+
                "Case #2: 5 -14" + s +
                "Case #3: 9001 0" + s +
                "Case #4: 2 1"+s;

        String[] expectedLines = expected.split(s);
        String[] gotLines = outContent.toString().split(s);
        for (int i = 0; i < expectedLines.length; i++) {
            assertEquals(expectedLines[i], gotLines[i]);
        }
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}
