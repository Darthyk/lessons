package structures;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @Test
    public void testBreadthFirstSearch() {
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
        List<Vertex> actual = graph.BreadthFirstSearch(0, 4);
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));

        actual = graph.BreadthFirstSearch(4, 0);
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));


        graph = new SimpleGraph(9);
        graph.AddVertex(0);
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddVertex(3);
        graph.AddVertex(4);
        graph.AddVertex(5);
        graph.AddVertex(6);
        graph.AddVertex(7);
        graph.AddVertex(8);

        graph.AddEdge(0, 1);
        graph.AddEdge(0, 2);
        graph.AddEdge(0, 4);
        graph.AddEdge(1, 2);
        graph.AddEdge(2, 3);
        graph.AddEdge(4, 5);
        graph.AddEdge(5, 6);
        graph.AddEdge(5, 7);
        graph.AddEdge(7, 8);

        expected = new ArrayList<>();
        expected.add(graph.vertex[0]);
        expected.add(graph.vertex[4]);
        expected.add(graph.vertex[5]);
        expected.add(graph.vertex[7]);
        expected.add(graph.vertex[8]);
        actual = graph.BreadthFirstSearch(0, 8);
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));

        graph.RemoveEdge(7, 8);
        actual = graph.BreadthFirstSearch(0, 8);
        assertTrue(actual.isEmpty());
    }

    @Test
    public void testWeakVertices() {
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

        assertTrue(graph.WeakVertices().isEmpty());

        graph.RemoveEdge(3, 4);
        List<Vertex> actual = graph.WeakVertices();
        assertFalse(actual.isEmpty());
        assertEquals(5, actual.get(0).Value);
    }
}
