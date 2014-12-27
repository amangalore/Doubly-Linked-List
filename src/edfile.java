
//Aman Mangalore
//aamangal
//cmps 012b
//11/5/14
//edfile.java
//this is the main class that runs the linkedlist
import java.util.Scanner;

import static java.lang.System.*;

import java.io.*;
import java.util.ArrayList; 
 
class edfile{
        public int variable;
        public static dllist linkedlist = new dllist();
        static int size;
        static int ctr;
   public static void main (String[] args) throws IOException {
          System.out.println("Welcome to my line oriented text editor.");
          boolean want_echo = false;
          //check the arguments entered by the user
          if(args.length > 2)
        	  auxlib.usage(args);
          else if(args.length == 1 && args[0].equals("-e"))
        	  want_echo = true;
          else if(args.length == 1)
          {
        	  want_echo = false;
        	  readFile(args[0], 0);
          }
          else if(args.length == 2 && args[0].equals("-e"))
          {
        	  want_echo = true;
        	  readFile(args[1], 0);
          }
          else if(args.length == 0)
        	  want_echo = false;       	  
      //scan user input
      Scanner stdin = new Scanner (in);
      for (;;) {
         if (! stdin.hasNextLine()) break;
         String inputline = stdin.nextLine();
         if (want_echo) 
        	 out.printf ("%s%n", inputline);
         if (inputline.matches ("^\\s*$")) 
        	 continue;
         char command = inputline.charAt(0);
         //do something depending on what is scanned
         switch (command) {
            case '#':
                break;
            case '$':
            	linkedlist.setPosition(dllist.position.LAST);
            	System.out.println(linkedlist.getItem());
              //  auxlib.STUB ("Call $ command function.");
            break;
            case '*':
            	linkedlist.setPosition(dllist.position.FIRST);
            	for (int i = 0; i < size; i++)
            	{
            		System.out.println(linkedlist.getItem());
            		if(!(i == size -1))
            			linkedlist.setPosition(dllist.position.FOLLOWING);
            	}
            	linkedlist.setPosition(dllist.position.LAST);
              //  auxlib.STUB ("Call * command function.");
            break;
            case '.':
            	System.out.println(linkedlist.getItem());
              //  auxlib.STUB ("Call . command function.");
            break;
            case '0':
            	linkedlist.setPosition(dllist.position.FIRST);
            	System.out.println(linkedlist.getItem());
              //  auxlib.STUB ("Call 0 command function.");
            break;
            case '<':
            	linkedlist.setPosition(dllist.position.PREVIOUS);
            	System.out.println(linkedlist.getItem());
             //   auxlib.STUB ("Call < command function.");
            break;
            case '>':
            	linkedlist.setPosition(dllist.position.FOLLOWING);
            	System.out.println(linkedlist.getItem());
               // auxlib.STUB ("Call > command function.");
            break;
            case 'a':
            	String str5 = inputline.substring(2);
            	linkedlist.insert(str5, dllist.position.FOLLOWING);
            	System.out.println(linkedlist.getItem());
            	size++;
              //  auxlib.STUB ("Call a command function.");
            break;
            case 'd':
            	linkedlist.delete();
            	size--;
               // auxlib.STUB ("Call d command function.");
            break;
            case 'i':
            	String str6 = inputline.substring(2);
            	linkedlist.insert(str6, dllist.position.PREVIOUS);
            	System.out.println(linkedlist.getItem());
            	size++;
              //  auxlib.STUB ("Call i command function.");
            break;
            case 'r':
            	String str7 = inputline.substring(2);
            	readFile(str7, 1);
            	System.out.println(ctr + " newly inserted lines.");
               // auxlib.STUB ("Call r command function.");
            break;
            case 'w':
            	String str8 = inputline.substring(2);
            	PrintWriter writer = new PrintWriter(str8, "UTF-8");
            	if(str8.equals("") || linkedlist.isEmpty())
            		System.out.println("File cannot be created or written.");
            	else
            	{
            		linkedlist.setPosition(dllist.position.FIRST);
	            	for (int i = 0; i < size; i++)
	            	{
	            		writer.println(linkedlist.getItem());
	            		if(!(i == size -1))
	            			linkedlist.setPosition(dllist.position.FOLLOWING);
	            	}
            	}
		writer.close();
            	System.out.println(size + " number of lines written to the file " + str8);
            
                break;
            default :
                auxlib.STUB ("Print invalid command.");
                break;
         }
      }
      //auxlib.STUB ("(eof)");
      auxlib.die(args);
   }
   //read the file and put it in a linked list
   public static void readFile(String file, int z) throws IOException{
        
           BufferedReader reader = new BufferedReader(new FileReader(file));
           String str;
           int x = z;
           ctr = 0;
           while( (str = reader.readLine() )!= null)
           {
                
        	   if(x == 0)
        	   {
        		   linkedlist.insert(str,dllist.position.FIRST);
        		   x++;
        	   }
        	   else
        	   {
        		  
        		   linkedlist.insert(str,dllist.position.FOLLOWING);    
        		 
        	   }
           size++;
           ctr++;
           }  
           reader.close();
   }
   
   
}
