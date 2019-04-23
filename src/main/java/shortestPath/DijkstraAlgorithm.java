package shortestPath;

import exception.PathNotExistException;
import graph.Graph;
import graph.Node;

import java.util.*;

public class DijkstraAlgorithm implements ShortestPathAlgorithm {
    public int getShortestPath(Graph graph, int source, int destination) {
        Node sourceNode = graph.getNodeByName(source);
        sourceNode.setDistance(0f);

        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> nonVisitedNodes = new HashSet<>();

        nonVisitedNodes.add(sourceNode);

        while (!nonVisitedNodes.isEmpty()) {
            Node nodeWithMinDistance = getNodeWithMinDistance(nonVisitedNodes);
            Node currentNode = graph.getNodeByName(nodeWithMinDistance.getName());

            nonVisitedNodes.remove(currentNode);

            for (Map.Entry<Node, Float> entryNode : currentNode.getAdjacentNodes().entrySet()) {
                int nodeName = entryNode.getKey().getName();
                Node node = graph.getNodeByName(nodeName);
                Float weight = entryNode.getValue();

                if (!visitedNodes.contains(node) && weight != Graph.EDGE_NO_EXIST && currentNode.getDistance() + weight < node.getDistance()) {
                    node.setDistance(currentNode.getDistance() + weight);
                    nonVisitedNodes.add(node);
                }

            }

            visitedNodes.add(currentNode);
        }

        return getResult(visitedNodes, destination);
    }

    private Node getNodeWithMinDistance(Set<Node> nonVisitedNodes) {
        return nonVisitedNodes.stream()
                .min(Comparator.comparing(Node::getDistance))
                .orElseThrow(() -> new RuntimeException("There's no nodes in list."));
    }


    private int getResult(Set<Node> nonVisitedNodes, int expected) {
        return nonVisitedNodes.stream()
                .filter(node -> node.getName() == expected)
                .findFirst()
                .orElseThrow(PathNotExistException::new)
                .getDistance().intValue();
    }
}
