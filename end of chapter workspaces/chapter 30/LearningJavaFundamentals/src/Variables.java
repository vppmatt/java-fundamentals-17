public class Variables {

    public static void main(String[] args) {
        int i = 1;
        System.out.println(i);
        int j;
        j = 2;
        System.out.println(j);
        long myVariable = 17L;
        long anotherVariableWhichIsLong = 3000000000L;
        double myDouble = 17.3;
        float myFloat = 17.3F;

//        var someOtherVariable = 17;
//        someOtherVariable = 14.2;

        int first = 50;
        int second = 100;
        int third = first;
        first = 65;

        System.out.println("first " + first );
        System.out.println("second " + second );
        System.out.println("third " + third );

        int weExpect2 = second / third;
        System.out.println("100 divided by 50 is " + weExpect2);

        double weExpectOnePointFive = (double)second / first;
        System.out.println("100 divided by 65 is " + weExpectOnePointFive);

        System.out.println(first + 1);
        System.out.println(first - 1);
        System.out.println(first * 7);

        int myAge = 21;
        myAge++; // myAge = myAge + 1;
        System.out.println(myAge);
        System.out.println(--myAge);
        System.out.println(myAge);

        myAge += 5;   //myAge = myAge + 5;
        myAge -= 1;
        System.out.println(myAge);

        int result = 26 / 7;
        System.out.println("the whole part is " + result);

        // 26 / 7 = 3 remainder 5

        int modulus = 26 % 7;
        System.out.println("the remainder is " + modulus);

        boolean iAmYoungerThan30 = false;

        char myFirstNameStartsWith = 'M';

        int[] myArray = {1,2,3,4,5};
        System.out.println(myArray[0]);
        myArray[3] = 17;
        System.out.println(myArray[3]);

    }

}
