import exception.PathNotExistException;
import graph.Graph;
import graph.GraphLoader;
import org.junit.Assert;
import org.junit.Test;
import shortestPath.DijkstraAlgorithm;
import shortestPath.ShortestPathManager;

public class ShortestPathManagerTest {
    
    private ShortestPathManager shortestPathManager = new ShortestPathManager(new DijkstraAlgorithm());


    @Test
    public void testShortestPathOne() {
        Graph graph = new GraphLoader().loadGraphByFileName("src/test/resources/graph_one");

        int result = shortestPathManager.getShortestPath(graph, 2, 3);

        Assert.assertEquals(17, result);
    }

    @Test
    public void testShortestPathToTheSamePoint() {
        Graph graph = new GraphLoader().loadGraphByFileName("src/test/resources/graph_one");

        int result = shortestPathManager.getShortestPath(graph, 2, 2);

        Assert.assertEquals(0, result);
    }

    @Test(expected = PathNotExistException.class)
    public void testShortestPathWhenNoExists() {
        Graph graph = new GraphLoader().loadGraphByFileName("src/test/resources/graph_two");

        int result = shortestPathManager.getShortestPath(graph, 0, 5);
    }


    @Test(expected = PathNotExistException.class)
    public void testShortestPathWhenNoExistsTwo() {
        Graph graph = new GraphLoader().loadGraphByFileName("src/test/resources/graph_five");

        int result = shortestPathManager.getShortestPath(graph, 0, 2);
    }

    @Test
    public void testShortestPathTwo() {
        Graph graph = new GraphLoader().loadGraphByFileName("src/test/resources/graph_three");

        int result = shortestPathManager.getShortestPath(graph, 0, 6);

        Assert.assertEquals(21, result);
    }

    @Test
    public void testShortestPathFour() {
        Graph graph = new GraphLoader().loadGraphByFileName("src/test/resources/graph_three");

        int result = shortestPathManager.getShortestPath(graph, 0, 1);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testShortestPathThree() {
        Graph graph = new GraphLoader().loadGraphByFileName("src/test/resources/graph_four");

        int result = shortestPathManager.getShortestPath(graph, 0, 1);

        Assert.assertEquals(8, result);
    }

    @Test
    public void testShortestPathFive() {
        Graph graph = new GraphLoader().loadGraphByFileName("src/test/resources/graph_five");

        int result = shortestPathManager.getShortestPath(graph, 0, 1);

        Assert.assertEquals(1, result);
    }
}
