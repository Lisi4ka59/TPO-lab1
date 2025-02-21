import com.lisi4ka.part3.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DomainModelTest {

    @Test
    void testUniversity() {
        University university = new University("Круксванский университет");
        assertEquals("Круксванский университет", university.getName());
    }

    @Test
    void testClothing() {
        Clothing clothing = new Clothing("синий", "балахон");
        assertEquals("синий", clothing.getColor());
        assertEquals("балахон", clothing.getType());
    }

    @Test
    void testProfessor() {
        University university = new University("Круксванский университет");
        Clothing clothing = new Clothing("выцветший синий", "балахон");
        Professor professor = new Professor("Иван", clothing, 5, university);

        assertEquals("Иван", professor.getName());
        assertEquals(clothing, professor.getClothing());
        assertEquals(university, professor.getUniversity());
        assertEquals(5, professor.getLevel());
    }

    @Test
    void testServant() {
        Clothing clothing = new Clothing("черный", "костюм");
        Servant servant = new Servant("Петр", clothing, 3);

        assertEquals("Петр", servant.getName());
        assertEquals(clothing, servant.getClothing());
        assertEquals(3, servant.getLevel());
    }

    @Test
    void testDoor() {
        Door door = new Door();
        assertFalse(door.isOpen());
        door.open();
        assertTrue(door.isOpen());
    }

    @Test
    void testRoom() {
        Room room = new Room("Зал заседаний");
        assertEquals("Зал заседаний", room.getName());
    }

    @Test
    void testBurstIntoSuccess() {
        University university = new University("Круксванский университет");
        Clothing professorClothing = new Clothing("выцветший синий", "балахон");
        Clothing servantClothing = new Clothing("черный", "костюм");

        Professor professor = new Professor("Философ", professorClothing, 5, university);
        Servant servant = new Servant("Лакей", servantClothing, 3);
        Room room = new Room("Комната заседаний");

        // Перехватываем вывод в консоль
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        professor.burstInto(room, servant);

        String expectedOutput = """
                Философ пытается ворваться в Комната заседаний!
                Философ ворвался в Комната заседаний, растолкав Лакей!
                """;

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testTryToStopFailure() {
        University university = new University("Круксванский университет");
        Clothing professorClothing = new Clothing("выцветший синий", "балахон");
        Clothing servantClothing = new Clothing("черный", "костюм");

        Professor professor = new Professor("Философ", professorClothing, 5, university);
        Servant servant = new Servant("Лакей", servantClothing, 3);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        servant.tryToStop(professor);

        String expectedOutput = """
                Лакей пытается остановить Философ!
                Лакей не смог остановить Философ!
                """;

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testTryToStopSuccess() {
        University university = new University("Круксванский университет");
        Clothing professorClothing = new Clothing("выцветший синий", "балахон");
        Clothing servantClothing = new Clothing("черный", "костюм");

        Professor professor = new Professor("Философ", professorClothing, 5, university);
        Servant servant = new Servant("Лакей", servantClothing, 5);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        servant.tryToStop(professor);

        String expectedOutput = """
                Лакей пытается остановить Философ!
                Лакей успешно остановил Философ!
                """;

        assertEquals(expectedOutput, outContent.toString());
    }
}
