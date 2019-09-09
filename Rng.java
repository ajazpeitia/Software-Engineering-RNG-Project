import java.util.*;

//Generate 1000 values. Test if 750 are unqique
class Rng  {
    
    final static int FAIL_CASE = 250;
    final static int UPPER_BOUND = 1000000;
    final static int TESTS_To_PASS = 10;

public static void main(String[] args) {
    
    int value = generateRandomNumber();
    System.out.println("Randomly generated: " + value);
}

// Generates a random number with test cases to check randomness. Generate 1000 numbers
// and check for duplicates. Pass if number of dupes doesn't pass 250. Repeat 10 times.
public static int generateRandomNumber() {

    Random rand = new Random();
    int val = 0;
    int duplicateCount = 0;
    int currentTest = 0;
    int successCount = 0;

    // Repeat this process 10 times
    while(currentTest < 10) {

        //Create a new hashset for the current test
        HashSet<Integer> uniqueValues = new HashSet<Integer>();

        //Generate 1000 values and track the count of dupe values
        for(int i = 0; i < 1000; ++i ) {
            val = rand.nextInt(UPPER_BOUND) + 1;
            //If hashset already counts the value, increment the duplicateCount
            if(!uniqueValues.add(val)) {
                ++duplicateCount;
            }
        }
        System.out.println("Test" + currentTest +". DuplicateCount: " + duplicateCount);
        if(duplicateCount < 250) {
            
            //Reset the dupe count
            duplicateCount = 0;

            //Increment the success count
            ++successCount;
        }
        else {
            
        }

        ++currentTest;
    }

    System.out.println("\nSuccess count " + successCount);

    return val;
}
}

