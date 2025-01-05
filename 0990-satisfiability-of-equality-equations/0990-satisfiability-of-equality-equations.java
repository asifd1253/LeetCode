class Solution {
    public boolean equationsPossible(String[] equations) {
        DisJointSet dsu = new DisJointSet(26);
        ArrayList<int[]> notEqualEdges = new ArrayList<>();
        
        for(String str : equations){
            int u = str.charAt(0) - 'a';
            int v = str.charAt(3) - 'a';

            if(str.charAt(1) == '=' && str.charAt(2) == '='){  //union the component
                dsu.unionBySize(u,v);
            }else{  //store in seperate
                notEqualEdges.add(new int[]{u,v});
            }
        }

        for(int[] edge : notEqualEdges){
            int u = edge[0];
            int v = edge[1];

            if(dsu.findRootParent(u) == dsu.findRootParent(v)){
                return false;
            }
        }

        return true;
    }
}

class DisJointSet{
    int parent[];
    int size[];
    DisJointSet(int node){
        this.parent = new int[26];
        this.size = new int[26];
        for(int i=0; i<26; i++){
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int findRootParent(int node){
        if(node == parent[node]){
            return node;
        }

        parent[node] = findRootParent(parent[node]);
        return parent[node];
    }

    public boolean unionBySize(int node1,int node2){
        int rootParentNode1 = findRootParent(node1);
        int rootParentNode2 = findRootParent(node2);

        if(rootParentNode1 == rootParentNode2){
            return false;
        }

        if(size[rootParentNode1] <= size[rootParentNode2]){
            parent[rootParentNode1] = rootParentNode2;
            size[rootParentNode2] += size[rootParentNode1];
        }else{
            parent[rootParentNode2] = rootParentNode1;
            size[rootParentNode1] += size[rootParentNode2];
        }
        return true;
    }
}