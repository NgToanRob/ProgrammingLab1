import static java.lang.Math.*;

public class hello {

    /** Laboratory 1:
    * @author: Nguyen Toan
    */

    public static void main(String[] args){
    	// Initialize variables
        short[] evenNumbers = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        double[] doubleNumbers = new double[14];
        for (int i = 0; i < 14; i++) {
            doubleNumbers[i] = random()*10 - 4;
        }

        double[][] resultNumbers = new double[10][14];

        // Main caculation 
        for (int i = 0; i < evenNumbers.length; i++) {
            for (int j = 0; j < 14; j++) {
                if (evenNumbers[i] == 2){
                    resultNumbers[i][j] = sin( pow((((double) 2/3) / (log(abs(doubleNumbers[j]))  +1)), 2) );
                } 
                else if (evenNumbers[i] == 2|| evenNumbers[i] == 12 || evenNumbers[i] == 14 || evenNumbers[i] == 16 || evenNumbers[i] == 18) {
                    resultNumbers[i][j] = pow( (pow(sin(doubleNumbers[j]),pow((double) doubleNumbers[j]/(doubleNumbers[j]-1), 3)) + PI) / 0.5 , 2);
                } 
                else {
                    resultNumbers[i][j] = asin( pow( exp(cbrt(-exp(doubleNumbers[j]))), 2) );
                }
            }
        }

        // Print output
        System.out.print("[");
        for (int i = 0; i < 10; i++) {
            System.out.print("[");

            for (int j = 0; j < 14; j++) {
                System.out.printf("%.3f\t", resultNumbers[i][j]);
            }
            if (i == 9) {
            	System.out.print("]]");
            	break;
            }
            System.out.println("],");
        }
        
    }
}

