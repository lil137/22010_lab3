import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  Yuxiao Hu(19321099)
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
	@Test
	public void Testput() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(7, 7);
		bst.put(7, null);
		assertEquals("()",bst.printKeysInOrder());
		
		bst.put(7, 7);
		bst.put(7, 2);
		
		//Integer val = bst.get(7);
		Integer exp = 2;
		assertEquals(exp, (bst.get(7)));		
		assertEquals("(()7())",bst.printKeysInOrder());
		
	}
	
	@Test
	public void Testselect() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals(null,bst.select(0));
		
		bst.put(7, 7);
			
	    bst.put(3, 3); 
	    assertEquals(3,(int)bst.select(0));
	    
	    bst.put(8, 8); 
	    bst.put(1, 1); 
	    bst.put(2, 2);      
	    bst.put(6, 6);     
	    bst.put(4, 4);       
	    bst.put(5, 5); 
	    assertEquals(null,bst.select(-1));
	    assertEquals(null,bst.select(bst.size()));
	    assertEquals(8,(int)bst.select(7));
	    
	    assertEquals(5,(int)bst.select(4));
	    assertEquals(4,(int)bst.select(3));
	    assertEquals(3,(int)bst.select(2));
	    assertEquals(6,(int)bst.select(5));
	    assertEquals(7,(int)bst.select(6));
	    assertEquals(2,(int)bst.select(1));
	   
		
	}
	
	
	
  //TODO write more tests here.
	@Test
	public void Testheight() {
		 BST<Integer, Integer> bst = new BST<Integer, Integer>();
		 assertEquals(-1,bst.height());
		 
		 bst.put(7, 7);
		 assertEquals(0,bst.height());
		 
		 bst.put(8, 8); 
		 assertEquals(1,bst.height());
	     bst.put(3, 3);      
	     bst.put(1, 1); 
	     assertEquals(2,bst.height());
	     bst.put(2, 2);      
	     bst.put(6, 6);     
	     bst.put(4, 4);       
	     bst.put(5, 5); 
	     assertEquals(4,bst.height());
		 
	}
	
	@Test
	public void Testmedian() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals(null,bst.median());
		
		bst.put(7, 7);
		assertEquals(7,(int)bst.median());
		
		bst.put(8, 8); 
		assertEquals(7,(int)bst.median());
		
		bst.put(3, 3); 
		assertEquals(7,(int)bst.median());
		
		bst.put(1, 1); 
		bst.put(2, 2); 
		assertEquals(3,(int)bst.median());
		
		
	}
	
	@Test 
	public void testprintKeysInOrder() {
		BST<String, Integer> bst = new BST<String, Integer>();
		String test1 = "()";
		assertEquals(test1,bst.printKeysInOrder());
		
		bst.put("B",1);
		String test2 = "(()B())";
		assertEquals(test2,bst.printKeysInOrder());
		
		bst.put("A", 2);
		bst.put("C", 3);
		bst.put("D", 4);
		String test3 = "((()A())B(()C(()D())))";
		assertEquals(test3,bst.printKeysInOrder());
		
		
		BST<String, Integer> bst1 = new BST<String, Integer>();
		bst1.put("S", 1);
		bst1.put("E", 1);
		bst1.put("A", 1);
		bst1.put("C", 1);
		bst1.put("R", 1);
		bst1.put("H", 1);
		bst1.put("M", 1);
		bst1.put("X", 1);
		String test4= "(((()A(()C()))E((()H(()M()))R()))S(()X()))";
		assertEquals(test4,bst1.printKeysInOrder());
		
	}

  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
	@Test
	public void testPrettyPrint() {
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     String test1 = "-7\n" +
    		 		" |-null\n" +
    		 		"  -null\n";
     assertEquals(test1,bst.prettyPrintKeys());
     bst.put(8, 8);       //   | |   |-null
     String test2= "-7\n" +
		 			" |-null\n" +
		 			"  -8\n" +
		 			"   |-null\n" +
		 			"    -null\n";
     assertEquals(test2,bst.prettyPrintKeys());
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   // 
         bst.delete(7);
         assertEquals("()", bst.printKeysInOrder());
         bst.put(7, 7);
         bst.put(3, 3);  
         bst.delete(3);
         assertEquals("(()7())", bst.printKeysInOrder());
         bst.put(3, 3);
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
         
         
         BST<Integer, Integer> bst1 = new BST<Integer, Integer>();
         bst1.put(7, 7);  
         bst1.put(20, 20);  
         bst1.put(3, 3);
         bst1.put(13, 13);
         bst1.put(4, 4);
         bst1.put(5, 5);
         bst1.put(15, 15);
         bst1.delete(13);
         assertEquals("((()3(()4(()5())))7((()15())20()))", bst1.printKeysInOrder());
         bst1.delete(4);
         assertEquals("((()3(()5()))7((()15())20()))", bst1.printKeysInOrder());
         bst1.delete(3);
         assertEquals("((()5())7((()15())20()))", bst1.printKeysInOrder());
         bst1.put(10, 10);
         bst1.delete(15);
         assertEquals("((()5())7((()10())20()))", bst1.printKeysInOrder());
         bst1.put(3, 3);
         bst1.delete(7);
         assertEquals("((()3())5((()10())20()))", bst1.printKeysInOrder());
         
         BST<Integer, Integer> bst2 = new BST<Integer, Integer>();
         bst2.put(7, 7);  
         bst2.put(3, 3);
         bst2.delete(7);
         assertEquals("(()3())", bst2.printKeysInOrder());
         bst2.put(4, 4);
         bst2.delete(3);
         assertEquals("(()4())", bst2.printKeysInOrder());
         bst2.put(1, 1);
         bst2.put(2, 2);
         bst2.put(5, 5);
         bst2.delete(4);
         assertEquals("((()1())2(()5()))", bst2.printKeysInOrder());
         
         
         BST<Integer, Integer> bst3= new BST<Integer, Integer>();
         bst3.put(7, 7);
         bst3.put(3, 3);
         bst3.put(1, 1);
         bst3.put(5, 5);
         bst3.put(4, 4);
         bst3.put(20, 20);
         bst3.delete(3);
         assertEquals("((()1((()4())5()))7(()20()))", bst3.printKeysInOrder());

         BST<Integer, Integer> bst4= new BST<Integer, Integer>();
         bst4.put(7, 7);
         bst4.put(6, 6);
         bst4.put(1, 1);
         bst4.put(2, 2);
         bst4.put(4, 4);
         bst4.put(3, 3);
         bst4.put(20, 20);
         bst4.delete(6);
         assertEquals("((()1(()2((()3())4())))7(()20()))", bst4.printKeysInOrder());
         
        
     }
     
     @Test
     public void TestgetKey() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals(null,bst.getKey(1));
     }
     
     @Test
     public void TestgetParent() {
    	 BST<Integer, Integer> bst = new BST<Integer, Integer>();
    	 assertEquals(null,bst.getParent(7));
    	 bst.put(7, 7); 
    	 bst.put(8, 8);
    	 //assertEquals(7,bst.getParent(8).getNode().getKey());
     }
     
   
}
