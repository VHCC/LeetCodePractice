---
title: 916. Word Subsets
hidden: true
toc: true
toc_number: true
date: 2021-01-01 16:43:58
tags: Leetcode
categories: 
keywords:
description:
top_img: https://scontent.ftpe7-4.fna.fbcdn.net/v/t1.6435-9/118762738_747247169430106_1590773368171619926_n.jpg?_nc_cat=101&ccb=1-5&_nc_sid=8631f5&_nc_ohc=FPvuyt9VLEQAX8ypm_D&_nc_ht=scontent.ftpe7-4.fna&oh=a70cf57013ea7b41e480db19a4d09670&oe=61CEC914
cover: https://res.cloudinary.com/practicaldev/image/fetch/s--x0krGruJ--/c_imagga_scale,f_auto,fl_progressive,h_420,q_auto,w_1000/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/i5bcbvz8ko7j5yq7j1m4.jpeg
comments:
copyright:
mathjax:
katex:
hide:
---

# 916. Word Subsets

<h4>Notes</h4>

1. wordB 個別英文字母各數加總。
2. Integer.valueOf('a');



<h3>Algorithm</h3>

Reduce B to a single word bmax as described above, then compare the counts of letters between words a in A, and bmax.

<h3>Complexity Analysis</h3>

Time Complexity: O(\mathcal{A} + \mathcal{B})O(A+B), where \mathcal{A}A and \mathcal{B}B is the total amount of information in A and B respectively.

Space Complexity: O(A\text{.length} + B\text{.length})O(A.length+B.length).




