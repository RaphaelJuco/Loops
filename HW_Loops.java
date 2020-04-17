//.......0.........1.........2.........3.........4.........5.........6.........8
/**
 * Write a description of class HW_Loops here.
 *
 * @author (Raphael Juco)
 * @version (2/4/2018)
 */
import java.util.Scanner;//Necessary for user input

public class HW_Loops
{
    /*
     * In this block of code, we declared our variables for the Scanner class
     * prompting the user to enter the sequences. Then, we test the validity
     * of the user's input. We also call the methods 
     * necessary for calculating and printing the sequence's statistics.
     */
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the first sequence: ");
        String first = keyboard.nextLine();
        if(validFirst(first) == true){
            System.out.println("Sequence 1: " + first);
            System.out.println("C-count: " + firstCountC(first));
            System.out.println("CG-ratio: " + firstCGratio(first));
            System.out.println("Complement: " + firstComplement(first));
        }
        else{
            System.out.println("Try Again");
            System.exit(0);//Makes the program to stop
        }                   
        System.out.println("Enter the second sequence: ");
        String second = keyboard.nextLine();       
        if(validSecond(second) == true){
            System.out.println("Sequence 2: " + second);
            System.out.println("C-count: " + secondCountC(second));
            System.out.println("CG-ratio: " + secondCGratio(second));
            System.out.println("Complement: " + secondComplement(second));
            alignmentScore(first, second);
        }
        else{
            System.out.println("Try Again");
            System.exit(0);//Makes the program to stop
        }
    }
    /*
     * In this method, we count the amount of C char in the first inputted 
     * sequence. Each time that it detects the char C in each position of
     * the String, then it updates int countC by +1 and returns it.
     */
    public static int firstCountC(String first){
        int length = first.length();
        int countC = 0;
        char C;//Declares a char called C
        for(int i = 0; i < length; i++){
            C = first.charAt(i);//Assigns the char at moment i to C
            if(C == 'C'){
            countC++;
            }
        }
        return countC;
    }      
    public static int secondCountC(String second){
        int length = second.length();
        int countC = 0;
        char C;
        for(int i = 0; i < length; i++){
            C = second.charAt(i);
            if(C == 'C'){
            countC++;
            }
        }
        return countC;
    }
    /*
     * In this method, the ratio between char C and G in the first 
     * sequence is calculated. Whenever the char variable G is equal
     * to 'C' or 'G' in the sequence, the numOfCG goes up by 1. Then,
     * it takes that number and divides it by the length of the String 
     * first and returns that ratio.
     */
    public static double firstCGratio(String first){
        double length = first.length();
        double numOfCG = 0;
        char G;
        for(int i = 0; i < length; i++){
            G = first.charAt(i);
            if(G == 'C'|| G == 'G'){
                numOfCG++;
            }                     
        }
        double CGratio = numOfCG/length;   
        return CGratio;
    }
    public static double secondCGratio(String second){
        double length = second.length();
        double numOfCG = 0;
        char G;
        for(int i = 0; i < length; i++){
            G = second.charAt(i);
            if(G == 'C'|| G == 'G'){
                numOfCG++;
            }                     
        }
        double CGratio = numOfCG/length;   
        return CGratio;
    }
    /*
     * In this method, we create a blank string that will be filled 
     * up with the complementary char of the user's input. We first 
     * test what each char is at each position, then we replace that
     * char into its complement in the new blank string, then we 
     * return that string.
     */
    public static String firstComplement(String first){
        int length = first.length();
        String complement = "";
        char R;
        for(int i = 0; i < length; i++){
            R = first.charAt(i);
            if(R == 'C'){
            R = 'G';
            complement = complement + R;
            }
            else if(R == 'A'){
            R = 'T';
            complement = complement + R;
            }
            else if(R == 'G'){
            R = 'C';
            complement = complement + R;
            }
            else if(R == 'T'){
            R = 'A';
            complement = complement + R;
            }
        }
        return complement;
    }
    public static String secondComplement(String second){
        int length = second.length();
        String complement = "";
        char R;
        for(int i = 0; i < length; i++){
            R = second.charAt(i);
            if(R == 'C'){
            R = 'G';
            complement = complement + R;
            }
            else if(R == 'A'){
            R = 'T';
            complement = complement + R;
            }
            else if(R == 'G'){
            R = 'C';
            complement = complement + R;
            }
            else if(R == 'T'){
            R = 'A';
            complement = complement + R;
            }
        }
        return complement;
    }
    /*
     * For this method, we create two new empty strings for either sequence 
     * to go, which will become the final alignment sequence. We test which 
     * sequence is the longest and we count how many possible
     * char alignments can be made and increase the alignment score
     * by one each time a char matches between the first and second
     * sequence.
     */
    public static int alignmentScore(String first, String second){
        int flength = first.length();
        int slength = second.length();
        int score = 0;
        int alignmentScore = 0;
        String newFirst = "";
        String newSecond = "";
        if(flength > slength){
            for(int i = 0; i < flength - slength; i++){
                for(int j = 0; j < slength; j++){
                    if(first.charAt(j) == second.charAt(j)){
                        score++;
                    }
                    if(score > alignmentScore){
                        alignmentScore = score;
                        newSecond = second;
                    }
                }
                score = 0;
                second = " " + second;
        }        
        System.out.println("Best alignment score: " + alignmentScore);
        System.out.println(first);
        System.out.println(newSecond);
    }
        else{ 
            for(int i = 0; i < slength - flength; i++){
                for(int j = 0; j < flength; j++){
                    if(second.charAt(j) == first.charAt(j)){
                        score++;
                    }
                    if(score > alignmentScore){
                        alignmentScore = score;
                        newFirst = first;
                    }
                }
                score = 0;
                first = " " + first;
            }
            System.out.println("Best alignment score: " + alignmentScore);
            System.out.println(newFirst);
            System.out.println(second);
        }
        return alignmentScore;
    }
    /*
     * In this method, we test if the user's input passes as
     * a sequence. We count the total amount of times the char
     * 'ACTG' are in the user's input, so if there are any
     * other char inputted then it would return false.
     */
    public static boolean validFirst(String first){
        int count = 0;
        for(int i = 0; i < first.length(); i++){
            if(first.charAt(i) == 'A'){
            count++;
        }
        else if(first.charAt(i) == 'C'){
            count++;
        }
        else if(first.charAt(i) == 'T'){
            count++;
        }
        else if(first.charAt(i) == 'G'){
            count++;
        }
        }
        if(count == first.length()){
        return true;
        }
        else{
        return false;
        }
}
    public static boolean validSecond(String second){
        int count = 0;
        for(int i = 0; i < second.length(); i++){
            if(second.charAt(i) == 'A'){
            count++;
        }
        else if(second.charAt(i) == 'C'){
            count++;
        }
        else if(second.charAt(i) == 'T'){
            count++;
        }
        else if(second.charAt(i) == 'G'){
            count++;
        }
        }
        if(count == second.length()){
        return true;
        }
        else{
        return false;
        }
}
}
