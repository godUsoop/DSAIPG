Problem Description: 
Implement a 3Sum solution using Quadrithmic and Quadratic approaches, and brief explanation of why the quadratic method(s) work.

The implementations of the ThreeSumQuadrithmic and ThreeSumQuadratic approaches are in (src/main/java/com/phasmidsoftware/dsaipg/adt/threesum).

Observation: 

| **Length of elements** | **ThreeSumCubic** | **ThreeSumQuadrithmic** | **ThreeSumQuadratic** |
|----------------------|----------------|----------------------|------------------|
| **2000**  | 272ms  | 40ms   | 9ms   |
| **4000**  | 1954ms | 133ms  | 17ms  |
| **6000**  | 6232ms | 265ms  | 29ms  |
| **8000**  | 14639ms | 503ms  | 52ms  |
| **10000** | 28451ms | 807ms  | 80ms  |



Conclusion:
For each index j, there are two pointers next to it: the left pointer, which is j−1, and the right pointer, j+1. Add the values of the elements at these three indices. Since the array is already sorted, if the sum of the three numbers is greater than 0, the left pointer must move to the left. If the sum is less than 0, the right pointer should move to the right. We can just choose either left pointer moves to the left or right pointer moves to the right when the sum is zero.

Before executing the getTriples function, there is an outer loop: for (int i = 0; i < length; i++) triples.addAll(getTriples(i)); which means it has O(N) ime complexity, where N is the number of elements in the array. As for the getTriples method, since it uses two pointers, we can conclude that the getTriples approach also has O(N) time complexity because each element is traversed once. Therefore, the ThreeSumQuadratic method has a time complexity of O(N^2) for a sorted array.
