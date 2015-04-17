import junit.framework.Assert;
import junit.framework.TestCase;

public class LeetCodeTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testMain() throws Exception {

    }

    public void testIsValid() throws Exception {

    }

    public void testCountAndSay() throws Exception {

        LeetCode leetCode = new LeetCode();
        Assert.assertEquals("21",leetCode.countAndSay(3));

    }

    public void testCreateNewSeqMember() throws Exception {

        LeetCode leetCode = new LeetCode();
        Assert.assertEquals("11",leetCode.createNewSeqMember("1"));
    }


    public void testTrailingZeroes() throws Exception {

    }

    public void testTitleToNumber() throws Exception {
        LeetCode leetCode = new LeetCode();
        Assert.assertEquals(703, leetCode.titleToNumber("AAA"));
    }

    public void testFindIndexOfLetter() throws Exception {

    }

    public void testConvertToTitle() throws Exception {
        LeetCode leetCode = new LeetCode();
        Assert.assertEquals("ZZ", leetCode.convertToTitle(702));

    }

    public void testMajorityElement() throws Exception {
        LeetCode leetCode = new LeetCode();
        int [] num = {1,3,1,4,5,2,2,5};
        //Assert.assertEquals(0, leetCode.majorityElement(num));
    }

    public void testCompareVersion() throws Exception {
        LeetCode leetCode = new LeetCode();
        System.out.print(leetCode.compareVersion("2.0", "02"));
    }
}