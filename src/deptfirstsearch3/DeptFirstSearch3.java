/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package deptfirstsearch3;

import java.util.Scanner;
/**
 *
 * @author zizou
 */
public class DeptFirstSearch3 {

       //Method that solve our problem
    private static long NQueen(int n, int[] board, int i, boolean correct, long failure) {
        board[i] = 1;
        //if the solution found (true), return the result
        while (!correct) {
            //Add a new queen if the current position is valid
            if (IsValid(board, i)) {
                //check if this was the last queen
                if (i == n - 1)
                    return failure;
                //call the next iteration
                i++;
                board[i] = 1;
            }else { //position is not valid
                //seeks the last queen and remove it
                while (board[i] == n) {
                    failure++;
                    i--;
                } //we do the next call 
                board[i]++;
                correct = false;
                
                                
            }
        }
        return failure;
    }

    
    //Method that check whether the current position is valid
    private static boolean IsValid(int[] board, int i) {
 
        for (int j = i - 1, x = 1; j > -1; j--, x++)
            if (board[i] == board[j] || board[i] + x == board[j] || board[i] - x == board[j])
                return false;
        return true;
    }
    
    //Method that print board
    private static void PrintBoard(int[] board) {
        System.out.print("   ");
        for (int j = 0; j < board.length; j++)
            System.out.print(" " + j + " ");
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(" " + i + " ");
            for (int j = 1; j <= board.length; j++)
                if (board[i] != j) 
                    System.out.print("   ");
                else
                    System.out.print(" Q ");
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        
        // Determine the chess board size
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the chess board size\n");
        int n = input.nextInt(); 
        
        //Creation of board
        int[] board = new int[n];
        
        //call solve method
        long failure = NQueen(n, board, 0, false, 0);
        
        System.out.println("Number of failure : " + failure);
        
        //Printing board
        PrintBoard(board);
        
    }   
}
// miiiiw Happy coding
