/**
 * Solution
 */
import java.util.*;
import java.io.*;

class Solution {
    
   
     
    public static void main (String[] args) throws Exception {
           BufferedReader br = new BufferedReader(new FileReader("Trials/input.txt")); // path of the file
           
            String line = br.readLine(); // iterator
            while (line != null) {
                if (line.length() >= 2 && line.charAt(1) == '*') { // start of a paper
                    String title = line.substring(2); // substring to remove #
                    String authors = br.readLine().substring(2); // list of authors separated by comma
                    String conference = br.readLine().substring(2);
                    String year = br.readLine().substring(2);
                    String index = br.readLine().substring(6);
                    String temp = br.readLine();
                    String references = ""; // string that stores cited papers delimited by comma
                    while (temp.charAt(1) == '%') {
                        references += temp.substring(2) + ",";
                        temp = br.readLine();
                    }
                   
                    String abst = temp.substring(2);

                }
                
                line = br.readLine();
            }

            br.close();
        }
    }