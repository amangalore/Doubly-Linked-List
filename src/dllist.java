
//Aman Mangalore
//aamangal
//cmps 012b
//11/5/14
//dllist.java
//this class creates the linked list
public class dllist {
   int counter;
   public enum position {FIRST, PREVIOUS, FOLLOWING, LAST};
 
   private class node {
      String item;
      node prev;
      node next;
   }
 
   private node first = null;
   private node current = null;
   private node last = null;
   private int currentPosition = 0;
 
   public void setPosition (position pos) {
      //throw new UnsupportedOperationException();
           
          if(pos == position.PREVIOUS && current == first)
          {
        	  throw new java.util.NoSuchElementException();
        	 
          }
          if(pos == position.FOLLOWING && current == last)
          {
        	  throw new java.util.NoSuchElementException();
          }
          if(pos == position.FIRST)
          {
                  current = first;
                  currentPosition = 0;
          }
          if(pos == position.PREVIOUS)
          {
                  current = current.prev;
                  currentPosition--;
          }
          if(pos == position.FOLLOWING)
          {
                  current = current.next;
                  currentPosition++;
          }
          if(pos == position.LAST)
          {
                  current = last;
                  currentPosition = counter;
          }
   }
 
   public boolean isEmpty () {
     // throw new UnsupportedOperationException();
           if(first == null)
                   return true;
           else
                   return false;
   }
 
   public String getItem () {
      //throw new UnsupportedOperationException();
           if(isEmpty())
                   throw new java.util.NoSuchElementException();
           else
           {
        	  return current.item;
           }
   }
 
   public int getPosition () {
      //throw new UnsupportedOperationException();
           if(isEmpty())
                   throw new java.util.NoSuchElementException();
           else
                   return currentPosition;
   }
 
   public void delete () 
   {
	   //throw new UnsupportedOperationException();
       if(isEmpty())
    	   throw new java.util.NoSuchElementException();
       if(current == last)
       {

    	   last = current.prev;
    	   current.next = null;
    	   current.prev = null;
    	   current = last;
       }
       else
       {
    	   if(current == first || current.prev == null)
    	   {
    		   first = current.next;
    		   current.next.prev = null;
    		   current = first;
    	   }
    	   else
    	   {
    		   current.next.prev = current.prev;
    		   current.prev.next = current.next;
    		   current = current.next;
    	   }
       }
   }
 
   public void insert (String item, position pos)
   {
	   
       //throw new UnsupportedOperationException();
       node insert = new node();
       insert.item = item;
       if(isEmpty() && (pos == position.FOLLOWING || pos == position.PREVIOUS))
    	   throw new java.util.NoSuchElementException();
       if(isEmpty() && (pos == position.FIRST || pos == position.LAST))
       {
    	   first = insert;
    	   last = insert;
    	   current = insert;
    	   currentPosition++;
    	   counter++;
    	   return;
       }
       if(pos == position.FIRST)
       {
    	   /*current = first.next;
    	   //code for previous
    	   insert.prev = null;
           insert.next = current;
           first.next = insert;
           current.prev = insert;
           current = current.prev;
           currentPosition--;
           counter++;*/
    	  insert.next = first;
     	  insert.prev = null;
     	  first.prev = insert;
     	  current = insert;
     	  first = insert;
      }
      if(pos == position.PREVIOUS)
      {
    	  insert.prev = current.prev;
          insert.next = current;
          current.prev.next = insert;
          current.prev = insert;
          current = current.prev;
          currentPosition--;
          counter++;
      }
      if(pos == position.FOLLOWING)
      {
    	  if (current == last)
    	  {
    		  insert.prev = last;
        	  insert.next = null;
        	  last.next = insert;
        	  current = insert;
        	  last = insert;
    	  }
    	  else
    	  {
    	  insert.prev = current;
          insert.next = current.next;
          current.next.prev = insert;
          current.next = insert;
          current = insert;
    	  }
          currentPosition++;
          counter++;
      }
      if(pos == position.LAST)
      {
    	  insert.prev = last;
    	  insert.next = null;
    	  last.next = insert;
    	  current = insert;
    	  last = insert;
      }
     
   }
 
}
