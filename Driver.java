import java.io.*;

import java.util.*;



public class Driver {



   

   // takes a 1 digit integer number

   // returns a char array of each possible letter for that number

   public static char[] letter(int number)

   {

      char[] letters = new char[4];

      switch (number)

      {

         case 0:

            letters[0] = ' ';

            letters[1] = ' ';

            letters[2] = ' ';

            letters[3] = ' ';

            break;

         case 1:

            letters[0] = ' ';

            letters[1] = ' ';

            letters[2] = ' ';

            letters[3] = ' ';

            break;

         case 2:

            letters[0] = 'a';

            letters[1] = 'b';

            letters[2] = 'c';

            letters[3] = ' ';

            break;

         case 3:

            letters[0] = 'd';

            letters[1] = 'e';

            letters[2] = 'f';

            letters[3] = ' ';

            break;

         case 4:

            letters[0] = 'g';

            letters[1] = 'h';

            letters[2] = 'i';

            letters[3] = ' ';

            break;

         case 5:

            letters[0] = 'j';

            letters[1] = 'k';

            letters[2] = 'l';

            letters[3] = ' ';

            break;

         case 6:

            letters[0] = 'm';

            letters[1] = 'n';

            letters[2] = 'o';

            letters[3] = ' ';

            break;

         case 7:

            letters[0] = 'p';

            letters[1] = 'q';

            letters[2] = 'r';

            letters[3] = 's';

            break;

         case 8:

            letters[0] = 't';

            letters[1] = 'u';

            letters[2] = 'v';

            letters[3] = ' ';

            break;

         case 9:

            letters[0] = 'w';

            letters[1] = 'x';

            letters[2] = 'y';

            letters[3] = 'z';

            break;

       }

      return letters;

   }

   

   // Takes a int array (10 digit base 4 number)

   // increaes it by one and returns the array

   public static int[] increase(int nums[])

   {

   	int n = 9;

   	int x = nums[n];

      

      // Iterates through until the current can be increased 

   	while (x == 3)

   	{

   		// Sets all previous digits to 0 so that the number only increases by 1

   		for (int i = n; i < 10; i++)

   			nums[i] = 0;

   		n -= 1;

   		x = nums[n];

   	}

   	

      // Increases the number by 1

   	nums[n] += 1;

   

   

   	return nums;

}

   



  public static String[]  words(String num, int[] bin)

   {

      char[] value = new char[10];

            

      // 4^10 = 1048576

      // Every possible combination of letters given the input of 10 numbers

      String[] v = new String[1048576];

      int k = 0;

      for (int j = 0; j < 1048575; j++)

      {

         for (int i = 0; i < 10; i++)

         {

            value[i]  = letter(Integer.parseInt(num.substring(i,i+1)))[bin[i]];

         }

         bin = increase(bin);

         v[j] = String.valueOf(value);

      }      

      

      return v;      

     

   }



	public static void main(String[] args) throws IOException {

		FileReader fileReader = null;

        BufferedReader bufferedReader = null;

		String content = new String();

		int count=1;

		LinkedList<String> list = new LinkedList<String>();

      

      HashSet<String> table = new HashSet<String>();

      



		try {
      
            // change file to the file location of words on your computer
            File folder = new File("C:/Users/Austin/Desktop/Data Structure and Algorithm Analysis/Projects/CS421 Project 2/words");

            if (folder.isDirectory()) {

                for (File file : folder.listFiles()) {

                    fileReader = new FileReader(file);

                    bufferedReader = new BufferedReader(fileReader);

                    String line = null;

                    int lineCount = 0;

                    while (null != (line = bufferedReader.readLine())) {

                        lineCount++;

                        if (0 != lineCount) {

                            list.add(line);

                        }

                    }

                }

            }

        }

		catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (null != bufferedReader)

                try {

                    bufferedReader.close();

                } catch (IOException e) {

                    e.printStackTrace();

                }

        }

		

			Iterator i = list.iterator();

         

         String c;

         

         int[] numbers = new int[10];

         for (int z = 0; z<10; z++)

         {

            numbers[z] = 0;

         }

            

         

			while (i.hasNext()) {

			   c = i.next().toString();

            table.add(c);

           			}

             int[] b = new int[10];

             

            for (int z = 0; z < 10; z++)

               b[z] = 0;

               

           String input = " ";



           Scanner reader = new Scanner(System.in);
           System.out.print("Enter a 10 digit phone number (without dashes): 1-");
           input = reader.next();
           

           while(input.length() != 10){

               System.out.print("Not a 10 digit number. Enter a 10 digit phone number (without dashes): 1-");

               input = reader.next();

               

           }

           

               

               

               

            String[] yellow = words(input, b);

            // Sets that store the found words

            HashSet<String> set0 = new HashSet<String>();

            HashSet<String> set1 = new HashSet<String>();

            HashSet<String> set2 = new HashSet<String>();

            HashSet<String> set3 = new HashSet<String>();

            // Variables to store which type of result has been found

            // Prevents code from running if result from a higher tier has been already found

            boolean t0 = true;

            boolean t1 = true;

            boolean t2 = true;

            boolean t3 = true;



            

            for (int j = 0; j < 1048575; j++)

            {

            

               /*Tier 0*/

               //entire word matches

                if (table.contains(yellow[j]))

               {

                  set0.add("1-"+yellow[j]);  

                  t1 = false;

                  t2 = false;

                  t3 = false;

 

               }

               

               

               /*Tier 1*/

               // Exhange and number match as one word

               if(t1)

               {
        
                  if (table.contains(yellow[j].substring(3,10)))

                  {

                     set1.add("1-"+input.substring(0,3)+"-"+yellow[j].substring(3,10));

                     t2 = false;

                     t3 = false;

  

                    

                  }

               }

               

               /*Tier 2*/

               if(t2)

               {

                   // Exchange and numbers match as two words

                  if(table.contains(yellow[j].substring(3,6)))

                     if (table.contains(yellow[j].substring(6,10)))

                     {

                        set2.add("1-"+input.substring(0,3)+"-"+yellow[j].substring(3,6)+"-"+yellow[j].substring(6,10));

                        t3 = false;

                     }

                 }

                  

            

               /*Tier 3*/

               //Only exchange matches

               if(t3 == true)

               {

                  if (table.contains(yellow[j].substring(3,6)))

                  {

                    

                     set3.add("1-"+input.substring(0,3)+"-"+yellow[j].substring(3,6)+"-"+input.substring(6,10));

                    

                  }

                  // Only number matches

                  if (table.contains(yellow[j].substring(6,10)))

                     {

                        set3.add("1-"+input.substring(0,3)+"-"+input.substring(3,6)+"-"+yellow[j].substring(6,10));

                     }

                }



            

         

                  

            }   

            // Prints 10 letter words

            for (String s : set0) 

            {

               System.out.println(s.toUpperCase());

            }

            

            // Prints 7 letter words if 10 are not possible

            if (set0.size() == 0)

               for (String s : set1) 

               {

                  System.out.println(s.toUpperCase());

               }

            // Prints exchange and number if 10 or 7 letter words not possible

            if (set0.size() == 0)

               if(set1.size() == 0)

                  for (String s : set2) 

                  {

                     System.out.println(s.toUpperCase());

                  } 

                  

            // Prints number or exchange if that is all that is possible

            if (set0.size() == 0)

               if (set1.size() == 0)

                  if(set2.size() == 0)

                     for (String s : set3) 

                     {

                        System.out.println(s.toUpperCase());

                     } 

                     

             // Prints back just the phone number if no words are possible       

             if (set0.size() == 0)

               if (set1.size() == 0)

                  if(set2.size() == 0)

                     if(set3.size() == 0)

                        System.out.println("1-"+input.substring(0,3)+"-"+input.substring(3,6)+"-"+input.substring(6,10));





            

                        

	}



}