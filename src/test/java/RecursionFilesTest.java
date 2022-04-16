import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.junit.jupiter.api.Test;
import recursion.FindFiles;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionFilesTest {
    @Test
    public void testGetFiles() throws IOException {
        URL dir = this.getClass().getResource("C:\\Users\\vsazhin\\IdeaProjects\\lessons\\src\\test\\resources\\dir");
        List<String> files = FindFiles.getFiles("C:\\Users\\vsazhin\\IdeaProjects\\lessons\\src\\test\\resources\\dir");
        assertEquals(4, files.size());
    }
}
