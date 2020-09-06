import java.util.*;

public final class TreeDepth {

  /*
       4
      / \
     7  9
    / \   \
   10 2    6
           /
          2
  */

  static class Node {
    final int value;
    Node left;
    Node right;
    Node(int v, Node l, Node r) {
      value = v;
      left = l;
      right = r;
    }
  }

  public static int height(Node node) {
    if (node == null) {
      return 0;
    }
    int leftHeight = height(node.left);
    int rightHeight = height(node.right);
    return Math.max(1 + leftHeight, 1 + rightHeight);
  }

  public static void nodesAtHeight(Node node, int currentHeight, final int targetHeight, final List<Node> result) {
    if (node == null) {
      return;
    }
    if (currentHeight == targetHeight) {
      result.add(node);
    } else {
      nodesAtHeight(node.left, currentHeight+1, targetHeight, result);
      nodesAtHeight(node.right, currentHeight+1, targetHeight, result);
    }
  }

  public static void printNodes(List<Node> nodes) {
    System.out.print("[");
    for (int i=0; i < nodes.size(); i++) {
      System.out.print(nodes.get(i).value);
      if (i < nodes.size()-1) {
        System.out.print(", ");
      }
    }
    System.out.print("]");
  }

  public static void main(String[] args) {
    Node root = new Node(4,
      new Node(7,
          new Node(10, null, null),
          new Node(2, null,
                      new Node(6,
                               new Node(2, null, null) ,
                               null))),
      new Node(9, null, new Node(6, null, null)));
    //System.out.println("Tree Height: " + height(root));


    // print averages at each one of the tree dephs

    int maxHeight = height(root);
    System.out.print("[");
    for (int height=0; height < maxHeight; height++) {
      ArrayList<Node> nodesAtLevel = new ArrayList<>();
      nodesAtHeight(root, 0, height, nodesAtLevel);
      int sum = 0;
      //printNodes(nodesAtLevel);
      for (int i=0; i < nodesAtLevel.size(); i++) {
        sum += nodesAtLevel.get(i).value;
      }
      System.out.print(sum / nodesAtLevel.size());
      if (height < maxHeight - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }
}
