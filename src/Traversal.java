import java.util.HashMap;
import java.util.Map;

public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(10, null, null);
    root.left = new TreeNode<>(9, null, null);
    root.left.left = new TreeNode<>(5, null, null);
    root.left.right = new TreeNode<>(2, null, null);

    root.right = new TreeNode<>(15, null, null);
    root.right.left = new TreeNode<>(-3, null, null);
    root.right.right = new TreeNode<>(5, null, null);
    root.right.right.right = new TreeNode<>(22, null, null);

    TreeNode<String> stringRoot = new TreeNode<>("hello", null, null);
    stringRoot.left = new TreeNode<>("how", null, null);
    stringRoot.left.left = new TreeNode<>("are", null, null);
    stringRoot.left.right = new TreeNode<>("you", null, null);
    stringRoot.right = new TreeNode<>("hello", null, null);
    stringRoot.right.left = new TreeNode<>("I'm", null, null);
    stringRoot.right.right = new TreeNode<>("good", null, null);



    // postorder(root);
    // printGreater(root, 4);
    // System.out.println(countNodes(root));
    System.out.println(toMap(stringRoot));
  }

  public static int countNodes(TreeNode<?> node) {
    if (node == null) return 0;
    return 1 + countNodes(node.left) + countNodes(node.right);
  }

  public static void printGreater(TreeNode<Integer> node, int threshold) {
    if (node == null) return;
    if (node.value > threshold) System.out.println(node.value);
    printGreater(node.left, threshold);
    printGreater(node.right, threshold);
  }

  private static <T> void toMap(TreeNode<T> node, Map<T, Integer> counts) {
    if (node == null) {
      return;
    }
    // fill up those counts
    counts.put(node.value, counts.getOrDefault(node.value, 0) + 1);
    toMap(node.left, counts);
    toMap(node.right, counts);
  }

  public static <T> Map<T, Integer> toMap(TreeNode<T> node) {
    Map<T, Integer> counts = new HashMap<>();
    toMap(node, counts);
    return counts;
  }

  // print a tree rooted at the given node in pre-order
  public static void preorder(TreeNode<?> node) {
    if (node == null) return;
    System.out.println(node.value);
    preorder(node.left);
    preorder(node.right);
  }

  // print a tree rooted at the given node in-order
  public static void inorder(TreeNode<?> node) {
    if (node == null) return;
    inorder(node.left);
    System.out.println(node.value);
    inorder(node.right);
  }

  // print a tree rooted at the given node in post-order
  public static <T> void postorder(TreeNode<T> node) {
    if (node == null) return;
    postorder(node.left);
    postorder(node.right);
    System.out.println(node.value);
  }
}
