import java.util.Scanner;

public class Main {

    public static class Node {
        char data;
        Node left;
        Node right;

        Node(char data){
            this.data = data;
        }
    }

    static Node[] tree = new Node[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            char rootData = sc.next().charAt(0);
            char leftData = sc.next().charAt(0);
            char rightData = sc.next().charAt(0);

            // 1. 루트 노드가 생성되지 않았다면 생성
            if (tree[rootData - 'A'] == null) {
                tree[rootData - 'A'] = new Node(rootData);
            }

            // 2. 왼쪽 자식 연결
            if (leftData != '.') {
                tree[leftData - 'A'] = new Node(leftData);
                tree[rootData - 'A'].left = tree[leftData - 'A'];
            }

            // 3. 오른쪽 자식 연결
            if (rightData != '.') {
                tree[rightData - 'A'] = new Node(rightData);
                tree[rootData - 'A'].right = tree[rightData - 'A'];
            }
        }

        preorder(tree[0]);
        System.out.println();
        inorder(tree[0]);
        System.out.println();
        postorder(tree[0]);

    }

    static public void preorder(Node node){
        System.out.print(node.data);
        if(node.left != null)preorder(node.left);
        if(node.right != null)preorder(node.right);
    }
    static public void inorder(Node node){
        if(node.left != null)inorder(node.left);
        System.out.print(node.data);
        if(node.right != null)inorder(node.right);
    }

    static public void postorder(Node node){
        if(node.left != null)postorder(node.left);
        if(node.right != null)postorder(node.right);
        System.out.print(node.data);
    }

}
