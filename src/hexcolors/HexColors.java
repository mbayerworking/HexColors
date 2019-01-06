/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hexcolors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author morgan
 */
public class HexColors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the int values between 0 and 255 for each color:");
        int[] intColors = new int[3];
        try{
            System.out.print("Red int values: ");
            intColors[0] = Integer.parseInt(br.readLine());
            System.out.print("Green int values: ");
            intColors[1] = Integer.parseInt(br.readLine());
            System.out.print("Blue int values: ");
            intColors[2] = Integer.parseInt(br.readLine());
            for(int i:intColors)
            {
                if(i > 255 || i < 0)
                {
                    System.out.println("A number falls out range [0,255]");
                    System.out.println("Please enter a valid integer");
                    break;
                }
            }
        }
        catch(NumberFormatException nfe)
        {
            System.err.println("Invalid Format");
        }
        
        String hex = hexColors(intColors);
        System.out.println(Arrays.toString(intColors));
        System.out.println(hex);
    }

    private static String hexColors(int[] intColors) {
        String hex = "#";
        String[] hexes = new String[]{"A","B","C","D","E","F"};
        for(int i:intColors)
        {
            int firstHex = i;
            int secondHex = firstHex % 16;
            
            if (i > 2)
            {
                firstHex /= 16;
            }
            else {
                firstHex = (firstHex /16);
            }
            System.out.println("1: " + firstHex + "; 2: " + secondHex);
            
            // Convert first digits > 9 to corresponding hex
            if(firstHex > 9)
            {
                hex += hexes[firstHex % 10];
            }
            else{
                hex += Integer.toString(firstHex);
            }
            
            // Convert second digits > 9 to corresponding hex
            if(secondHex > 9)
            {
                hex += hexes[secondHex % 10];
            }
            else{
                hex += Integer.toString(secondHex);
            }
        }
        return hex;
    }
    
}

