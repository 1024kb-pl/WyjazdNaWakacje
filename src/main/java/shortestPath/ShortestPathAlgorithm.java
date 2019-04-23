package shortestPath;

import exception.PathNotExistException;
import graph.Graph;

// You can choose any algorithm, I suggested to use Dijkstra
public interface ShortestPathAlgorithm {
    /**
        Method calculates the shortest in the graph from source to destination

        @param source - name of source vertex
        @param destination - name of destination vertex
        @throws PathNotExistException - when path from source to destination no exists
        @return The shortest path
     */
    int getShortestPath(Graph graph, int source, int destination);
}
