import graph.Graph;
import graph.GraphLoader;
import shortestPath.ShortestPathManager;

public class HolidayManager {
    private final ShortestPathManager shortestPathManager;
    private final GraphLoader graphLoader;

    // Dependency Injection is cool => https://1024kb.pl/programowanie/java/dependency-injection/
    public HolidayManager(ShortestPathManager shortestPathManager, GraphLoader graphLoader) {
        this.shortestPathManager = shortestPathManager;
        this.graphLoader = graphLoader;
    }

    public int getShortestPath(String fileName, int source, int destination) {
        Graph graph = graphLoader.loadGraphByFileName(fileName);
        return shortestPathManager.getShortestPath(graph, source, destination);
    }
}
