import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by trile on 21/07/2016.
 */
public class HighestSumsTest {

    private int[][] lists = new int[][]{
            {5, 4, 3, 2, 1},
            {4, 1},
            {5, 0, 0},
            {6, 4, 2},
            {1}
    };

    @Test(expected = NullPointerException.class)
    public void testValidateNullLists() {
        HighestSums.findHighestSums(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateEmptyLists() {
        HighestSums.findHighestSums(new int[0][0], 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateEmptySubList() {
        HighestSums.findHighestSums(new int[1][0], 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNonOrderingSubListNormal() {
        int[][] lists = new int[][]{
                {5, 4, 3, 2, 1},
                {4, 1},
                {5, 6, 0},
                {6, 4, 2},
                {1}
        };
        HighestSums.findHighestSums(lists, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNonOrderingSubListEnd() {
        int[][] lists = new int[][]{
                {5, 4, 3, 2, 100},
                {4, 1},
                {5, 1, 0},
                {6, 4, 2},
                {1}
        };
        HighestSums.findHighestSums(lists, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNonOrderingSubListStart() {
        int[][] lists = new int[][]{
                {0, 4, 3, 2, 1},
                {4, 1},
                {5, 1, 0},
                {6, 4, 2},
                {1}
        };
        HighestSums.findHighestSums(lists, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNNegative() {
        HighestSums.findHighestSums(new int[1][1], -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateNEqualsMinInteger() {
        HighestSums.findHighestSums(new int[1][1], Integer.MIN_VALUE);
    }

    @Test
    public void testFindHighestSum_NEquals0() {
        List actual = Arrays.asList();
        Assert.assertEquals(HighestSums.findHighestSums(lists, 0), actual);
    }

    @Test
    public void testFindHighestSumNqEuals1() {
        List actual = Arrays.asList(21);
        Assert.assertEquals(HighestSums.findHighestSums(lists, 1), actual);
    }

    @Test
    public void testFindHighestSumNqEuals5() {
        List actual = Arrays.asList(21, 20, 19, 19, 18);
        Assert.assertEquals(HighestSums.findHighestSums(lists, 5), actual);
    }

    @Test
    public void testFindHighestSumNEquals90() {
        List actual = Arrays.asList(21, 20, 19, 19, 18, 18, 18, 17, 17, 17, 17, 16, 16, 16, 16, 16, 16, 15, 15, 15, 15, 15, 15, 14, 14, 14, 14, 14, 14, 14, 14, 13, 13, 13, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 9, 9, 9, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8, 7, 7, 7, 7, 6, 6, 5, 5);
        Assert.assertEquals(HighestSums.findHighestSums(lists, 90), actual);
    }

    @Test
    public void testFindHighestSumNEquals91() {
        List actual = Arrays.asList(21, 20, 19, 19, 18, 18, 18, 17, 17, 17, 17, 16, 16, 16, 16, 16, 16, 15, 15, 15, 15, 15, 15, 14, 14, 14, 14, 14, 14, 14, 14, 13, 13, 13, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 9, 9, 9, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8, 7, 7, 7, 7, 6, 6, 5, 5);
        Assert.assertEquals(HighestSums.findHighestSums(lists, 91), actual);
    }

    @Test
    public void testFindHighestSumNEqualsMaxInteger() {
        List actual = Arrays.asList(21, 20, 19, 19, 18, 18, 18, 17, 17, 17, 17, 16, 16, 16, 16, 16, 16, 15, 15, 15, 15, 15, 15, 14, 14, 14, 14, 14, 14, 14, 14, 13, 13, 13, 13, 13, 13, 13, 13, 13, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 11, 11, 11, 11, 11, 11, 11, 11, 11, 10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 9, 9, 9, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8, 7, 7, 7, 7, 6, 6, 5, 5);
        Assert.assertEquals(HighestSums.findHighestSums(lists, Integer.MAX_VALUE), actual);
    }
}
