package sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TestMaxPriorityQueue {
    private static final Character[] INITIAL = new Character[]{null, 'T', 'P', 'R', 'N', 'H', 'O', 'A', 'E', 'I', null};

    @Test
    public void test(){
        MaxPriorityQueue<Character> queue = new MaxPriorityQueue<>(10);
        for(int i=1;i<INITIAL.length-1;i++){
            queue.insert(INITIAL[i]);
        }
        Assert.assertTrue(!queue.isEmpty());
        Assert.assertTrue("E : " + Arrays.toString(INITIAL)
                +"\r\nA : "+ Arrays.toString(queue.getUnderlyingArray()),Arrays.equals(INITIAL, queue.getUnderlyingArray()));

    }
}
