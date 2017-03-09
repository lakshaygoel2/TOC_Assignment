/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;

import java.io.*;
import java.util.*;
/**
 *
 * @author Lakshay
 * Here we'll be making a Moore simulation for a vending machine, which gives no change,
 * with inputs as 1 Dime(10$), 1 Nickel(5$) and a Reset, Output as opening of machine
 * to give a product output only when sum of money is 15$.
 * There are 4 stages: State 0(0$; Output:0) State 1(5$; Output: 0)
 * State 2(10$; Output: 0) and State 3(15$; Output 1) which is the final state. 
 * Output 1 means you get a candy
 */
public class TOC {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException{
       
        Scanner reader=new Scanner(System.in);
        int choice;             //To determine when to exit//
        char input;              //Inputs//
        int open;               //Output//
        int state=0;              //States for FSA //        
                      //Total sum of money entered into vending machine
        int flag=0;     //For incorrect inputs
        do
        {
        System.out.print("Enter input (D:Dime(10$)||N:Nickel(5$)||R:Reset):");
        
        input= reader.next().charAt(0);
        
            switch (input) {
                case 'N':
                    state=(state+1)%4;
                    break;
                case 'D':
                    state=(state+2)%4;
                    break;
                case 'R':
                    state=0;
                    break;
                default:
                    flag=1;
                    break;
            }
        if(flag==1)
        {    flag=0;             //Stage does not change...
            continue;
        }
        
        if(state==3)
        {
            open=1;
        }
        
        else
        {
            open=0;
        }
        
        System.out.print("State in Machine=");
        System.out.println(state);
        
        if(open==0)
            System.out.println("Vending Machine closed");
        else
            System.out.println("Vending Machine opened. Collect Candy");
        
        System.out.println("Do you want to enter more currency?(Yes=1; No=0)");
        choice=reader.nextInt();
  
        if(choice==0)
            break;
        } while(true);
        
    }
    
}
