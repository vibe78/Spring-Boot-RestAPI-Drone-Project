/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dronpro;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author VIBE
 */
/*
class Result {

    /*
     * Complete the 'newPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */
/*
    public static String newPassword(String a, String b) {

        StringBuilder comString = new StringBuilder();
 
        
        for (int i = 0; i <a.length() || i < b.length(); i++) {
 
            if (i < a.length())
                comString.append(a.charAt(i));

            if (i < b.length())
                comString.append(b.charAt(i));
        }
 
        return comString.toString();
        
      

    }

}
*/
public class tryP {
    
        public static String newPassword(String a, String b) {

        StringBuilder comString = new StringBuilder();
 
        
        for (int i = 0; i <a.length() || i < b.length(); i++) {
 
            if (i < a.length())
                comString.append(a.charAt(i));

            if (i < b.length())
                comString.append(b.charAt(i));
        }
 
        return comString.toString();
        
      

    }
    
        public static void main(String[] args) throws IOException {
            
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        String result = newPassword(a, b);
        System.out.println(result);
        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
