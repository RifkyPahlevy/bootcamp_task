import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNG {

    @Test
    public void test1 (){
        System.out.println("ini adalah test 1");
        Assert.assertEquals(1, 1);

    }

    @Test
    public void test2 (){
        System.out.println("ini adalah test 2");
        Assert.assertEquals(2, 2);

    }
}