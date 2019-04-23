import graph.Graph;
import graph.GraphLoader;
import graph.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GraphLoaderTest {
    
    private GraphLoader graphLoader = new GraphLoader();


    @Test
    public void testLoadFirstGraph() {
        Graph expectedGraph = createFirstGraph();

        Graph graph = graphLoader.loadGraphByFileName("src/test/resources/graph_one");

        Assert.assertEquals(expectedGraph, graph);
    }

    @Test
    public void testLoadTwoGraph() {
        Graph expectedGraph = createTwoGraph();

        Graph graph = graphLoader.loadGraphByFileName("src/test/resources/graph_four");

        Assert.assertEquals(expectedGraph, graph);
    }

    private Graph createTwoGraph() {
        Node node0 = new Node(0);
        Node node1 = new Node(1);

        node0.addAdjacentNode(node0, 10.0f);
        node0.addAdjacentNode(node1, 8.0f);

        node1.addAdjacentNode(node0, -1.0f);
        node1.addAdjacentNode(node1, -1.0f);

        Set<Node> nodes = new HashSet<>(Arrays.asList(node0, node1));

        return new Graph(nodes);
    }


    private Graph createFirstGraph() {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node0.addAdjacentNode(node0, -1.0f);
        node0.addAdjacentNode(node1, 3.0f);
        node0.addAdjacentNode(node2, -1.0f);
        node0.addAdjacentNode(node3, 11.0f);
        node0.addAdjacentNode(node4, 5.0f);

        node1.addAdjacentNode(node0, -1.0f);
        node1.addAdjacentNode(node1, -1.0f);
        node1.addAdjacentNode(node2, 5.0f);
        node1.addAdjacentNode(node3, -1.0f);
        node1.addAdjacentNode(node4, -1.0f);


        node2.addAdjacentNode(node0, -1.0f);
        node2.addAdjacentNode(node1, 5.0f);
        node2.addAdjacentNode(node2, -1.0f);
        node2.addAdjacentNode(node3, -1.0f);
        node2.addAdjacentNode(node4, 1.0f);

        node3.addAdjacentNode(node0, 11.0f);
        node3.addAdjacentNode(node1, -1.0f);
        node3.addAdjacentNode(node2, -1.0f);
        node3.addAdjacentNode(node3, -1.0f);
        node3.addAdjacentNode(node4, -1.0f);

        node4.addAdjacentNode(node0, 5.0f);
        node4.addAdjacentNode(node1, -1.0f);
        node4.addAdjacentNode(node2, 1.0f);
        node4.addAdjacentNode(node3, -1.0f);
        node4.addAdjacentNode(node4, -1.0f);


        Set<Node> nodes = new HashSet<>(Arrays.asList(node0, node1, node2, node3, node4));

        return new Graph(nodes);
    }
}
