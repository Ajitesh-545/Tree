import java.util.ArrayList;
import java.util.LinkedList;
class pathsum{
    public static void main(String args[]){
int arr[]={10,20,40,-1,-1,50,80,-1,-1,-1,30,60,-1,-1,70,110,-1,-1,-1};
         Node root=constructTree(arr);
        System.out.println(maxPathSum(root));
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
    public static Node constructTree(int[] arr){
      if(idx == arr.length || arr[idx]==-1) {
            idx++;
        return null;
      }


      Node node=new Node(arr[idx++]);   
      node.left=constructTree(arr);
      node.right=constructTree(arr);
      
      return node;
   }

    /*public static boolean sum(Node root,int k){
        if(root==null){
            return false;
        }
        if( k-root.data==0 && root.left==null && root.right){
            return true;
        }
        boolean res=false;
        res=res||sum(root.left,k-root.data);
        res=res||sum(root.right,k-root.data);
        return res;
    }
//////////ROOT TO LEAF WITH NO CHILD////////////////
    public static void sum2(Node root,int k,List<List<Integer>> res,List<Integer> ans){

        if(root==null){
     return;

        }
        if(root.left==null && root.right==null && sum-root.data==0){
            List<Integer> base=new ArrayList<>(ans);
            base.add(root.data);
            res.add(base);
            return;
        }
        ans.add(root.data);
        sum2(root.left,k-root.data,res,ans);
        sum2(root.right,k-root.data,res,ans);
        ans.remove(ans.size()-1);

    }
    public static List<List<Integer>>  sum2(Node root,int k){
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        sum2(root,k,res,ans);
        return res;


    }*/


    //////////////////MAX PATHSUM TO LEAVES///////////
      static int max_leafToLeafSum;

    public static int maxPathSum(Node root) {
     
        max_leafToLeafSum=Integer.MIN_VALUE;
         leafToLeaf(root);
        return max_leafToLeafSum;
        
    }
     
   
   public static int leafToLeaf(Node node){
       if(node==null) return 0;

       int leftNodeToLeafSum = leafToLeaf(node.left);
       int rightNodeToLeafSum = leafToLeaf(node.right);

       if(node.left!=null && node.right!=null){
           max_leafToLeafSum=Math.max(max_leafToLeafSum,leftNodeToLeafSum + rightNodeToLeafSum + node.data);
           return Math.max(leftNodeToLeafSum , rightNodeToLeafSum) + node.data;
       }

       return (node.left==null? rightNodeToLeafSum: leftNodeToLeafSum) + node.data;
   }




///////////////////////////Leetcode all node to node///////////////
static int maxnodetonode;
public static int maxsum(Node root){
 maxnodetonode=Integer.MIN_VALUE;
 nodetonode(root);
 return maxnodetonode;
 

}
 public static int nodetonode(Node root){
     if(root==null){
         return 0;
     }
     int leftmaxsum=nodetonode(root.left);
     int rightmaxsum=nodetonode(root.right);
     int max_=Math.max(leftmaxsum,rightmaxsum)+root.data;
    maxnodetonode=Math.max(Math.max(maxnodetonode,root.data),Math.max(leftmaxsum+rightmaxsum+root.data,max_));
    return Math.max(max_,root.data);

 }
 
   

}
