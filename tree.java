import java.util.LinkedList;
import java.util.ArrayList;
class tree{

    public static void main(String args[]){
      solve();

    }

    public static void solve(){
        int arr[]={10,20,40,-1,-1,50,80,-1,-1,-1,30,60,-1,-1,70,110,-1,-1,-1};
         Node root=constructTree(arr);
        //display(root);
       
        //System.out.println("POSTORDER:");
        //post(root);

         //rootToNodePath(root,80);

        levelorder02(root);
        //frontview(root);
        verticalorder (root);
        bottomview(root);

        //deepestNode(root,null);
       // System.out.println(roottonodepath02(root,80));
       

    }

///////////////BASIC CONSTRUCTION OF TREE///////////////////////////
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

   public static void display(Node node){
       if(node==null) return;

       String str="";
       str += ((node.left!=null)?node.left.data:".");
       str+=  " <- " + node.data + " -> ";
       str += ((node.right!=null)?node.right.data:".");
       System.out.println(str);
    
       display(node.left);
       display(node.right);

   }
/////////////BASIC FUNCTIONS /////////////////////////////////////////

public static int size(Node node){
    if(node==null){
        return 0;
    }
    return(size(node.left)+size(node.right)+1);
}


public static int height(Node node){
    if(node==null){
        return -1;
    }
    return(Math.max(height(node.left),height(node.right))+1);
}

public static boolean find(Node node, int q){
    if(node==null){
        return false;
    }
   if(node.data==q){
       return true ;
   }
   return find(node.left,q) || find(node.right,q);
   
   
}

public static int Max(Node node){
  
    if(node==null){
        return  Integer.MIN_VALUE;
    }

    return Math.max( Math.max(Max(node.left) , Max(node.right)),node.data);
  
}

static Node prev=null;
public static void deepestNode(Node root){
    if(root==null){
         System.out.println(prev.data);


    }
    if(root!=null){
        prev=root;
        
    }
     deepestNode(root.left);
     deepestNode(root.right);
   

}


///////////TRAVERSAL//////////////////////////////////////

 public static void pre(Node node){
         if(node==null) return;

         System.out.print(node.data+ " ");
         pre(node.left);
         pre(node.right);
    }

    
    public static void in(Node node){
        if(node==null) return;

        in(node.left);
        System.out.print(node.data+ " ");
        in(node.right);
   }

   public static void post(Node node){
    if(node==null) return;

    post(node.left);
    post(node.right);
    System.out.print(node.data+ " ");
   
    }
    /////////////////// ROOT TO NODE PATH//////////////////

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



         public static void rootToNodePath(Node root,int data){
             ArrayList<Node> path=new ArrayList<>();
             rootToNodePath_(root,data,path);
             for(Node n:path){
                 System.out.print( n.data + "->");
             }
         }



        public static ArrayList<Node> roottonodepath02(Node root,int data){
            if(root==null){
                return new ArrayList<>();
            }
            if(root.data==data){
                ArrayList<Node> base=new ArrayList<>();
                base.add(root);
                return base;
            }
            ArrayList<Node> left =roottonodepath02( root.left, data);
            if(left.size()!=0){
                left.add(root);
                return left;
            }
            
            ArrayList<Node> right =roottonodepath02( root.right, data);
            if(right.size()!=0){
                right.add(root);
                return right;
            }
            return new ArrayList<>();
        }

        ////////////////////////////Levelorder//////////////////////
        public static void levelorder00(Node root){

        LinkedList<Node> pque=new LinkedList<>();
        LinkedList<Node> cque=new LinkedList<>();
        int count=0;
        pque.addLast(root);
        System.out.print(" level order: "+ count +" -> ");
        while(pque.size()!=0){
            Node rnode=pque.removeFirst();
            System.out.print(rnode.data+" ");
            if(rnode.left!=null){
                cque.addLast(rnode.left);
            }
            if(rnode.right!=null){
                cque.addLast(rnode.right);
            }
            if(pque.size()==0){
                LinkedList<Node> temp=pque;
                pque=cque;
                cque=temp;
                count++;
        System.out.print("\nlevel order: " + count + " -> ");
                
            }
            

        }
        }
        public static void levelorder01(Node root){
            LinkedList<Node> que=new LinkedList<>();
            int count=0;
            que.addLast(root);
            que.addLast(null);
            System.out.print(" level order: "+ count +" -> ");
            while(que.size()!=1){
            Node rnode=que.removeFirst();
            System.out.print(rnode.data+" ");
            if(root.left!=null){
                que.addLast(rnode.left);
               
            }
            if(root.right!=null){
                que.addLast(rnode.right);
            }
            if(que.getFirst()==null){
                que.removeFirst();
                que.addLast(null);
                count++;
        System.out.print("\nlevel order: " + count + " -> ");


            }


            }
        }

        public static void levelorder02(Node root){
            LinkedList<Node> pque= new LinkedList<>();
            pque.addFirst(root);
            int count=0;
            while(pque.size()!=0){
                System.out.print("Level: " + count + " -> ");
                count++;
                
                int size=pque.size();
                
                while(size-->0){
                     Node rnode=pque.removeFirst();
                    System.out.print(rnode.data+ " ");
                     if(rnode.left!=null){
                         pque.addLast(rnode.left);
                     }
                     if(rnode.right!=null){
                         pque.addLast(rnode.right);

                     }
                }
                System.out.println();


            }

        }
        //View///////////////////////////////////////////
         public static void leftview(Node root){
            LinkedList<Node> pque= new LinkedList<>();
            pque.addFirst(root);
            while(pque.size()!=0){
                int size=pque.size();
                  System.out.print(pque.getFirst().data + " ");
                
                while(size-->0){
                     Node rnode=pque.removeFirst();
                     if(rnode.left!=null){
                         pque.addLast(rnode.left);
                     }
                     if(rnode.right!=null){
                         pque.addLast(rnode.right);

                     }
                }
                System.out.println();


            }
         }

         public static void rightview(Node root){
             LinkedList<Node> que=new LinkedList<>();
             que.addLast(root);
             while(que.size()!=0){
                 int size=que.size();
                Node prev=null;
                 while(size-->0){
                     Node rnode=que.removeFirst();
                     if(rnode.left!=null){
                         que.addLast(rnode.left);
                     }
                     if(rnode.right!=null){
                         que.addLast(rnode.right);

                     }
                     prev=rnode;
                 }
                 System.out.println(prev.data+" ");
             }
         }

        //Vertical view
        static int minleftval=0;
        static int maxrightval=0;

        public static void width(Node root,int lev){
            if(root==null){
                return;
            }
            minleftval=Math.min(minleftval,lev);
            maxrightval=Math.max(maxrightval,lev);
            width(root.left,lev-1);
            width(root.right,lev+1);
        }

        public static class vopair{
            int val=0;
            Node root;
            vopair(Node root,int val){
                this.val=val;
                this.root=root;
            }

        }

        public static void verticalorder(Node root){
            width(root,0);
            ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
            int n=maxrightval-minleftval+1;
            for(int i=0;i<n;i++){
                ans.add(new ArrayList<>());
            }
            LinkedList<vopair> que=new LinkedList<>();
            que.addLast(new vopair(root,-minleftval));
              while(que.size()!=0){
                 int size=que.size();
                 while(size-->0){
                     vopair rpair=que.removeFirst();
                     ans.get(rpair.val).add(rpair.root.data);
                     if(rpair.root.left!=null){
                         que.addLast(new vopair(rpair.root.left,rpair.val-1));
                     }
                     if(rpair.root.right!=null){
                         que.addLast(new vopair(rpair.root.right,rpair.val+1));
                        }
                   
                 }
                 
             }
             for(ArrayList<Integer> arr:ans){
                 System.out.println(arr);
             
             }
            

        }

    public static void bottomview(Node root){
        width(root,0);
        int ans[]=new int[maxrightval-minleftval+1];
        LinkedList<vopair> que=new LinkedList<>();
        que.addLast(new vopair(root,-minleftval));
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                vopair rpair=que.removeFirst();
                ans[rpair.val]=rpair.root.data;
                if(rpair.root.left!=null){
                    que.addLast(new vopair(rpair.root.left,rpair.val-1));
                }
                if(rpair.root.right!=null){
                    que.addLast(new vopair(rpair.root.right,rpair.val+1));
                }
            }
        }
        for(int ele:ans){
            System.out.println(ele);
        }


    }



     
     
     
     }



    






