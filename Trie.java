class trie{

public  class Node{
    int wordend=0
    Node[] childs;
    Node(){
        this.childs=new Node[26];
        this.wordend=0;
    }
}
public  void insert(String word){
    Node curr=root;
    int n=word.length();
    for(int i=0;i<n;i++){
        int idx =word.charAt(i)-'a'
        if(curr.childs[idx]==null){
            curr.childs[idx]=new Node();
            curr=curr.childs[idx];
        }
    }
       curr.wordend++;
}
public  boolean search(String Word){
      Node curr=root;
    int n=word.length();
    for(int i=0;i<n;i++){
        int idx =word.charAt(i)-'a'
        curr=curr.childs[idx];
        if(curr==null){
            return false;
        }
        }
        return curr.wordend>0;
    }
public boolean(String prefix){
         Node curr=root;
    int n=word.length();
    for(int i=0;i<n;i++){
        int idx =word.charAt(i)-'a'
        curr=curr.childs[idx];
        if(curr==null){
            return false;
        }
        }
        return true;
    }

    




}