import java.util.LinkedList;
import java.util.ArrayList;

class knode{
    public static void main(String args[]){
       int arr[]={10,20,40,-1,-1,50,-1,-1,30,60,80,90,-1,-1,-1,-1,70,-1,-1};
        Node root=constructtree(arr);
      AllNodeAtk(root,30,3);
    

    }
     



public static class Node{
    int data;
    Node left=null;
    Node right=null;
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
 public static void pre(Node node){
         if(node==null) return;

         System.out.print(node.data+ " ");
         pre(node.left);
         pre(node.right);
    }
     public static boolean rootToNodePath_(Node root,int data,ArrayList<Node> path){
         if(root==null){
             return false;
         }
         if(root.data==data){
             path.add(root);
             return true;
         }


         boolean result=rootToNodePath_( root.left, data, path) || rootToNodePath_( root.right, data, path);
         if(result){
             path.add(root);
             
         }
         return result;
     }


public static void kdown(Node root,int level,Node blocked){

    if(root==null || root==blocked){
     
        return;
    }
    if(level==0){
        
        System.out.println(root.data);
        return;
    }

kdown( root.left, level-1,blocked);
kdown( root.right, level-1,blocked);
}


public static void AllNodeAtk(Node root,int target,int k){
    ArrayList<Node> path=new ArrayList<>();
    rootToNodePath_(root,target,path);
    Node prev=null;
    for(int i=0;i<path.size();i++){
        if(k-i<0){
        return;
        }
        kdown(path.get(i),k-i,prev);
        prev=path.get(i);
        

        }

    }


}


