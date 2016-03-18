1. 정렬되지 않은 integer 배열에서 k번째로 큰 수 찾기 : kth largest element in an array  
문제 : <https://leetcode.com/problems/kth-largest-element-in-an-array/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol09.kthElement/src/Solution.java>  
해설 : quick sort에서 사용하는 partition을 이용하면 O(logn) 의 시간 복잡도로 해결 할 수 있다.
partition은 pivot의 위치를 기준으로, 왼쪽의 값들은 pivot 보다 작은 값들이고, 오른쪽의 값들은 pivot보다 큰 값이다. 따라서 partition 함수는 k 번째 위치하는 값을 리턴해줄 수 있다.

2. 정렬된 float 배열에서 integer value가 주어졌을 때, 가장 가까운 float 값 찾기  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol08.FindFloatValue/src/Solution.java>  
해설 : binary search 를 이용하면 O(logn) 의 시간 복잡도로 해결 할 수 있다.
left와 right 의 거리 차가 1과 같거나 작을 때, 두 값을 비교하여 가까운 값을 리턴하고,
left와 right는 mid 값을 기준으로 위치를 옮겨야 한다

3. 정렬된 int 배열이 주어질 때, target 값과 가까운 k 개 찾기 : Find k cloest elements given value  
문제 : <http://www.geeksforgeeks.org/find-k-closest-elements-given-value/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol11.kClosest/src/Solution.java>  
해설 :  binary search 를 이용해서, 가장 가까운 값을 찾는다. 그 값을 주위로 target 과 가까운 값들을 추가한다.

4. Float to String, String to Float  
문제 : <http://www.geeksforgeeks.org/find-k-closest-elements-given-value/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol12.StringToFloat/src/Solution.java>  
해설 : 풀긴 풀었는데, 코드가 깔끔하지 않다, 추가적인 내용 확인 필요

5. Run length encoding, decoding  
문제 : <http://www.geeksforgeeks.org/run-length-encoding/>  
해설 : 쉽게 해결 할 수 있는 문제이다, 예외 상황에 대한 처리가 필요하다. 예를들어 encoding 할 문자 중에 숫자가 포함되어 있다면 어떻게 될것인가? 이런 부분에 대한 고려를 하면서 문제를 명확히 하는 것이 필요하다.

6. K 개의 정렬된 배열을 Merge : Merge K sorted arrays  
문제 : <http://www.geeksforgeeks.org/merge-k-sorted-arrays/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol06.SortArrays/src/Solution.java>  
해설 : Min Heap을 이용하면 O(nlogk) 시간 복잡도로 풀 수 있다, 어느 배열에서 값을 가져왔는지 저장하는 것이 필요하고, Min Heap에서 값을 정렬하기 위해서 Comparable 을 implement 해야 하고, compareTo를 override 해야 한다

7. 긴 문자열이 주어졌을 때 해당 문자들을 모두 포함하는 가장 작은 substring 찾기 : Smallest Substring of All Characters   
문제 : <http://articles.leetcode.com/finding-minimum-window-in-s-which>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/pramp/Sol01.SmallestSubstring/src/Solution.java>  
해설 : 처음 풀이는 HashMap을 이용하는 방법이었는데, 이런 접근의 경우 O(n^2) 의 시간 복잡도이다. 이건 brute force 한 해결 방법이고, HashMap이 아닌 sliding window를 이용하면 O(n)으로 해결 할 수 있다. 보통 문자열을 찾고자 할 때 이 방법처럼, sliding window 방식으로 접근해야 한다! 이 때 가장 중요한 포인트는 left, right 를 언제 이동 시킬 것인지 이다! 꼭 기억해두자!

8. 입력받은 숫자에서 중복되는 숫자가 있는 경우, 이를 지운 후 가장 큰 값을 리턴  
문제 : <https://leetcode.com/discuss/88166/given-integer-find-digit-equal-either-adjacent-digits-remove>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol14.DigitRemoval/src/Solution.java>  
해설 : 334455 가 만들 수 있는 수는 3가지 경우이기 때문에, 이를 만들기 위해서 재귀적인 호출을 이용한 후, 구한 값을 ArrayList에 저장한 후, 가장 큰 값을 리턴하는 식으로 구현하려고 했고, 이 때의 시간 복잡도는 O(kn) 이 때 k 값은 만들 수 있는 수의 갯수이다. 이 부분이 잘못되었고, 해설을 참고하였고, O(n) 시간 복잡도에 해결 할 수 있는 식으로 수정하였다. 대부분의 String은 O(n) 으로 해결해야 한다. 이 때 앞부분과 뒷부분을 구해서 하나의 숫자로 만든다.

9. Binary Tree Path 중에서 최대 합을 가지는 Path 출력(Root에서 Leaf로 가는 경로) : Find the maximum sum leaf to root path in a Binary Tree  
문제 : <http://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol15.MaxPathSum/src/Solution.java>  
해설 : 단순히 값을 구하는 것은 recursive 함수를 이용해서 쉽게 할 수 있지만, 값과 동시에 path를 구하는 것은 어려웠다. 특히나 path를 출력하기가 까다로운 부분이 있는데, 출력은 할 수는 있는데, 최적인지는 아직 확신이 없다.

	추가 문제 : Find the longest path from root to leaf in a binary tree
	root 에서 leaf 까지 path를 기록해둔 후, 현재까지의 max path를 저장한 후, 모두 수행한 후에 max path를 리턴한다.  
	추가 문제 : Print the Longest leaf to leaf path in a binary tree and its length
	현재 노드에서 max(left height + right height + 1, diameter(left child), diameter(right child)) 로 재귀적으로 구할 수 있다.  
	<http://www.geeksforgeeks.org/diameter-of-a-binary-tree/>

10. Binary Tree Path 중에서 최대 합을 가지는 Path 출력(모든 경로 가능) : Find the maximum sum path in a binary tree (9번에서 발전된 문제)  
문제 : <https://leetcode.com/problems/binary-tree-maximum-path-sum/>  
<http://www.programcreek.com/2013/02/leetcode-binary-tree-maximum-path-sum-java/>  
<https://github.com/hyogij/CodingInterview/blob/master/leetcode.com/Day18.MaximumPathSum/src/leetCode/MaximumPathSum.java>  
해설 : 재귀적인 방법으로 풀어야 하는데, 풀이법을 생각하기 어렵다. 언제 left child를 선택하고, 언제 right child를 선택하는지 결정해야 한다

11. Binary Tree를 Invert 하라 : Invert binary tree  
문제 : <https://leetcode.com/problems/invert-binary-tree/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/leetcode.com/Day18.InvertBinaryTree/src/leetCode/InvertBinaryTree.java>  
해설 : 재귀적인 방법과 반복적인 방법이 있는데, 쉬운 방법으로 먼저 접근하면 된다. 재귀적인 방법이 좀 더 생각해야 할 부분이 있다. Tree에서 반복적인 방법을 이용하는 경우에는 무조건 Queue를 이용하면 된다!

12. Undriected graph 복사 : Clone graph  
문제 : <https://leetcode.com/problems/clone-graph/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/leetcode.com/Day28.CloneGraph/src/leetCode/CloneGraph.java>
해설 : Iterative 한 방법과 recursive한 방법이 있는데, 여기에서 가장 중요한 내용은 한 번 복사한 것이 중복되어 처리되지 않도록 해야 한다. 이걸 Map을 이용해서 처리한다. 모든 것을 복사해야 한다. Graph 의 경우에도 BFS 할 경우 Queue를 이용하고, DFS 경우 재귀적으로 호출한다. 
Queue Empty 체크를 주의해야 한다

13. 두 개의 정렬된 배열에서 k 번째로 작은 수 찾기 :  Find the k-th Smallest Element in the Union of Two Sorted Arrays  
문제 : <http://articles.leetcode.com/find-k-th-smallest-element-in-union-of/>  
풀이 : <http://algorithmsandme.in/2014/12/find-kth-smallest-element-in-two-sorted-arrays/>  
해설 : O(k) 로 푸는 방식이 가장 쉬운 방식이지만, linear search 가 아닌 binary search 방식으로 시간을 줄여야 한다. 이 방식을 이용하면 O(logn + logm) 이 된다.  
<https://www.youtube.com/watch?v=tmu50Fs4v54>  
인덱스를 계산하는 부분과 어떻게 나눠지는지가 중요하다, 어려운 문제다!  

14. 두 정렬된 배열에서 공통되는 element 찾기 : Finding intersection of two sorted arrays  
문제 : <http://articles.leetcode.com/here-is-phone-screening-question-from/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol17.findIntersection/src/Solution.java>  
해설 : pramp 에서 푼 문제와 동일하고, 두 배열의 사이즈가 다를 때 어떻게 처리하는지가 중요하다.

15. 두 문자열이 Anagram 인지 확인 : Whether two strings is an anagram  
문제 : <https://leetcode.com/discuss/48469/whether-two-strings-is-an-anagram>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol18.isAnagram/src/Solution.java>  
해설 : 단순히 Anagram 인지 비교하는 것은 쉽게 할 수 있다, char array를 이용해서 갯수를 세면된다. O(kn)의 시간이 소요된다. 이렇게 해도 될 듯 하다. 아니면 Smallest Sub String 찾는 문제와 동일한 방식으로 풀어도 된다.

	추가 문제 : 두 개의 String이 주어졌을 때, str1이 str2의 sub anagram 인지 확인하기
	7번와 유사한 문제이다 : Smallest Substring of All Characters(최소 길이가 정해져 있음)

16. 배열의 평형(합을 둘로 나눌 수 있는 Index) 찾기 : Equilibrium index of an array  
문제 : <http://www.geeksforgeeks.org/equilibrium-index-of-an-array/>  
<https://leetcode.com/discuss/71253/find-the-equilibrium-index-in-the-array>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol19.Equilibrium/src/Solution.java>  
해설 : 가장 간단한 방법은, 기준을 하나씩 옮겨가면서 왼쪽과 오른쪽 합을 비교하는 것이다. 이것에 대한 Time Complexity는 O(n^2)이 된다. 이를 빠르게 해결하기 위해서, sum을 구한 후에 이것을 반으로 나눌 수 있는 Index를 찾는다.
 
17. abbreviation이 유일한지 확인 : Check if abbreviation is unique  
문제 : <https://www.careercup.com/question?id=5648469500887040>  
<https://leetcode.com/discuss/questions/oj/unique-word-abbreviation>  
<http://buttercola.blogspot.kr/2015/10/leetcode-unique-word-abbreviation.html>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol20.Abbreviation/src/Solution.java>  
해설 : HashMap을 이용하면 unique한지 쉽게 알 수 있다. O(1) 시간으로 알 수 있다.

	추가 문제 : Generalized abbreviation (추가적인 확인 필요)  
	<https://leetcode.com/problems/generalized-abbreviation/>  
	<https://leetcode.com/discuss/questions/oj/generalized-abbreviation?sort=votes>  

18. spiral form 형태로 배열 출력 : Print a given matrix in spiral form  
문제 : <http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/>  
풀이 : <http://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/>  
<https://github.com/hyogij/CodingInterview/blob/master/practice/Sol22.spiralMatrix/src/Solution.java>
인덱스 계산이 까다로운 문제이다.(제대로 풀지 못하였다)  

19. 비스듬한 배열 출력 : Print two-dimensional array of obliquely  
문제 : <https://leetcode.com/discuss/59895/print-two-dimensional-array-of-obliquely>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol21.Print2DObliquely/src/Solution.java>  
해설 : 인덱스 계산이 까다로운 문제이다.(제대로 풀지 못하였다)  

20. 링크드 리스트를 O(nlogn) 의 시간 복잡도로 정렬하라 : Sort List  
문제 : <https://leetcode.com/problems/sort-list/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol23.SortList/src/Solution.java>  
해설 : 가장 쉬운 방법은 배열에 리스트 값을 저장한 다음에, 배열을 정렬한 후, 배열의 값들을 리스트에 넣는 것이다. 이 경우 O(nlogn)으로 할 수는 있지만, 추가적인 공간이 필요하다. 따라서 추가적인 공간 없이 할 수 있는 방법은 리스트에 Merge Sort를 적용하는 것이다. MergeSort에서 두 부분으로 나누는데, 링크드 리스트에서도 두 부분을 나눠야 한다(포인터가 가리키는 것을 null 처리 해야 한다)

19. 링크드 리스트를 Insertion Sort를 이용해서 정렬 : Insertion Sort List  
문제 : <https://leetcode.com/problems/insertion-sort-list/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol24.InsertionSort/src/Solution.java>  
해설 : 먼저 배열을 정렬하는 것을 작성한 후, 링크드 리스트도 위와 같은 방식으로 접근하려고 했는데, 잘 되지 않았다. 앞에서부터 하든, 뒤에서부터 하든, prev 포인트가 필요했다. dummy head가 필요하고, 배열 Insertion Sort와 동일하게, 정렬된 리스트를 만들어 가고, 거기에 target을 추가하는 식으로 하면 된다.

20. BST에서 Inorder 후손자 찾기 : BST Inorder Successor Search  
문제 : <http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol25.InorderSuccessor/src/Solution.java>  
해설 : 일단 해당 BST에서 parent pointer가 있는 경우, 없는 경우로 문제를 명확히 해야 한다. 없는 경우에는 해당 노드를 찾아가면서 inorder successor를 찾아야 하고, 있는 경우에는 부모 노드로 올라가면서 찾을 수 있다. 하지만 두 경우 모두 right child가 있는 경우 left most child 를 찾으면 된다.

21. 주어진 그래프가 유효한 트리인지 확인 : Valid Tree  
문제 : <http://buttercola.blogspot.kr/2015/08/leetcode-graph-valid-tree.html>  
풀이 : <https://leetcode.com/discuss/54211/ac-java-solutions-union-find-bfs-dfs>  
<https://github.com/hyogij/CodingInterview/blob/master/practice/Sol27.ValidTree/src/Solution.java>  
해설 : 주어진 인풋으로 그래프를 만들어서, DFS 또는 BFS 를 통하여 cycle 이 있는지, fully connect 되었는지 확인하여 유효한 트리인지 확인한다. DFS는 스택과 재귀적인 방식이고, BFS는 큐와 Iterative 한 방식이다. 그래프의 DFS, BSF Time complexity 는? O(V+E)  
다른 방법은 그래프를 만들지 않고, union-find 를 이용하여 해결 할 수 있다. Union Find 는 원래 어디에서 쓰이는가? kruskal minimum spanning tree 에서 사용된다.  
DFS(스택 이용), BFS(큐이용) : 상대 노드의 Edge list 에서 해당 Edge를 지워주는게 중요하다(방문한 Edge는 지운다), 
Disjoint Set(Union, Find 알고리즘 이용) : Number of Connected Components in an Undirected Graph

	추가 문제 : 그래프에서 Cycle 이 존재하는지 확인 : Detect Cycle in a Directed Graph, Detect cycle in an undirected graph  
	문제 : <http://www.geeksforgeeks.org/detect-cycle-in-a-graph/>  
	<http://www.geeksforgeeks.org/detect-cycle-undirected-graph/>  
	<http://www.geeksforgeeks.org/union-find/>  
	해설 : DFS, BFS 를 이용하여 풀 수도 있고, union find 를 이용해서 풀 수도  있다. directed graph 에서 union find 를 사용하는 법은 조금 어렵다.(코드 작성, Directed Graph)

	추가 문제 : "이중 연결 리스트에서 포인터 주소만 주어지는 경우, sub list 수 구하기"도 union find 로 해결 가능했나?
	개념은 설명할 수 있는데, 실제 구현하는 것은 어렵다.  
	<https://en.wikipedia.org/wiki/Disjoint-set_data_structure>  
	(코드 작성, 생각해봐야 하는 문제, Union Find 로 가능한가?)  

22. Pancake Sort  
문제 : <http://www.geeksforgeeks.org/pancake-sorting/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol28.PancakeSort/src/Solution.java>  
해설 : 가장 작은 걸 찾은 후에, 뒤집고, 그 다음 작은 걸 찾은 후에 뒤집는다. 이걸 반복한다. Time Complexity 는? O(n^2) 이 된다.

22. Topology Sorting 구현  
문제 : <https://leetcode.com/problems/course-schedule/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol33.CourseSchedule/src/Solution.java>  
<https://leetcode.com/discuss/39456/java-dfs-and-bfs-solution>  
<https://leetcode.com/discuss/35578/easy-bfs-topological-sort-java>  
해설 : 토폴로지 소팅을 어떻게 구현할 것인가? 이 문제는 graph 가 cycle 이 없어야 한다는 것과 동일한 문제가 된다. 때문에 동일하게 DFS 와 BFS 방식으로 풀 수 있다. 내 방식대로, 토폴로지 소팅을 구현하면 되는데, 그렇게 깔끔하지 않다. 계속해서 loop를 돌아 inbound 값을 체크해야하고, visit 여부를 확인해야 한다는 단점들이 있다. 1차원, 2차원 배열을 이용하면 구조를 쉽게 할 수 있다.

23. Insert Intervals  
문제 : <https://leetcode.com/problems/insert-interval/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol29.InsertInterval/src/Solution.java>  
해설 : 전제 조건이 기존의 interval 들은 정렬되어 있고, 여기에 하나가 추가되는 경우 merge를 하여 새로운 interval 들을 만든다. 계속 추가 가능하다. 하지만 코드 작성은 깔끔하지가 않다. 여러 예외 조건을 처리해줘야 한다. 조금 더 깔끔한 알고리즘이 필요하다. 조건들에 대해서 나눠서 생각하면 된다. 단순히 코드를 작성하는 것이 아니라, 조건들을 나누고 분리한다.

	추가 문제 : Merge Intervals <https://leetcode.com/problems/merge-intervals/>  
	내가 생각해낸 알고리즘은 이전 것만 비교하는 방식이었다. 하지만 이게 문제되는 경우는 [1, 2], [3, 4], [6, 7], [1,10] 이렇게 되면 이미 추가가 되었기 때문에 문제가 발생한다. 이건 어떻게 해결 할 수 있는가?  
	이걸 해결 할 수 있는 방법은 start를 기준으로 정렬한다. (Comparator 인터페이스 구현)  
	풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol30.MergeInterval/src/Solution.java>  
	<http://www.programcreek.com/2012/12/leetcode-merge-intervals/>  

	추가 문제 : Given a set of ranges for eg., (1,3), (2,4), (6,7) return only the non-overlapping set of ranges (which in this case should return only (6,7)). <https://www.careercup.com/question?id=13014685>
	같다고 해서 non-overlapping 영역이 아니다, 모든 것을 포함 할 수도 있는 부분이다.  
	유사한 문제 : Find maximum non-overlapping intervals  
	(코드 작성, 정리 필요, 개념 확인 필요)  

24. Meeting Room  
문제 : <http://buttercola.blogspot.kr/2015/08/leetcode-meeting-rooms.html>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol31.MeetingRoom/src/Solution.java>  
해설 : 위의 Insert Intervals, Merge Intervals와 유사하다. 먼저 정렬을 한 후 겹치는지 여부를 확인한다.  

	추가 문제 : Meeting Room II  
	<http://buttercola.blogspot.kr/2015/08/leetcode-meeting-rooms-ii.html>  
	풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol32.MeetingRoom2/src/Solution.java>  
	<https://goo.gl/VFxvKb>  
	<http://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/>  
	해설 : start 시간과 end 시간으로 정렬하는게 가장 중요하다. 그래서 최대 몇 개가 필요한지 계산 할 수 있다.  

25. Jump Game : Find minimum number of steps to reach the end of array from start (array value shows how much you can move).   
문제 : <https://leetcode.com/problems/jump-game/>  
<https://leetcode.com/problems/jump-game-ii/  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol34.JumpGame/src/Solution.java>  
<https://github.com/hyogij/CodingInterview/blob/master/practice/Sol35.JumpGame2/src/Solution.java>  
해설 : 배열의 값은 최대로 뛸 수 있는 값이다. 동영상 설명을 통해서 해결 방법을 알게 되었다. 하지만 이 방법도 Time Limit를 초과하는 솔루션이다. 하지만 답을 구할 수 있다. Recursive 하게 푸는 것이 오히려 어렵다.  
(코드 작성 : 개선된 답안 또는 Recursive 하게 푼 답안)

26. Combinations, Combination Sum, Combination Sum II, Combination Sum III  
문제 : <https://leetcode.com/problems/combinations/>  
<https://leetcode.com/problems/combination-sum/>    
<https://leetcode.com/problems/combination-sum-ii/>  
<https://leetcode.com/problems/combination-sum-iii/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol37.CombinationSum/src/Solution.java  
<https://github.com/hyogij/CodingInterview/blob/master/practice/Sol38.CombinationSum2/src/Solution.java>  
<https://github.com/hyogij/CodingInterview/blob/master/practice/Sol39.CombinationSum3/src/Solution.java>  
해설 : 재귀적으로 (recursive하게) 호출하였다. 새로운 ArrayList를 생성하면서, 인자로 전달하는 방식을 사용하면 된다. 그리고 조건을 달리하면서 풀 수 있어야 한다.  

	다른 풀이 : Subset Sum Problem   
	문제 : <http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/>  
	풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol36.SubsetSum/src/Solution.java>  
	해설 : 지금의 풀이는 재귀적인 방식이다. 재귀적인 방식 뿐만 아니라 Dynamic 한 방법 모두 할 수 있어야 한다. 동영상을 통해서 확인하였고, 2차원 배열을 만들어서 타겟 값이 가능한지 확인해본다. 하나씩 하나씩 확장해나가는 방식이고 기존의 결과를 그대로 이용하는 방식이다.
	이 문제가 예전에 풀었던 구글 문제인 듯 하다(재귀적인 방법 익히기, 기존 문제 풀이)  
	--> 이것에 대한 시간 복잡도는 무엇인가? O(n^3) 이 된다.  

27. 숫자 배열에서 가장 긴 증가한 수의 길이는? Longest Increasing Subsequence  
문제 : <https://leetcode.com/problems/longest-increasing-subsequence/>  
<http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol40.lengthOfLIS/src/Solution.java>  
해설 : Dynamic Programming을 이용하면 O(n^2) 시간 으로 해결 할 수 있다. 배열을 생성한 후, 초기 값을 1로 설정한 후, 왼쪽에서 부터 차근차근 increasing 값을 구해 나간다. Dynamic Programming이 아니면 어떻게 할 수 있는가?
	
	추가 문제 : Longest Bitonic Subsequence 구하여라(1234321)  
	문제 : <http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/>  
	해설 : 두 개의 배열을 만들어서, 왼쪽에서 시작하고, 오른쪽에서 시작하여 계산한다. 두 결과를 더한다.  

28. 그래프에서 삼각형 개수 세기 : Number of Triangles in an Undirected Graph  
문제 : <http://www.geeksforgeeks.org/number-of-triangles-in-a-undirected-graph/>  
<https://www.careercup.com/question?id=5988741646647296>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol41.triangleInGraph/src/Solution.java>  
해설 : 노드 수가 주어지고 Edge 가 주어졌을 때, 이걸로 만들 수 있는 삼각형의 수는?  
Combination을 만드는데, 연결되었는지 구분한 후 만든다. 그러면 모든 Combination 을 만들 필요는 없다.하지만 Vertex를 기준으로 만들기 때문에 O(n^3)의 시간 복잡도이다. Edge 기준으로 풀 수 있다. 이 때 시간 복잡도는 O(n * d^2) 이 된다. 좀 더 생각하면 풀 수 있는 문제였는데 아쉬움이 크다.

29. 두 문자열의 곱을 구하라 : Multiply Strings  
문제 : <https://leetcode.com/problems/multiply-strings/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol42.multiply/src/Solution.java>  
<https://leetcode.com/discuss/71593/easiest-java-solution-with-graph-explanation>  
해설 : 곱하기 함수를 한자리 수 곱하기, 10의 배수 곱하기, 더하기 함수를 이용해서 풀려고 했는데, 이 또한 해결 방식이 복잡하다.
이러한 방향으로 생각해봐야 한다. 문제를 풀어서 해결하도록 한다. 어느 곳에 위치하는지 그리고 그것을 어떻게 풀어 나갈지 생각해야 한다!
인덱스를 계산하는 부분이 까다롭고, 어떻게 곱셈을 알고리즘 화 할 수 있는지 차근차근 경우를 따져 계산해야 한다. 큰 문제를 체계적으로 나누는게 중요하다!

30. Smallest Substring Search 와 유사한 문제 : Anagram Substring Search  
문제 : <http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/>  
<https://www.careercup.com/question?id=5389078581215232  
풀이 : <https://github.com/hyogij/CodingInterview/blob/master/practice/Sol43.searchAnagram/src/Solution.java>  
해설 : O(n) 풀기위해서는 sliding window를 이용한다, 그리고 요구하는 갯수를 저장할 배열이 필요하다. 위에서 풀어본 Smallest Substring Search 와 동일한 방식으로 풀 수 있다.   
--> 7번과 다른 방식인가? 7번과 동일한 방식으로 풀 수 있다. 중요하다!

31. 두 문자열이 주어졌을 때, 변경해야 할 횟수를 리턴 : Edit Distance  
문제 : <https://leetcode.com/problems/edit-distance/>  
풀이 : <https://github.com/hyogij/CodingInterview/blob/b34f540dd3056d5970050cc7ac806e628f6acc0a/practice/Sol05.EditDistances/src/Solution.java>  
해설 : 동적으로 그리고 재귀적인 방식으로 풀 수 있어야 한다! replace, delete, add 연산만 가능하다.