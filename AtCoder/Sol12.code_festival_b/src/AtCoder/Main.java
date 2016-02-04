package AtCoder;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-28
 * @url http://code-festival-2014-china-open.contest.atcoder.jp/tasks/code_festival_china_b
 */
public class Main {

	/*
	Problem
	Let us define an strict total order relation between 2 distinct points P(x1,y1),Q(x2,y2) on a rectangular coordinate plane as following.

	If |x1|+|y1|¡Á|x2|+|y2| and |x1|+|y1|<|x2|+|y2| then P<Q
	If |x1|+|y1|=|x2|+|y2| and x1¡Áx2 and x1<x2 then P<Q
	If |x1|+|y1|=|x2|+|y2| and x1=x2 and y1<y2 then P<Q
	If else, P>Q
	Your task is to answer many queries that asks, "When you sort the set of all the integer lattice Z2 in ascending order by the relation defined above, output the n-th (1-indexed) element."

	Input
	Input is given in the following format

	Q
	n1
	n2
	:
	nQ
	On the first line, you will be given an integer Q(1¡ÂQ¡Â100,000), the number of queries.
	On the following Q lines, each line contains the information of each query. The i-th (1¡Âi¡ÂQ) line consists of ni(1¡Âni¡Â1018), the number n of the i-th query.
	Output
	Output Q lines, each line containing the answer to each query in the order the queries appear in the input. Make sure to insert a line break at the end of the last line.

	Input Example 1
	7
	1
	2
	3
	4
	5
	6
	1000000000000000000
	Output Example 1
	0 0
	-1 0
	0 -1
	0 1
	1 0
	-2 0
	263818038 443288743
	*/
}
