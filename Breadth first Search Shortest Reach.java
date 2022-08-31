import java.util.*;

class GraphNode{
    int sumNodes;
    ArrayList<LinkedList<Integer>> adjList;
    public GraphNode(int numNodes){
        this.sumNodes = numNodes;
        adjList = new ArrayList<LinkedList<Integer>>();
        for(int i = 0; i < numNodes; i++){
            adjList.add(new LinkedList<Integer>());
        }
    }
    public void addEdge(int a, int b){
        adjList.get(a).add(b);
        adjList.get(b).add(a);
    }
}

public class Solution {

    public static void getDistance(ArrayList<LinkedList<Integer>> adjList, int[] results, int s){
        LinkedList<Integer> q = new LinkedList();
        boolean[] isVisited = new boolean[adjList.size()];
        q.add(s);
        isVisited[s] = true;
        int count = 0;
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i = 0; i < qSize; i++){
                int removed = q.poll();
                results[removed] = count;
                for(int x: adjList.get(removed)){
                    if(!isVisited[x]){
                        q.add(x);
                        isVisited[x] = true;
                    }
                }
            }
            count += 6;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for(int i = 1; i <= q; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            GraphNode g = new GraphNode(n);
            for(int j = 1; j <= m; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                g.addEdge(a-1, b-1);
            }
            int s = sc.nextInt();
            int[] results = new int[n];
            Arrays.fill(results, -1);
            getDistance(g.adjList, results, s-1);
            for(int k = 0; k < n; k++){
                if(k != s-1) System.out.print(results[k]+ " ");
            }
            
            System.out.println();
        }
    }
}
