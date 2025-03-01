package com.phasmidsoftware.dsaipg.adt.pq;

import java.util.Comparator;

import java.util.function.BiPredicate;

public class FourAryHeap<K> extends PriorityQueue<K> {


    public FourAryHeap(int n, int first, boolean max, Comparator<K> comparator, boolean floyd) {
        super(n, first, max, comparator, floyd);
    }


    @Override
    protected int parent(int k) {
        return (k - first - 1) / 4 + first;
    }

    @Override
    protected int firstChild(int k) {
        return 4 * (k - first) + 1 + first;
    }

    @Override
    protected int doHeapify(int k, BiPredicate<Integer, Integer> p) {
        int i = k;
        while (firstChild(i) <= last + first - 1) {
            int j = firstChild(i);

            for (int child = 1; child < 4; child++) {
                if (j + child <= last + first - 1 && unordered(j, j + child)) {
                    j = j + child;
                }
            }

            if (p.test(i, j)) break;
            swap(i, j);
            i = j;
        }
        return i;
    }
}

