import java.util.*;
// Add any extra import statements you may need here


class StringEncryptionRotation {

    // Add any helper functions you may need here


    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        String result = "";

        for(int i=0; i<=input.length()-1; i++) {
            char c = input.charAt(i);
            System.out.println("got char:" + c);

            //ascii value of A
            int A = Character.valueOf('A');
            //System.out.println("A = " + A);

            int a = Character.valueOf('a');
            //System.out.println("a = " + a);

            int zero = Character.valueOf('0');
            //System.out.println("zero = " + zero);

            if((c >= 'A' && c<= 'Z' ) )  {
                int rotation = rotationFactor;

                System.out.println("got upper");
                int thisAscii =(int)(c);
                System.out.println("thisAscii = " + thisAscii);
                int newAscii = (thisAscii + rotation - A) % 26 + A;
                char newC = (char)newAscii;
                System.out.println("newC = " + newC);
                result = result + newC;
            }

           else  if((c >= 'a' && c<= 'z' ) )  {
                System.out.println("got lower");
               // int rotation = rotationFactor % 26;
                int rotation = rotationFactor;
                int thisAscii =(int)(c);
                System.out.println("thisAscii = " + thisAscii);
                int newAscii = (thisAscii + rotation - a) % 26 + a;
                char newC = (char)newAscii;
                System.out.println("newC = " + newC);
                result = result + newC;


            }

            else if((c >= '0' && c<= '9' ) ) {
                System.out.println("got number");
                int rotation = rotationFactor;
                int thisAscii =(int)(c);
                System.out.println("thisAscii = " + thisAscii);
                int newAscii = (thisAscii + rotation - zero) % 10 + zero;
                char newC = (char)newAscii;
                System.out.println("newC = " + newC);
                result = result + newC;
            }
            else {
                result = result + c;

            }

        }
        return result;

    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new StringEncryptionRotation().run();
    }
}
