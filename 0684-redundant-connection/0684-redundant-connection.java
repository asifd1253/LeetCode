class Solution {
    int totalNodes;

    public int[] findRedundantConnection(int[][] edges) {
        int res[] = new int[2];
        totalNodes = edges.length;
        DisJointSet dsu = new DisJointSet(totalNodes);

        for(int edge[] : edges){
            if(!dsu.unionBySize(edge[0]-1,edge[1]-1)){   //our nodes labelled from 1 to n
                res = edge;
            }
        }

        return res;
    }
}

public class DisJointSet{
    int parent[];
    int size[];
    DisJointSet(int nodes){
        this.parent = new int[nodes];
        this.size = new int[nodes];
        for(int i=0; i<nodes; i++){
            this.parent[i]=i;
            this.size[i]=1;
        }
    }

    public boolean unionBySize(int node1,int node2){
        int rootParent1 = findRootParent(node1);
        int rootParent2 = findRootParent(node2);
        
        // if it is in same component
        if(rootParent1 == rootParent2){
            return false;
        }

        // else
        if(size[rootParent1] < size[rootParent2]){
            parent[rootParent1] = rootParent2;
            size[rootParent2] += size[rootParent1];
        }else{
            parent[rootParent2] = rootParent1;
            size[rootParent1] += size[rootParent2];
        }

        return true;
    }

    public int findRootParent(int node){
        if(node == parent[node]){
            return node;
        }
        parent[node] = findRootParent(parent[node]);
        return parent[node];
    }

}