package structures;

import java.util.Arrays;

public class AlgorithmsDataStructures2 {
    public static int[] GenerateBBSTArray(int[] a)
    {
        Arrays.sort(a);
        int[] result = new int[a.length];
        generateBBSTArray(a, result, 0, a.length - 1, 0);

        return result ;
    }

    public static void generateBBSTArray(int[] sourceArray, int[] resultArray, int startIndex, int endIndex, int index) {
        if (startIndex > endIndex) {
            return;
        }
        int middleIndex = (startIndex + endIndex + 1) / 2;
        resultArray[index] = sourceArray[middleIndex];
        int leftIndex = index*2+1;
        int rightIndex = index*2+2;
        if (leftIndex < resultArray.length) {
            generateBBSTArray(sourceArray, resultArray, startIndex, middleIndex - 1, leftIndex);
        }
        if (rightIndex < resultArray.length) {
            generateBBSTArray(sourceArray, resultArray, middleIndex + 1, endIndex, rightIndex);
        }
    }
}
