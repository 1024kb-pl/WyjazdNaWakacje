package graph;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private final int name;
    private Map<Node, Float> adjacentNodes = new HashMap<>();
    private Float distance = Float.MAX_VALUE;


    public Node(int name) {
        this.name = name;
    }

    public void addAdjacentNode(Node node, Float weight) {
        adjacentNodes.put(node, weight);
    }

    public int getName() {
        return name;
    }

    public Map<Node, Float> getAdjacentNodes() {
        return adjacentNodes;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getName() == node.getName();
    }

    @Override
    public int hashCode() {
        return getName();
    }
}
