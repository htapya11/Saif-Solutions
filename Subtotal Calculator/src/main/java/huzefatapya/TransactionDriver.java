package huzefatapya;

import java.io.IOException;
import java.util.ArrayList;

public class TransactionDriver {
    public static void main (String[] args) throws IOException{
        
        TransactionSubtotals ts = new TransactionSubtotals();

        ArrayList <Transaction> input = ts.readFile();
        for (Transaction t : input){
            System.out.println(t.toString());
        }

        ArrayList <Transaction> output = ts.getOutputArray(input);
        for (Transaction t: output){
            System.out.println(t.toString());
        }

        ts.writeFile(output);
        ts.sendEmail();
    }
}