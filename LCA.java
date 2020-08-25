import java.util.ArrayList;
import java.util.LinkedList;


class LCA{
    public static void main(String args[]){
      solve();

    }

    public static void solve(){
        int arr[]={10,20,40,-1,-1,50,-1,-1,30,60,80,90,-1,-1,-1,-1,70,-1,-1};
         Node root=constructTree(arr);
     
       System.out.println(lowestcommonancestor(root,60,70));
       lca1(root,40,30);
      System.out.println(LCAnode. data);
       

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



   public static boolean rootToNodePath_(Node root, int data,ArrayList<Node> path){
       if(root==null){
           return false;
       }
       if(root.data==data){
           path.add(root);
           return true;
       }
       boolean res=rootToNodePath_(root.left, data, path) || rootToNodePath_(root.right, data, path);
       if(res){
           path.add(root);
         
       }
       return res;
   }

   public static void rootToNodePath(Node root, int data){
       ArrayList<Node> path =new ArrayList<>();
       rootToNodePath_(root,data,path);
       for(Node n:path){
           System.out.println( n.data+"_>"+" ");
       }

   }


   public static int lowestcommonancestor(Node root,int data1, int data2){
         ArrayList<Node> path1=new ArrayList<>();
         ArrayList<Node> path2=new ArrayList<>(); 
        rootToNodePath_(root,data1,path1 );
        rootToNodePath_(root,data2,path2);
        int i=path1.size()-1;
        int j=path2.size()-1;;
        Node prev=null;
        while(i>=0 && j>=0){
            if(path1.get(i).data!=path2.get(j).data){
                
                break;
            }
              prev=path1.get(i);
            i--;
            j--;

        }
        return prev.data;

   }    
   static Node LCAnode=null;
   
   public static boolean lca1(Node root,int q,int p){
       if(root==null){
           return false;
       }
       boolean selfdone=false;
       if(root.data==q || root.data==p){
          selfdone=true;
       }
       boolean left=lca1(root.left,q,p);
     
       boolean right=lca1(root.right,q,p);  
        
    if((left && right) || (left && selfdone) || (right && selfdone) ){
      LCAnode=root;
    }

    return right || left || selfdone;


    

       }


   
}