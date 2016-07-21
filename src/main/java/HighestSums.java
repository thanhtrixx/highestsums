import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class help to find the n largest sums amongst all the combinations of picking an integer
 * from each list, where n is some positive value
 *
 * @author trile
 */
public class HighestSums {

    /**
     * Validate input
     *
     * @param lists A 2 dimensional array which each sub array is non-increasing integer array
     * @param n     number of largest sums
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    private static void validate(int[][] lists, int n) throws IllegalArgumentException, NullPointerException {
        Validate.notEmpty(lists, "Lists is null or empty");
        Validate.isTrue(n >= 0, "Number highest sums must is a positive integer");

        // validate ordering and sub list empty
        for (int[] subList : lists) {
            Validate.isTrue(subList.length > 0, "Sub list empty");
            for (int i = 1; i < subList.length; i++) {
                Validate.isTrue(subList[i - 1] >= subList[i], "Sub list does not order");
            }
        }
    }

    /**
     * Find the n largest sums amongst all the combinations of picking an integer from each list,
     * where n is some positive value. For example if n is 1, then you are simply expected to find the sum
     * that can be created by adding together the highest integers in all the lists.
     * If there are not n largestsums available (i.e. n is larger than the number of combinations of all list entries),
     * you should return as many sums as possible. In any case, the result may contain duplicate entries.
     *
     * @param lists A 2 dimensional array which each sub array is non-increasing integer array
     * @param n     number of largest sums
     * @return highest sums list
     */
    public static List findHighestSums(int[][] lists, int n) {
        // validate input
        validate(lists, n);
        List result;
        // in case n = 0 then return empty list
        if (n == 0) {
            result = new ArrayList(0);
            return result;
        }
        // in case n = 1 then get first item of each sub list
        if (n == 1) {
            result = new ArrayList(1);
            result.add(getHighestSum(lists));
            return result;
        }
        // in other case then get all available sums
        int combinationsNumber = findCombinationsNumber(lists);
        int resultListSize = combinationsNumber > n ? n : combinationsNumber;
        result = new ArrayList(resultListSize);
        int[] sortedSums = getSortedSums(lists, combinationsNumber);
        for (int i = 0; i < resultListSize; i++) {
            result.add(sortedSums[i]);
        }
        return result;
    }

    private static int getHighestSum(int[][] lists) {
        int sum = 0;
        for (int[] subList : lists) {
            sum += subList[0];
        }
        return sum;
    }

    /**
     * Find the max combinations number of input lists
     *
     * @param lists A 2 dimensional array
     * @return the max combinations number
     */
    private static int findCombinationsNumber(int[][] lists) {
        int combinationsNumber = 1;
        for (int[] subList : lists) {
            combinationsNumber *= subList.length;
        }
        return combinationsNumber;
    }

    /**
     * @param lists              A 2 dimensional array
     * @param combinationsNumber the max combinations number of input lists
     * @return a sorted sums array
     */
    private static int[] getSortedSums(int[][] lists, int combinationsNumber) {
        int[] result = new int[combinationsNumber];

        // copy first list to result list
        int resultSize = lists[0].length;
        System.arraycopy(lists[0], 0, result, 0, resultSize);
        // copy and add each item in other list to result list
        for (int i = 1; i < lists.length; i++) {
            int[] currentList = lists[i];
            // if current size >= 2 then copy result list
            for (int j = 1; j < currentList.length; j++) {
                System.arraycopy(result, 0, result, resultSize * j, resultSize);
            }
            // add each item in current list to result list
            for (int j = 0; j < currentList.length; j++) {
                for (int k = 0; k < resultSize; k++) {
                    result[resultSize * j + k] += currentList[j];
                }
            }
            // update size of result list
            resultSize *= currentList.length;

        }
        // sort descending
        Arrays.sort(result);
        ArrayUtils.reverse(result);

        return result;
    }

}
