package com.phasmidsoftware.dsaipg.adt.pq;


import com.phasmidsoftware.dsaipg.util.Stopwatch;
import java.util.*;

public class HeapBenchmark {

    private static Random random = new Random();

    public static void main(String[] args) throws PQException {
        int capacity = 4095;
        boolean isMax = false;
        boolean useFloyd = false;
        int repetition = 200;
        Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
        int[] sizes = new int[]{4000, 16000, 64000, 256000};
        runner("binaryHeap", comparator, capacity, isMax, useFloyd, repetition, sizes);
        runner("binaryHeapWithFloyd", comparator, capacity, isMax, !useFloyd, repetition, sizes);
        runner("fourAryHeap", comparator, capacity, isMax, useFloyd,repetition, sizes);
        runner("fourAryHeapWithFloyd", comparator, capacity, isMax, !useFloyd, repetition, sizes);
    }

    private static void runner(String heapType, Comparator<Integer> comparator, int capacity, boolean isMax, boolean useFloyd, int repetion, int[] sizes) throws PQException {
        for (int size: sizes) {
            long totalTime = 0;
            for (int r = 0; r < repetion; r++) {
                PriorityQueue<Integer> heap = heapSelection(heapType, comparator, capacity, isMax, useFloyd);
                totalTime += benchmark(heap, size);
            }
            System.out.println(heapType + " spent: " + (double) totalTime / repetion + " ms " + "in length " + size);
        }
    }

    private static PriorityQueue<Integer> heapSelection(String heapType, Comparator<Integer> comparator, int capacity, boolean isMax, boolean useFloyd) {
        if (heapType.equals("binaryHeap")) {
            return new PriorityQueue<>(capacity, 0, isMax, comparator, useFloyd);
        } else if (heapType.equals("binaryHeapWithFloyd")) {
            return new PriorityQueue<>(capacity, 0, isMax, comparator, !useFloyd);
        } else if (heapType.equals("fourAryHeap")) {
            return new FourAryHeap<>(capacity, 0, isMax, comparator, useFloyd);
        } else if (heapType.equals("fourAryHeapWithFloyd")){
            return new FourAryHeap<>(capacity, 0, isMax, comparator, !useFloyd);
        }
        return null;
    }

    private static long benchmark(PriorityQueue<Integer> heap, int size) throws PQException {
        try (Stopwatch target = new Stopwatch()) {
            for (int i = 0; i < size; i+=4) {
                for (int j = 0; j < 4; j++) {
                    heap.give(random.nextInt());
                }
                heap.take();
            }
            return target.lap();
        }
    }
}
