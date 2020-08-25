#include <iostream>
#include <vector>

using namespace std;
class Node{
    public:
        int data=0;
        Node* left=nullptr;
        Node* right=nullptr;
        Node(int data){
            this->data=0;
        }
};

Node* constructBst(vector<int> &arr,int si, int ei){
    if(si>ei){
        return nullptr;
    }
    int mid=(si+ei)>>1;
    Node* node=new Node(arr[mid]);
    node->left=constructBst(arr,si,mid-1);
    node->right=constructBst(arr,mid+1,ei);
    return node;
}void display(Node* root){
        if(root == nullptr){
            return;
  }
  string str="";
  str+=((root->left!=nullptr)?to_string(root->left->data ) :"." );
  str+="<-"+ to_string(root->data)+"->";
  str+=((root->right!=nullptr)?to_string(root->right->data):".");
  cout<<(str)<<endl;
  display(root->left);
  display(root->right);
}

///////////////////Basic Functions
int height(Node* root){
    if(root==nullptr){
        return -1;
    }
    return max(height(root->left),height(root->right))+1;
}
int size(Node* root){
    if(root==nullptr){
        return 0;
    }
    return size(root->left)+size(root->right)+1;
}
bool find(Node* root,int a){
    if(root==nullptr){
        return false;
    }
    if(root->data==a){
        return true;
    }
return find(root->left,a)||find(root->right,a);
}   

int minimum(Node* root){
 Node* curr=root;
 while(curr->left!=nullptr){
     curr=curr->left;
 }
 return curr->data;
}

int Lca(Node* root,int a,int b){
    Node* curr=root;
    while(curr!=nullptr){
        if(a<curr->data && b<curr->data){
            curr=curr->left;
        }
        else if(a>curr->data && b>curr->data){
            curr=curr->right;
        }
        else{
            return find(curr,a) && find(curr,b) ? curr->data:-1;
        }
       
    }
     return -1;
}
void allnodesinrange(Node* root,int a,int b,vector<int> &ans){
    if(root==nullptr){
        return;
    }
    allnodesinrange(root->left,a,b,ans);
    if(root->data>=a && root->data<=b){
        ans.push_back(root->data);
    }

    allnodesinrange(root->right,a,b,ans);

}