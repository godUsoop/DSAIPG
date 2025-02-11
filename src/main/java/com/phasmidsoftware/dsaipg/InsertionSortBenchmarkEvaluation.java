package com.phasmidsoftware.dsaipg;

import com.phasmidsoftware.dsaipg.sort.Helper;
import com.phasmidsoftware.dsaipg.sort.HelperFactory;
import com.phasmidsoftware.dsaipg.sort.elementary.InsertionSortComparator;
import com.phasmidsoftware.dsaipg.util.ArrayGenerator;
import com.phasmidsoftware.dsaipg.util.Timer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Supplier;

import static com.phasmidsoftware.dsaipg.util.Config_Benchmark.setupConfigFixes;

public class InsertionSortBenchmarkEvaluation {


    private void EvaluateTimeSpent(Integer[][] arrays, String type) {
        Timer timer = new Timer();
        Comparator<Integer> comparator = Integer::compareTo;

        for (int i = 0; i < arrays.length; i++) {
            Integer[] array = arrays[i];
            Helper<Integer> helper = HelperFactory.createGeneric("Test", comparator, array.length, 1, setupConfigFixes());
            InsertionSortComparator<Integer> sorter = new InsertionSortComparator<>(helper);
            double time = timer.repeat(
                    5,
                    false,
                    () -> array,
                    a -> {sorter.sort(a, 0, a.length);
                        return a;
                    },
                    arr -> arr.clone(),
                    null
            );
            System.out.println("Insertion sort took: " + time +  "ms for a " + type + " array of length: "  + arrays[i].length);

        }

    }
    public static void main(String[] args) {
        ArrayGenerator arrayGenerator = new ArrayGenerator(10);

//        NOTE: when run EvaluateTimeSpent please comment out other  EvaluateTimeSpent method
        Supplier<Integer[][]> randomSupplier = () -> arrayGenerator.generateArray(5, "random");
        Integer[][] randomArrays = randomSupplier.get();
        new InsertionSortBenchmarkEvaluation().EvaluateTimeSpent(randomArrays, "random");

//        Supplier<Integer[][]> orderedSupplier = () -> arrayGenerator.generateArray(5, "ordered");
//        Integer[][] orderArrays = orderedSupplier.get();
//        new InsertionSortBenchmarkEvaluation().EvaluateTimeSpent(orderArrays, "ordered");

//        Supplier<Integer[][]> reverseSupplier = () -> arrayGenerator.generateArray(5, "reverse");
//        Integer[][] reversAarrays = reverseSupplier.get();
//        new InsertionSortBenchmarkEvaluation().EvaluateTimeSpent(reversAarrays, "reverse");

//        Supplier<Integer[][]> partialsupplier = () -> arrayGenerator.generateArray(5, "partially");
//        Integer[][] partialArrays = partialsupplier.get();
//        new InsertionSortBenchmarkEvaluation().EvaluateTimeSpent(partialArrays, "partial");
    }
}
