package structures;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleGraphTest {

    @Test
    public void testDepthFirstSearch() {
        SimpleGraph graph = new SimpleGraph(5);

        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);

        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 3);
        graph.AddEdge(1, 3);
        graph.AddEdge(1, 4);
        graph.AddEdge(2, 3);
        graph.AddEdge(3, 4);

        List<Vertex> expected = new ArrayList<>();
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[4]);
        List<Vertex> actual = graph.DepthFirstSearch(0, 4);
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));

        actual = graph.DepthFirstSearch(4, 0);
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));

        graph.RemoveEdge(0, 1);
        expected = new ArrayList<>();
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[2]);
        expected.add(graph.vertex[3]);
        expected.add(graph.vertex[4]);
        actual = graph.DepthFirstSearch(0, 4);
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));

        graph.RemoveEdge(3, 4);
        expected = new ArrayList<>();
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[2]);
        expected.add(graph.vertex[3]);
        expected.add(graph.vertex[1]);
        expected.add(graph.vertex[4]);
        actual = graph.DepthFirstSearch(0, 4);
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));

        graph.RemoveEdge(1, 4);
        actual = graph.DepthFirstSearch(0, 4);
        assertEquals(0, actual.size());
    }
}
