package edu.ucsb.cs56.projects.games.memorycard;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The test class MemoryGameTest - tests the MemoryGame class
 * @author Bryce McGaw and Jonathan Yau
 * @version 1.0.0 5/14/2012
 * @author Mathew Glodack, Christina Morris
 * @version cs56, S13, 5/13/2013
*/
public class MemoryGameTest
{
    /**Test case for testConstructor01()
     * 
     */
	@Test public void testConstructor01()
	{
	    //counter to check if count at end is (size/2)-1 ((size/2) nums)
	    int count=0;
	    // make new grid
	    MemoryGrid test1 = new MemoryGrid();
	    // test that not more than 2 squares share the same num
	    MemoryCard testMem = new MemoryCard();
	    for(int i=1; i<(test1.size/2); i++){
		testMem.setVal(i);
		if(test1.contains2(testMem)){
		    count++;
		}
	    }
	    assertEquals(count,((test1.size/2)-1));
            
	}

    /**Test case for testRandom()
     *
     */
        @Test public void testRandom()
        {
	    //int to increment for each similar value
            int i=0,j=0; 
            //two grids to compare
            MemoryGrid test1 = new MemoryGrid();
            MemoryGrid test2 = new MemoryGrid();
            MemoryCard temp2 = test2.memGrid.get(j);
            for(MemoryCard temp: test1.memGrid){
                if(temp.getVal()==temp2.getVal())
                    i++;
		j++;
		if(j<test1.size)
                    temp2 = test2.memGrid.get(j);
            }
            assertFalse(i==test1.size/2);
        }

    /**Test case for testEquals()
     *
     */
    @Test public void testEquals()
    {
	//two memory cards initialized to see if Equals works
	MemoryCard t1 = new MemoryCard(4);
	MemoryCard t2 = new MemoryCard(4);
	assertTrue(t2.Equals(t1));
    }

    /**Test case for testisOneFlipped()
     *
     */
    @Test public void testisOneFlipped()
    {
	MemoryGrid t1 = new MemoryGrid();
	t1.memGrid.get(4).flip();
	assertTrue(t1.isOneFlipped());
    }

    /**Test case for testisTwoFlipped()
     *
     */
    @Test public void testisTwoFlipped()
    {
	MemoryGrid t1 = new MemoryGrid();
	t1.memGrid.get(1).flip();
	t1.memGrid.get(6).flip();
	assertTrue(t1.isTwoFlipped());
    }

    /**Test case for testgetFlipped()
     *
     */
    @Test public void testgetFlipped()
    {
	MemoryGrid t1 = new MemoryGrid();
	t1.memGrid.get(13).flip();
	assertEquals(t1.getFlipped(), 13);
    }
    
    /**Test case for testgetFlipped2()
     *
     */
    @Test public void testgetFlipped2()
    {
	MemoryGrid t1 = new MemoryGrid();
	t1.memGrid.get(10).flip();
	t1.memGrid.get(4).flip();
	assertEquals(t1.getFlipped(10), 4);
    }
    
    /**Test case for testisOver()
     *
     */   
    @Test public void testisOver()
    {
	MemoryGrid t1 = new MemoryGrid();
	t1.isOver=true;
	assertEquals(t1.isOver(), true);
    }
}
