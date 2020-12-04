package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] array;

    public ArrayUtility(T[] inputArray) {
        this.array = inputArray;
    }

    public T[] removeValue(T valueToRemove) {
        T[] tempArray = Arrays.copyOf(array, array.length - getNumberOfOccurrences(valueToRemove));

        int j =0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != valueToRemove) {
                    tempArray[j] = array[i];
                    j++;
            }



        }
        return tempArray;
    }

    public T[] mergeArray(T[] arrayToMerge){
        List list = new ArrayList<T>(Arrays.asList(array));
        list.addAll(Arrays.asList(arrayToMerge));
        T[] merged = (T[]) list.toArray();
        return merged;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
       array = mergeArray(arrayToMerge);

        Integer dupes = getNumberOfOccurrences(valueToEvaluate);
        // count duplicates array



        return dupes;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToEvaluate) {
                count++;
            }

        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        array = mergeArray(arrayToMerge);
        HashMap<T, T> elementCountMap = new HashMap<T,T>();
        for (T i : array){
            Integer value = HashMap.get(i);

        }
        return null;
    }

//        public T getMostCommonFromMerge (T[] arrayToMerge){
//            return (T) arrayToMerge;
//        }
//    }
}
