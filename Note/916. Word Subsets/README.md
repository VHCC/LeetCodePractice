# 709. To Lower Case

<h4>Notes</h4>

1. wordB 個別英文字母各數加總。
2. Integer.valueOf('a');



<h3>Algorithm</h3>

Reduce B to a single word bmax as described above, then compare the counts of letters between words a in A, and bmax.

<h3>Complexity Analysis</h3>

Time Complexity: O(\mathcal{A} + \mathcal{B})O(A+B), where \mathcal{A}A and \mathcal{B}B is the total amount of information in A and B respectively.

Space Complexity: O(A\text{.length} + B\text{.length})O(A.length+B.length).




