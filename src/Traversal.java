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


    // postorder(root);
    // printGreater(root, 4);
    System.out.println(countNodes(root));
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
