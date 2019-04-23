package exception;

public class NodeNotFoundException extends RuntimeException {
    public NodeNotFoundException(int name) {
        super("graph.Node with name: " + name + " couldn't be found.");
    }
}
