import org.junit.jupiter.api.Test;

public class BigONotation {

    // O(1) if you drive or fly a file across country
    // 0(S) if you decide to transfer it electronically where S is the size of the file

    int[] arrayA = {1,2,3,4,5,6,7,8,9,10};
    int[] arrayB = {1,2,3,4,5};
    long start;

    // Even though we iterate twice it is still O(N) as its not nested
    @Test
    public void example1(){
        start = System.currentTimeMillis();
        int sum = 0;
        int product = 1;
        for (int i = 0; i < arrayA.length; i++){
            sum += arrayA[i];
        }
        for (int i = 0; i < arrayA.length; i++){
            product *= arrayA[i];
        }
        System.out.println(sum + ", " + product);
        System.out.println("Time taken in millis: " + (System.currentTimeMillis() - start));
    }

    // The below O notation is O(N2) because we iterate through every element of the array in a nested loop
    @Test
    public void example2(){
        start = System.currentTimeMillis();
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayA.length; j++) {
                System.out.println(arrayA[i] + "," + arrayA[j]);
            }
        }
        System.out.println("Time taken in millis: " + (System.currentTimeMillis() - start));
    }

    // The below O notation is O(N2) because we iterate through half of the elements of the array in a nested loop
    @Test
    public void example3(){
        start = System.currentTimeMillis();
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = i + 1; j < arrayA.length; j++) {
                System.out.println(arrayA[i] + "," + arrayA[j]);
            }
        }
        System.out.println("Time taken in millis: " + (System.currentTimeMillis() - start));
    }

    // The below O notation is O(AB) because we have 2 different sized arrays that are nested
    @Test
    public void example4(){
        start = System.currentTimeMillis();
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if(arrayA[i] < arrayB[j]) {
                    System.out.println(arrayA[i] + "," + arrayB[j]);
                }
            }
        }
        System.out.println("Time taken in millis: " + (System.currentTimeMillis() - start));
    }

    // The below O notation is still O(AB) because the final loop is constant and so does not affect the O notation
    @Test
    public void example5(){
        start = System.currentTimeMillis();
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                for (int k = 0; k < 100; k++) {
                    System.out.println(arrayA[i] + "," + arrayB[j]);
                }
            }
        }
        System.out.println("Time taken in millis: " + (System.currentTimeMillis() - start));
    }

    // The below O notation is O(N) even though it only goes through half the array, this does not impact the O notation
    @Test
    public void example6(){
        start = System.currentTimeMillis();
        for (int i = 0; i < arrayA.length / 2; i++) {
            int other = arrayA.length - i - 1;
            int temp = arrayA[i];
            arrayA[i] = arrayA[other];
            arrayA[other] = temp;
            System.out.println(other);
        }
        System.out.println("Time taken in millis: " + (System.currentTimeMillis() - start));
    }

    /*
    O(N + P), where P < N/2
    if P < N/2, then we know that N is the dominant term so we can drop the O(P)
    so the above becomes O(N)

    O(2N)
    this becomes O(N) as we drop constants

    O(N + log N)
    O(N) dominates )(log N), so we can drop the O(log N)

    O(N + M)
    there is no established relationship between N and M so this can't be reduced further
     */
}
