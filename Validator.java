//Jacob Simmons 
//COMP 3240 Section 001 Programming Assignment 1 
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

/*
 *COMP 3240 Section 001 Programming Assignment 1 
 * @author Jacob Simmons
 * @version 04-6-23
 */


// Notes on how to use evaluator():
// Call the evaluator with Evaluator.evaluate(<premise>, <variable_dict>). "premise"
// is a single string defining the premise or conclusion to test. "variable_dict" is a
// Hashtable<Character, Boolean>() object with the variable name as the key and true/false
// as the value. 

// The only valid operators for premise strings are '^' (and), 'V' (or--CAPITAL v), '~' (not),
// and '>' (implies), and you can use parentheses to override the order of operations as usual.
// All variables should be lowercase letters and each should only be one character long. Finally,
// do not include spaces in the string.

// For example, if you want to test the premise 'p implies q or not r', you should use 'p>qV~r' as
// your premise string.

public class Validator {
   // All of the logic to complete this assignment should be written in this function.
   // This method accepts two things: An array of strings called premiseList and a 
   // single string called conclusion. These strings should be formatted according to 
   // the structure definded above. Also, this needs to return a boolean variable: true if
   // the argument form is valid, and false if it is not valid.

   public static void main(String[] args) {
      Validator checker = new Validator();
      String[] arguments = {"p", "d"};

      checker.validate(arguments, "c>p");

   }

   public boolean validate(String[] premiseList, String conclusion) {

      //create the expression
      try{ 
         String newExpression = "((" + premiseList[0] + ")";
         for(int i = 1; i < premiseList.length; i++){
            newExpression += "^";
            newExpression +="(" + premiseList[i] +")";
         }
         newExpression += ")>(" + conclusion + ")";

         //get all varibles in our expression and put the into a hash set
         Set<Character> variablesHS = new HashSet<Character>(); 
         String newIn = newExpression.replaceAll("[^a-zA-Z]", "");
         newIn = newIn.replace("V", "");
         for(int i = 0; i < newIn.length(); i++){
            variablesHS.add(newIn.charAt(i));
         }
         Character[] arrFromSet = variablesHS.toArray(new Character[variablesHS.size()]);

         // make a hashtable and input charaacters and boolean from arr
         Hashtable<Character, Boolean> ht = new Hashtable<>();
         
         //make a hashset to store the binary numbers
         Set<String> binaryHS = new HashSet<>();

         for(int i = 0; i < arrFromSet.length; i++){
            ht.put(arrFromSet[i], true);
         }
         
         //get all binary numbers for the number of variables
         for(int i = 0; i < Math.pow(2, arrFromSet.length); i++){
            int binaryInt = Integer.parseInt(Integer.toBinaryString(i));
            String binaryStr = String.format("%0"+ arrFromSet.length+ "d", binaryInt);
            //System.out.println(binaryStr);
            binaryHS.add(binaryStr);
         }

         //convert hash set to array
         String binaryArray[] = new String[binaryHS.size()];
            
         int num =0;
         
         // iterating over the hashset
         for(String ele:binaryHS){
         binaryArray[num++] = ele;
         }

         Boolean returnVal = true; 
         Hashtable<Character, Boolean> hashTableTest = new Hashtable<>();
         Boolean boolVal;

         //go through and make sure the expression is a tautology
         for(int i = 0; i < binaryArray.length; i++){

            //new hashtable that will be used to evaluate the expression
            hashTableTest.clear();
            for(int j = 0; j < binaryArray[i].length(); j++){
               if(binaryArray[i].charAt(j) == '1'){
                  boolVal = true;
               }
               else{
                  boolVal = false;
               }
               

               hashTableTest.put(arrFromSet[j], boolVal);
               System.out.println("var from arr: " + arrFromSet[j] + "  bool: " + boolVal);
            }
            System.out.println(newExpression + "   bool: "+ hashTableTest.toString());
            if(!(Evaluator.evaluate(newExpression, hashTableTest))){
               returnVal = false;
            }
         //System.out.println("\n");

         }
         //System.out.println(ht.toString());
            System.out.println(returnVal);
            return returnVal;
      }
      catch(Exception e){
         System.out.println(e);
      }
      System.out.println("false");
      return false;
   }
}
