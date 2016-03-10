/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.10
 Problem : http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 ==========================================================
 */
public class Solution {
	/*
	 */
	public static void main(String[] args) {
	}

	public static boolean validTree(int n, int[][] edges) {
		// Graph와 Tree의 가장 큰 차이는 Cycle 존재 유무이다
		// Tree는 Cycle이 없고, Graph는 있을 수 있다
		// 해당 노드와 edges를 이용하여 Graph를 만든 후, cycle 유무를 조사한다
		// Cycle 유무는 DFS로 방문하여, 이미 visited한 노드를 만나면 cycle 이 존재하는 것이다 
		// 이건 undirected graph의 cycle 유무를 찾는 것과 동일하가
		// directed graph는?
		// Graph 를 어떻게 구현 할 수 있지? DFS 중에서 이미 만난 걸 만나면 안된다 
		// tree : graph 이면서 fully connected 이고 no cycle 
		return true;
	}
	

}