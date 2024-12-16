package racing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class RacingGameTest {

    @Test
    void testPlay() {
        String input = "Car1,Car2,Car3\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        RacingGame game = new RacingGame();
        game.play();

        String output = outContent.toString();
        assertTrue(output.contains("레이스에 참가할 자동차들의 이름을 쉼표(,)로 구분하여 입력하세요."));
        assertTrue(output.contains("몇 회 시행할까요?"));
        assertTrue(output.contains("(1)"));
        assertTrue(output.contains("(2)"));
        assertTrue(output.contains("(3)"));
        assertTrue(output.contains("🏆우승자는"));

        System.setIn(System.in);
        System.setOut(System.out);
    }

}
