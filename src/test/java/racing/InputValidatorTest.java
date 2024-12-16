package racing;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;

public class InputValidatorTest {

    @Test
    void testValidateCarNamesWithValidInput() {
        assertDoesNotThrow(() -> InputValidator.validateCarNames(Arrays.asList("Car1", "Car2", "Car3")));
    }

    @Test
    void testValidateCarNamesWithEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(Collections.emptyList()));
    }

    @Test
    void testValidateCarNamesWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(Arrays.asList("Car1", "", "Car3")));
    }

    @Test
    void testValidateCarNamesWithLongName() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateCarNames(Arrays.asList("Car1", "VeryLongCarName", "Car3")));
    }

    @Test
    void testValidateRoundsWithValidInput() {
        assertDoesNotThrow(() -> InputValidator.validateRounds(5));
    }

    @Test
    void testValidateRoundsWithZero() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateRounds(0));
    }

    @Test
    void testValidateRoundsWithNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateRounds(-1));
    }
}

