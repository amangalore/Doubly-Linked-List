
//Aman Mangalore
//aamangal
//cmps 012b
//11/5/14
//dllistTest.java
//this class tests all the cases for the linkedlist class
import org.junit.*;
import static org.junit.Assert.assertEquals;
 
public class dllistTest {
 
    @Test
    public void startsEmptyTest() {
        dllist lst = new dllist();
        assertEquals(true, lst.isEmpty());
    }
    
    @Test
    public void startsEmptyTest2() {
        dllist lst = new dllist();
        lst.insert("jj", dllist.position.FIRST);
        assertEquals(false, lst.isEmpty());
    }
    
    @Test
    public void insertendTest() {
        dllist lst = new dllist();
        lst.insert("1", dllist.position.LAST);
        lst.insert("2", dllist.position.LAST);
        assertEquals("2", lst.getItem());
    }
    
    @Test
    public void insertfrontTest() {
        dllist lst = new dllist();
        lst.insert("3", dllist.position.FIRST);
        lst.insert("4", dllist.position.FIRST);
        assertEquals("4", lst.getItem());
    }
    
    @Test
    public void setposTest() {
        dllist lst = new dllist();
        lst.insert("5", dllist.position.LAST);
        lst.insert("6", dllist.position.LAST);
        lst.setPosition(dllist.position.FIRST);
        assertEquals("5", lst.getItem());
    }
    
    @Test
    public void abc1Test() {
        dllist lst = new dllist();
        lst.insert("A", dllist.position.LAST);
        lst.insert("B", dllist.position.LAST);
        lst.insert("C", dllist.position.LAST);
        lst.insert("D", dllist.position.PREVIOUS);
        lst.setPosition(dllist.position.LAST);
        assertEquals("C", lst.getItem());
    }
    
    @Test
    public void abc2Test() {
        dllist lst = new dllist();
        lst.insert("A", dllist.position.FIRST);
        lst.insert("B", dllist.position.FIRST);
        lst.insert("C", dllist.position.FIRST);
        lst.insert("D", dllist.position.FOLLOWING);
        lst.setPosition(dllist.position.FIRST);
        assertEquals("C", lst.getItem());
    }
    
    @Test
    public void randomTest1() {
        dllist lst = new dllist();
        lst.insert("5", dllist.position.FIRST);
        lst.insert("3", dllist.position.LAST);
        lst.insert("4", dllist.position.PREVIOUS);
        lst.insert("1", dllist.position.FIRST);
        assertEquals("1", lst.getItem());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals("5", lst.getItem());
        lst.setPosition(dllist.position.FOLLOWING);
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals("3", lst.getItem());
        lst.setPosition(dllist.position.PREVIOUS);
        assertEquals("4", lst.getItem());
    }
    
    @Test
    public void randomTest2() {
        dllist lst = new dllist();
        lst.insert("5", dllist.position.FIRST);
        lst.insert("3", dllist.position.LAST);
        lst.insert("4", dllist.position.PREVIOUS);
        lst.insert("1", dllist.position.FIRST);
        assertEquals(0, lst.getPosition());
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals(1, lst.getPosition());
        lst.setPosition(dllist.position.FOLLOWING);
        lst.setPosition(dllist.position.FOLLOWING);
        assertEquals(3, lst.getPosition());
        lst.setPosition(dllist.position.PREVIOUS);
        assertEquals(2, lst.getPosition());
    }
    
    @Test
    public void deleteTest() {
        dllist lst = new dllist();
        lst.insert("1", dllist.position.FIRST);
        lst.insert("2", dllist.position.FOLLOWING);
        lst.insert("3", dllist.position.FOLLOWING);
        lst.insert("4", dllist.position.FOLLOWING);
        lst.delete();
        assertEquals("3", lst.getItem());
    }
    
    @Test(expected = Exception.class)
    public void insertemptyfollowingTest()
    {
    	dllist lst = new dllist();
        lst.insert("2", dllist.position.FOLLOWING);
    }
    
    @Test(expected = Exception.class)
    public void insertemptypreviousTest()
    {
    	dllist lst = new dllist();
        lst.insert("2", dllist.position.PREVIOUS);
    }
    
    @Test(expected = Exception.class)
    public void currentfirstpreviousTest()
    {
    	dllist lst = new dllist();
    	lst.insert("2", dllist.position.FIRST);
        lst.setPosition(dllist.position.PREVIOUS);
    }
    
    @Test(expected = Exception.class)
    public void currentlastfollowingTest()
    {
    	dllist lst = new dllist();
    	lst.insert("2", dllist.position.LAST);
        lst.setPosition(dllist.position.FOLLOWING);
    }
    
    @Test(expected = Exception.class)
    public void isemptyTest()
    {
    	dllist lst = new dllist();
    	lst.getItem();
    }
    
    @Test(expected = Exception.class)
    public void getpositionTest()
    {
    	dllist lst = new dllist();
    	lst.getPosition();
    }
    
    @Test(expected = Exception.class)
    public void deleteemptyTest()
    {
    	dllist lst = new dllist();
    	lst.delete();
    }
    
    
}
