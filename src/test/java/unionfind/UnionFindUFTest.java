package unionfind;

import org.junit.Assert;
import org.junit.Test;

public class UnionFindUFTest {

    @Test
    public void test1(){
        QuickFindUF uf = new QuickFindUF(10);
        uf.union(4,3);
        uf.union(3,8);
        uf.union(6,5);
        uf.union(9,4);
        uf.union(2,1);
        Assert.assertTrue(uf.connected(8,9));
        Assert.assertFalse(uf.connected(0,9));
        Assert.assertFalse(uf.connected(0,5));
        uf.union(5, 0);
        uf.union(7,2);
        uf.union(6, 1);
        Assert.assertTrue(uf.connected(0,5));
    }
}
