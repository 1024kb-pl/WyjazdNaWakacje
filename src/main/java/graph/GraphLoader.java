package graph;

import exception.GraphLoadException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphLoader {
    public Graph loadGraphByFileName(String fileName) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String readLine = br.readLine();
            Set<Node> nodes = new HashSet<>();

            int nodeName = 0;
            while (readLine != null) {
                List<Float> weights = getWeightsFromStringLine(readLine);
                Node node = createNodeByHisWeights(nodeName, weights);

                nodes.add(node);
                nodeName += 1;

                readLine = br.readLine();
            }

            return new Graph(nodes);

        } catch (IOException e) {
            e.printStackTrace();
            throw new GraphLoadException();
        }

    }

    private Node createNodeByHisWeights(int nodeName, List<Float> weights) {
        Node node = new Node(nodeName);

        int adjacentNodeName = 0;

        for (Float weight : weights) {
            Node adjacentNode = new Node(adjacentNodeName);
            node.addAdjacentNode(adjacentNode, weight);

            adjacentNodeName += 1;
        }

        return node;
    }

    private List<Float> getWeightsFromStringLine(String line) {

        return Arrays.stream(line.split(" "))
                .map(Float::valueOf)
                .collect(Collectors.toList());
    }
}
