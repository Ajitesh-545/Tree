
import java.util.LinkedList;
class Diameter{

public static void main(String args[]){
 int arr[]={10,20,40,-1,-1,50,-1,-1,30,60,80,90,-1,-1,-1,-1,70,-1,-1};
        Node root=constructtree(arr);
        System.out.println(height(root));
        System.out.println(diameter(root));

}

public static class Node{
    Node left=null;
    Node right=null;
    int data;
    Node(int data){
        this.data=data;
    }
}
static int idx=0;
public static Node constructtree(int arr[]){
  
    if(idx==arr.length || arr[idx]==-1){
        idx++;
        return null;
    }
    Node root=new Node(arr[idx++]);
    root.left=constructtree(arr);
    root.right=constructtree(arr);
    return root;
}
public static int height(Node node){
    if(node==null){
        return -1;
    }
    return(Math.max(height(node.left),height(node.right))+1);
}
public static int diameter(Node root){
    if(root==null){
        return 0;
    }
    int ld=diameter(root.left);
    int rd=diameter(root.right);

    int count=height(root.left)+height(root.right)+2;
    return  Math.max(Math.max(ld,rd),count);
    

}





}