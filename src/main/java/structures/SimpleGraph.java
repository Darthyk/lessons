package structures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

public class SimpleGraph
{
    Vertex [] vertex;
    int [][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size)
    {
        max_vertex = size;
        m_adjacency = new int [size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value)
    {
        // ваш код добавления новой вершины
        // с значением value
        // в незанятую позицию vertex
        int index = getFreeVertexIndex();
        if (index >= 0) {
            vertex[index] = new Vertex(value);
        }
    }

    // здесь и далее, параметры v -- индекс вершины
    // в списке  vertex
    public void RemoveVertex(int v)
    {
        // ваш код удаления вершины со всеми её рёбрами
        if (isIndexCorrect(v)) {
            vertex[v] = null;
            for (int i = 0; i < max_vertex; i++) {
                RemoveEdge(v, i);
            }
        }
    }

    public boolean IsEdge(int v1, int v2)
    {
        // true если есть ребро между вершинами v1 и v2
        if (isIndexCorrect(v1) && isIndexCorrect(v2)) {
            return m_adjacency[v1][v2] == 1 && m_adjacency[v2][v1] == 1;
        }
        return false;
    }

    public void AddEdge(int v1, int v2)
    {
        // добавление ребра между вершинами v1 и v2
        if (isIndexCorrect(v1) && isIndexCorrect(v2)) {
            m_adjacency[v1][v2] = 1;
            m_adjacency[v2][v1] = 1;
        }
    }

    public void RemoveEdge(int v1, int v2)
    {
        // удаление ребра между вершинами v1 и v2
        if (isIndexCorrect(v1) && isIndexCorrect(v2)) {
            m_adjacency[v1][v2] = 0;
            m_adjacency[v2][v1] = 0;
        }
    }

    private int getFreeVertexIndex() {
        for (int i = 0; i < max_vertex; i++) {
            if (vertex[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private boolean isIndexCorrect(int index) {
        return index >= 0 && index < max_vertex;
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo)
    {
        // Узлы задаются позициями в списке vertex.
        // Возвращается список узлов -- путь из VFrom в VTo.
        // Список пустой, если пути нету.
        for (int i = 0; i < vertex.length; i++) {
            vertex[i].Hit = false;
        }
        ArrayDeque<Integer> hittedVertices = new ArrayDeque<>();

        vertex[VFrom].Hit = true;
        hittedVertices.push(VFrom);
        int currentIndex = VFrom;

        for (int i = 0; i < vertex.length; i++) {
            if (m_adjacency[currentIndex][VTo] == 1) {
                hittedVertices.push(VTo);
                break;
            }
            boolean shouldGoNext = false;
            for (int j = 0; j < max_vertex; j++) {
                if (m_adjacency[currentIndex][j] == 1 && !vertex[j].Hit) {
                    vertex[j].Hit = true;
                    hittedVertices.push(j);
                    currentIndex = j;
                    shouldGoNext = true;
                    break;
                }
            }
            if (!shouldGoNext) {
                hittedVertices.pop();
                if (hittedVertices.isEmpty()) {
                    return new ArrayList<>();
                }
                currentIndex = hittedVertices.peek();
            }
        }

        ArrayList<Vertex> path = new ArrayList<>();
        while (!hittedVertices.isEmpty()) {
            path.add(vertex[hittedVertices.pollLast()]);
        }

        return path;
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
        // Узлы задаются позициями в списке vertex.
        // Возвращается список узлов -- путь из VFrom в VTo.
        // Список пустой, если пути нету.
        ArrayList<Vertex> vertices = new ArrayList<>();

        for (int i = 0; i < max_vertex; i++) vertex[i].Hit = false;
        int[] prevVertices = new int[max_vertex];
        Arrays.fill(prevVertices, -1);
        ArrayDeque<Integer> verticesHit = new ArrayDeque<>();
        vertex[VFrom].Hit = true;
        verticesHit.offer(VFrom);
        BFS:
        while (!verticesHit.isEmpty()) {
            int currentVertex = verticesHit.poll();
            for (int i = 0; i < max_vertex; i++) {
                if (m_adjacency[currentVertex][i] == 1 && !vertex[i].Hit) {
                    verticesHit.offer(i);
                    vertex[i].Hit = true;
                    prevVertices[i] = currentVertex;
                    if (i == VTo) break BFS;
                }
            }
        }
        return tracePath(prevVertices, vertices, VTo);
    }

    private ArrayList<Vertex> tracePath(int[] prevVertices, ArrayList<Vertex> vertices, int vertexTo) {
        if (prevVertices[vertexTo] == -1) return vertices;
        int currentVertex = vertexTo;
        while (currentVertex != -1) {
            vertices.add(vertex[currentVertex]);
            currentVertex = prevVertices[currentVertex];
        }
        Collections.reverse(vertices);
        return vertices;
    }

    public ArrayList<Vertex> WeakVertices()
    {
        // возвращает список узлов вне треугольников
        ArrayList<Vertex> weakVertices = new ArrayList<>();
        for (int i = 0; i < max_vertex; i++) {
            if (!isInTriangle(i)) {
                weakVertices.add(vertex[i]);
            }
        }
        return weakVertices;
    }

    private boolean isInTriangle(int index) {
        for (int i = 0; i < max_vertex; i++) {
            if (m_adjacency[index][i] == 1 && index != i) {
                for (int j = 0; j < max_vertex; j++) {
                    if (m_adjacency[i][j] == 1 && m_adjacency[index][j] == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Vertex
{
    public boolean Hit;
    public int Value;
    public Vertex(int val)
    {
        Value = val;
    }
}
