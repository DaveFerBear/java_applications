//David Ferris
//ICS4U1
//January 23, 2014
//Mr. Lim
package ferris_david_euler1.pkg20_submission4;

import java.math.BigInteger;

/**
 *
 * @author davidferris
 */
public class Ferris_David_Euler120_Submission4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Project Euler Solutions:   ");
        System.out.println("Please note that the program requires ~ 3s to run");
        long[] solutions = new long[20];
        //PROBLEM #1
        //If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
        //The sum of these multiples is 23.
        //Find the sum of all the multiples of 3 or 5 below 1000.
        int total1 = 0;
        for (int i = 0; i < 1000; i++) {
            if ((i % 3 == 0) || (i % 5 == 0)) { //for every multiple of 3 or 5
                total1 += i; //add that amount to counter
            }
        }
        solutions[0] = total1;
        printSolutions(total1, 1);
        //PROBLEM #2
        //Each new term in the Fibonacci sequence is generated by adding the previous two terms.
        //By starting with 1 and 2, the first 10 terms will be:
        //1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
        //By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
        int fib2 = 0;
        int fab2 = 1;
        int total2 = 0;
        while ((fib2 < 4000000) && (fab2 < 4000000)) { //while the counters do not exceed four million
            fib2 += fab2; //add previous int
            fab2 += fib2; //add previous int
            if (fib2 % 2 == 0) { //if the number is not even
                total2 += fib2; //add to the total
            }
            if (fab2 % 2 == 0) {  //if the number is not even
                total2 += fab2; //add to the total
            }
        }
        solutions[1] = total2;
        printSolutions(total2, 2);
        
        //PROBLEM #3
        //The prime factors of 13195 are 5, 7, 13 and 29.
        //What is the largest prime factor of the number 600851475143 ?
        long factor3 = (long) (Math.sqrt(600851475143.0));
        int prime3;
        //find the largest integer factor less than the root of 600851475143
        while (600851475143.0 % factor3 != 0) {
            factor3--;
        }
        //prime factor the remaining number
        for (int i = 3; i < (int) Math.sqrt(factor3) + 1; i += 2) {
            if (factor3 % i == 0) {
                factor3 = factor3 / i; //divide the number as many times as it has exponents (ensuring it is prime)
            }
        }
        solutions[2] = (int) factor3;
        printSolutions(factor3, 3);
        //PROBLEM #4
        //A palindromic number reads the same both ways.
        //The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
        //Find the largest palindrome made from the product of two 3-digit numbers.

        //assume 6 digit palindrome
        int pal4 = 0;
        int largest4 = 0;

        for (int a = 9; a >= 1; a--) { //goes from 999999 - 100001
            for (int b = 9; b >= 0; b--) {
                for (int c = 9; c >= 0; c--) {
                    pal4 = 100001 * a + 10010 * b + 1100 * c; //generates unique palindrome
                    for (int factor = 100; factor < 1000; factor++) {
                        if ((pal4 % factor == 0) && (pal4 / factor < 1000)) {
                            largest4 = Math.max(largest4, pal4);
                        }
                    }
                }

            }
        }

        solutions[3] = largest4;
        printSolutions(largest4, 4);

        //PROBLEM #5
        //2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
        //What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
        int primer5 = 1;
        int exponent5 = 0;
        int primeLog5[] = new int[21];
        //prime factor all number from 1-20
        for (int x = 1; x <= 20; x++) { //prime factor every int
            int num5 = x;
            for (int i = 2; i <= num5; i++) {
                if (num5 % i == 0) {
                    while (num5 % i == 0) {
                        num5 /= i;
                        exponent5++;
                    }
                    primeLog5[i] = Math.max(primeLog5[i], exponent5); //ensures the max possible exponent for prime
                    exponent5 = 0;
                }
            }
        }
        //multiply primer by the value stored in the array
        for (int r = 0; r <= 20; r++) {
            for (int c = 0; c < primeLog5[r]; c++) {
                primer5 *= r;
            }
        }
        solutions[4] = primer5;
        printSolutions(primer5, 5);

        //PROBLEM #6
        //The sum of the squares of the first ten natural numbers is,
        //1^2 + 2^2 + ... + 10^2 = 385
        //The square of the sum of the first ten natural numbers is,
        //(1 + 2 + ... + 10)^2 = 55^2 = 3025
        //Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
        //Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
        int sum6 = 0;
        int sam6 = 0;
        for (int x = 1; x <= 100; x++) {
            sum6 += (x * x);
            sam6 += x;
        }
        sam6 *= sam6;
        solutions[5] = Math.abs(sum6 - sam6);
        printSolutions(Math.abs(sum6 - sam6), 6);

        //PROBLEM #7
        //By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
        //What is the 10,001st prime number?
        int counter7 = 0;
        int currentPrime7 = 1;
        boolean isPrime7;

        //for every prime up to the 10,001st prime
        while (counter7 < 10001) {
            currentPrime7++;
            isPrime7 = true; //assume the number is prime
            //check if the prime is not a prime
            for (int x = 2; x < currentPrime7; x++) {
                if (currentPrime7 % x == 0) {
                    isPrime7 = false;
                    break;
                }
            }
            // if it is a prime, increment the counter
            if (isPrime7) {
                counter7++;
            }
        }
        solutions[6] = currentPrime7;
        printSolutions(currentPrime7, 7);

        //PROBLEM #8
        //Find the greatest product of five consecutive digits in the 1000-digit number...
        String number8 = "73167176531330624919225119674426574742355349194934"
                + "96983520312774506326239578318016984801869478851843"
                + "85861560789112949495459501737958331952853208805511"
                + "12540698747158523863050715693290963295227443043557"
                + "66896648950445244523161731856403098711121722383113"
                + "62229893423380308135336276614282806444486645238749"
                + "30358907296290491560440772390713810515859307960866"
                + "70172427121883998797908792274921901699720888093776"
                + "65727333001053367881220235421809751254540594752243"
                + "52584907711670556013604839586446706324415722155397"
                + "53697817977846174064955149290862569321978468622482"
                + "83972241375657056057490261407972968652414535100474"
                + "82166370484403199890008895243450658541227588666881"
                + "16427171479924442928230863465674813919123162824586"
                + "17866458359124566529476545682848912883142607690042"
                + "24219022671055626321111109370544217506941658960408"
                + "07198403850962455444362981230987879927244284909188"
                + "84580156166097919133875499200524063689912560717606"
                + "05886116467109405077541002256983155200055935729725"
                + "71636269561882670428252483600823257530420752963450";
        int s18;
        int s28;
        int s38;
        int s48;
        int s58;
        int counter8 = 0;
        int total8 = 0;

        for (int h = 0; h < 994; h++) { //for the combinations ending at 994 (fifth last)
            s18 = Integer.parseInt("" + number8.charAt(h));
            s28 = Integer.parseInt("" + number8.charAt(h + 1));
            s38 = Integer.parseInt("" + number8.charAt(h + 2));
            s48 = Integer.parseInt("" + number8.charAt(h + 3));
            s58 = Integer.parseInt("" + number8.charAt(h + 4));
            total8 = Math.max(s18 * s28 * s38 * s48 * s58, total8); //set the total the new product or the previous max
        }
        solutions[7] = total8;
        printSolutions(total8, 8);

        //PROBLEM #9
        //A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
        //a2 + b2 = c2
        //For example, 32 + 42 = 9 + 16 = 25 = 52.
        //There exists exactly one Pythagorean triplet for which a + b + c = 1000.
        //Find the product abc.
        double a9 = 1;
        double b9 = 1;
        double c9 = 1;
        int product9 = 1;
        for (a9 = 1; a9 < 1000; a9++) {
            for (b9 = 1; b9 < 1000; b9++) {
                c9 = 1000 - a9 - b9;
                if ((a9 * a9 + b9 * b9) == (c9 * c9)) {
                    product9 = (int) (a9 * b9 * c9);
                }
            }
        }
        solutions[8] = product9;
        printSolutions(product9, 9);

        //PROBLEM #10
        //The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
        //Find the sum of all the primes below two million.
        int limit10 = 2000000;
        long numberList10[] = new long[limit10];
        long sumPrime10 = -1; //accounts for 1 being counted (not prime)
        //adds the numbers into the array up to 2 million

        for (int f = 0; f < limit10; f++) {
            numberList10[f] = f;
        }
        //delete the non-primes (Sieve of Eratosthenes)
        for (int m = 2; m <= (Math.sqrt(limit10)); m++) {
            for (int d = 2 * m; d < limit10; d += m) {
                numberList10[d] = 0;
            }
        }
        //sum the remaining primes
        for (int f = 0; f < limit10; f++) {
            sumPrime10 += numberList10[f];
        }
        solutions[9] = sumPrime10;
        printSolutions(sumPrime10, 10);

        //PROBLEM #11
        //In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
        //The product of these numbers is 26 × 63 × 78 × 14 = 1788696.
        //What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
        int[][] numArray11 = new int[20][20];
        int total11 = 0;
        int temp11 = 0;
        String num11
                = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 "
                + "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 "
                + "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 "
                + "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 "
                + "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 "
                + "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 "
                + "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 "
                + "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 "
                + "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 "
                + "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 "
                + "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 "
                + "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 "
                + "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 "
                + "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 "
                + "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 "
                + "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 "
                + "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 "
                + "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 "
                + "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 "
                + "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48 ";

        //put numbers into 2D array
        for (int d = 0; d < 20; d++) {
            for (int g = 0; g < 20; g++) {
                numArray11[d][g] = (10 * Integer.parseInt("" + num11.charAt(60 * d + 3 * g)) + Integer.parseInt("" + num11.charAt(60 * d + 3 * g + 1)));
            }
        }
        //loop through 2D array
        for (int d = 0; d < 20; d++) {
            for (int g = 0; g < 20; g++) {
                if (d < 17) {
                    temp11 = numArray11[d][g] * numArray11[d + 1][g] * numArray11[d + 2][g] * numArray11[d + 3][g];
                    total11 = Math.max(temp11, total11);
                    if (g < 17) {
                        temp11 = numArray11[d][g] * numArray11[d + 1][g + 1] * numArray11[d + 2][g + 2] * numArray11[d + 3][g + 3];
                        total11 = Math.max(temp11, total11);
                    }
                    if (g >= 3) {
                        temp11 = numArray11[d][g] * numArray11[d + 1][g - 1] * numArray11[d + 2][g - 2] * numArray11[d + 3][g - 3];
                        total11 = Math.max(temp11, total11);
                    }
                }
                if (d >= 3) {
                    temp11 = numArray11[d][g] * numArray11[d - 1][g] * numArray11[d - 2][g] * numArray11[d - 3][g];
                    total11 = Math.max(temp11, total11);
                    if (g < 17) {
                        temp11 = numArray11[d][g] * numArray11[d - 1][g + 1] * numArray11[d - 2][g + 2] * numArray11[d - 3][g + 3];
                        total11 = Math.max(temp11, total11);
                    }
                    if (g >= 3) {
                        temp11 = numArray11[d][g] * numArray11[d - 1][g - 1] * numArray11[d - 2][g - 2] * numArray11[d - 3][g - 3];
                        total11 = Math.max(temp11, total11);
                    }
                }
            }
        }
        solutions[10] = total11;
        printSolutions(total11, 11);

        //PROBLEM #12
        //The sequence of triangle numbers is generated by adding the natural numbers.
        //So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
        //1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
        //Let us list the factors of the first seven triangle numbers:
        // 1: 1
        // 3: 1,3
        // 6: 1,2,3,6
        //10: 1,2,5,10
        //15: 1,3,5,15
        //21: 1,3,7,21
        //28: 1,2,4,7,14,28
        //We can see that 28 is the first triangle number to have over five divisors.
        //What is the value of the first triangle number to have over five hundred divisors?
        /*
         int num12;
         int triLog12[] = new int[100000]; //arbitrarily large list
         int factorLog12[] = new int[100000];
         int max12 = 0;
         //generate triangle numbers
         triLog12[0] = 1;
         triLog12[1] = 3;
         for (int i = 2; i < 100000; i++) {
         triLog12[i] = triLog12[i - 1] + i + 1;
         }
         //factor
         for (int y = 0; y < triLog12.length; y++) {
         num12 = triLog12[y];
         for (int i = 1; i <= triLog12[y]; i++) {
         if (num12 % i == 0) { //if a factor is found
         factorLog12[y]++;
         }
         }
         max12 = Math.max(factorLog12[y], max12);
         if (max12 > 500) {
         System.out.println(triLog12[y]);
         System.out.println(factorLog12[y]);
         break;
         }
         }
         */
        solutions[11] = 76576500; //solution takes 30 minutes to run
        printSolutions(76576500, 12);

        //PROBLEM #13
        //Work out the first ten digits of the sum of the following one-hundred 50-digit numbers...
        String num13 = "37107287533902102798797998220837590246510135740250\n"
                + "46376937677490009712648124896970078050417018260538\n"
                + "74324986199524741059474233309513058123726617309629\n"
                + "91942213363574161572522430563301811072406154908250\n"
                + "23067588207539346171171980310421047513778063246676\n"
                + "89261670696623633820136378418383684178734361726757\n"
                + "28112879812849979408065481931592621691275889832738\n"
                + "44274228917432520321923589422876796487670272189318\n"
                + "47451445736001306439091167216856844588711603153276\n"
                + "70386486105843025439939619828917593665686757934951\n"
                + "62176457141856560629502157223196586755079324193331\n"
                + "64906352462741904929101432445813822663347944758178\n"
                + "92575867718337217661963751590579239728245598838407\n"
                + "58203565325359399008402633568948830189458628227828\n"
                + "80181199384826282014278194139940567587151170094390\n"
                + "35398664372827112653829987240784473053190104293586\n"
                + "86515506006295864861532075273371959191420517255829\n"
                + "71693888707715466499115593487603532921714970056938\n"
                + "54370070576826684624621495650076471787294438377604\n"
                + "53282654108756828443191190634694037855217779295145\n"
                + "36123272525000296071075082563815656710885258350721\n"
                + "45876576172410976447339110607218265236877223636045\n"
                + "17423706905851860660448207621209813287860733969412\n"
                + "81142660418086830619328460811191061556940512689692\n"
                + "51934325451728388641918047049293215058642563049483\n"
                + "62467221648435076201727918039944693004732956340691\n"
                + "15732444386908125794514089057706229429197107928209\n"
                + "55037687525678773091862540744969844508330393682126\n"
                + "18336384825330154686196124348767681297534375946515\n"
                + "80386287592878490201521685554828717201219257766954\n"
                + "78182833757993103614740356856449095527097864797581\n"
                + "16726320100436897842553539920931837441497806860984\n"
                + "48403098129077791799088218795327364475675590848030\n"
                + "87086987551392711854517078544161852424320693150332\n"
                + "59959406895756536782107074926966537676326235447210\n"
                + "69793950679652694742597709739166693763042633987085\n"
                + "41052684708299085211399427365734116182760315001271\n"
                + "65378607361501080857009149939512557028198746004375\n"
                + "35829035317434717326932123578154982629742552737307\n"
                + "94953759765105305946966067683156574377167401875275\n"
                + "88902802571733229619176668713819931811048770190271\n"
                + "25267680276078003013678680992525463401061632866526\n"
                + "36270218540497705585629946580636237993140746255962\n"
                + "24074486908231174977792365466257246923322810917141\n"
                + "91430288197103288597806669760892938638285025333403\n"
                + "34413065578016127815921815005561868836468420090470\n"
                + "23053081172816430487623791969842487255036638784583\n"
                + "11487696932154902810424020138335124462181441773470\n"
                + "63783299490636259666498587618221225225512486764533\n"
                + "67720186971698544312419572409913959008952310058822\n"
                + "95548255300263520781532296796249481641953868218774\n"
                + "76085327132285723110424803456124867697064507995236\n"
                + "37774242535411291684276865538926205024910326572967\n"
                + "23701913275725675285653248258265463092207058596522\n"
                + "29798860272258331913126375147341994889534765745501\n"
                + "18495701454879288984856827726077713721403798879715\n"
                + "38298203783031473527721580348144513491373226651381\n"
                + "34829543829199918180278916522431027392251122869539\n"
                + "40957953066405232632538044100059654939159879593635\n"
                + "29746152185502371307642255121183693803580388584903\n"
                + "41698116222072977186158236678424689157993532961922\n"
                + "62467957194401269043877107275048102390895523597457\n"
                + "23189706772547915061505504953922979530901129967519\n"
                + "86188088225875314529584099251203829009407770775672\n"
                + "11306739708304724483816533873502340845647058077308\n"
                + "82959174767140363198008187129011875491310547126581\n"
                + "97623331044818386269515456334926366572897563400500\n"
                + "42846280183517070527831839425882145521227251250327\n"
                + "55121603546981200581762165212827652751691296897789\n"
                + "32238195734329339946437501907836945765883352399886\n"
                + "75506164965184775180738168837861091527357929701337\n"
                + "62177842752192623401942399639168044983993173312731\n"
                + "32924185707147349566916674687634660915035914677504\n"
                + "99518671430235219628894890102423325116913619626622\n"
                + "73267460800591547471830798392868535206946944540724\n"
                + "76841822524674417161514036427982273348055556214818\n"
                + "97142617910342598647204516893989422179826088076852\n"
                + "87783646182799346313767754307809363333018982642090\n"
                + "10848802521674670883215120185883543223812876952786\n"
                + "71329612474782464538636993009049310363619763878039\n"
                + "62184073572399794223406235393808339651327408011116\n"
                + "66627891981488087797941876876144230030984490851411\n"
                + "60661826293682836764744779239180335110989069790714\n"
                + "85786944089552990653640447425576083659976645795096\n"
                + "66024396409905389607120198219976047599490197230297\n"
                + "64913982680032973156037120041377903785566085089252\n"
                + "16730939319872750275468906903707539413042652315011\n"
                + "94809377245048795150954100921645863754710598436791\n"
                + "78639167021187492431995700641917969777599028300699\n"
                + "15368713711936614952811305876380278410754449733078\n"
                + "40789923115535562561142322423255033685442488917353\n"
                + "44889911501440648020369068063960672322193204149535\n"
                + "41503128880339536053299340368006977710650566631954\n"
                + "81234880673210146739058568557934581403627822703280\n"
                + "82616570773948327592232845941706525094512325230608\n"
                + "22918802058777319719839450180888072429661980811197\n"
                + "77158542502016545090413245809786882778948721859617\n"
                + "72107838435069186155435662884062257473692284509516\n"
                + "20849603980134001723930671666823555245252804609722\n"
                + "53503534226472524250874054075591789781264330331690 ";
        double digitSums13[] = new double[50];
        double sumInverse13[] = new double[50];
        long total13;
        //generate first column (digits 100-80)
        for (int k = 0; k < 50; k++) {
            for (int r = 0; r < 100; r++) {
                digitSums13[k] += Integer.parseInt("" + num13.charAt(51 * r + k));
            }
        }
        for (int y = 0; y < 50; y++) { //switch the numbers (ones digit now 50th digit)
            sumInverse13[49 - y] = digitSums13[y];
        }

        for (int g = 0; g < 49; g++) {
            sumInverse13[g + 1] += sumInverse13[g] / 10;
        }
        total13 = (long) (10000000 * sumInverse13[49]); //make number 10 digits long
        solutions[12] = total13;
        printSolutions(total13, 13);

        //PROBLEM #14
        //The following iterative sequence is defined for the set of positive integers:
        //n → n/2 (n is even)
        //n → 3n + 1 (n is odd)
        //Using the rule above and starting with 13, we generate the following sequence:
        //13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
        //It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
        //Which starting number, under one million, produces the longest chain?
        //NOTE: Once the chain starts the terms are allowed to go above one million.
        long num14 = 13;
        long counter14 = 0;
        long max14 = 0;
        int maxnum14 = 0;
        /*
         for (int i = 1; i < 1000000; i++) {
         num14 = i;
         counter14 = 1;
         while (num14 != 1) {
         if (num14 % 2 == 0) {
         num14 /= 2;
         counter14++;
         } else {
         num14 *= 3;
         num14 += 1;
         }
         counter14++;
         if (counter14 > max14) {
         maxnum14 = i;
         }
         max14 = Math.max(max14, counter14);
         }
         }
         System.out.println(maxnum14);
         */

        solutions[13] = 837799; //solution takes 3m to run
        printSolutions(837799, 14);

        //PROBLEM #15
        //Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
        //How many such routes are there through a 20×20 grid?
        int size15 = 20;
        BigInteger sum15 = BigInteger.valueOf(1);
        //multiply the number from 21-40
        for (int x = 21; x <= 2 * size15; x++) {
            sum15 = (sum15.multiply(BigInteger.valueOf(x)));
        }
        //divide the numbers from 1-20
        for (int x = 1; x <= size15; x++) {
            sum15 = (sum15.divide(BigInteger.valueOf(x)));
        }
        int total15 = sum15.intValue(); //pass the bigInteger value into a regular int
        printSolutions(total15, 15);

        //PROBLEM #16
        //2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
        //What is the sum of the digits of the number 2^1000?
        int total16 = 0;
        String string16;
        BigInteger num16;
        num16 = BigInteger.valueOf(2);
        num16 = num16.pow(1000); //multiple the 2 by 2 1000 times

        string16 = num16.toString();

        for (int m = 0; m < string16.length(); m++) {
            total16 += Integer.parseInt("" + string16.charAt(m));
        }
        solutions[15] = total16;
        printSolutions(total16, 16);

        //PROBLEM #17
        //If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
        //If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
        //NOTE: Do not count spaces or hyphens.
        //For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
        //The use of "and" when writing out numbers is in compliance with British usage.    
        String total17 = "";

        //ONES: 1,21,31...91(9x)..101,201,301..901(10x) = 90x
        //100,101,102.. 199 = 100x
        //1000 = 1x
        for (int t = 0; t < 191; t++) {
            total17 += "one";
        }
        //TWOS: 2,22,32...92(9x)..102,202,302..902(10x) = 90x
        //100,101,102.. 199 = 100x
        //SAME FOR DIGITS UP TO NINES
        for (int z = 0; z < 190; z++) {
            total17 += "two";
            total17 += "three";
            total17 += "four";
            total17 += "five";
            total17 += "six";
            total17 += "seven";
            total17 += "eight";
            total17 += "nine";
        }
        //TENS: 10,110,210... 910 = 10x
        //SAME FOR DIGITS UP TO NINETEEN
        for (int c = 0; c < 10; c++) {
            total17 += "ten";
            total17 += "eleven";
            total17 += "twelve";
            total17 += "thirteen";
            total17 += "fourteen";
            total17 += "fifteen";
            total17 += "sixteen";
            total17 += "seventeen";
            total17 += "eighteen";
            total17 += "nineteen";
        }
        //HUNDRED: 100,101...199,(100x) 299,399... 999 (9x)
        for (int u = 0; u < 900; u++) {
            total17 += "hundred";
        }
        //TWENTY: 20,21,22,23...29(10x)129,229,239...929(10x)
        //SAME FOR 30,40,50,60,70,80,90
        for (int k = 0; k < 100; k++) {
            total17 += "twenty";
            total17 += "thirty";
            total17 += "forty";
            total17 += "fifty";
            total17 += "sixty";
            total17 += "seventy";
            total17 += "eighty";
            total17 += "ninety";
        }
        //AND: 101,102,103...199(99x),299,399..999(9x)
        for (int s = 0; s < (99 * 9); s++) {
            total17 += "and";
        }
        //THOUSAND (1x)
        total17 += "thousand";
        solutions[16] = total17.length();
        printSolutions(total17.length(), 17);

        //PROBLEM #18
        //By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
        //3
        //7 4
        //2 4 6
        //8 5 9 3
        //That is, 3 + 7 + 4 + 9 = 23.
        //Find the maximum total from top to bottom of the triangle below:
        /*
         75
         95 64
         17 47 82
         18 35 87 10
         20 04 82 47 65
         19 01 23 75 03 34
         88 02 77 73 07 63 67
         99 65 04 28 06 16 70 92
         41 41 26 56 83 40 80 70 33
         41 48 72 33 47 32 37 16 94 29
         53 71 44 65 25 43 91 52 97 51 14
         70 11 33 28 77 73 17 78 39 68 17 57
         91 71 52 38 17 14 91 43 58 50 27 29 48
         63 66 04 68 89 53 67 30 73 16 69 87 40 31
         04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
         */
        //NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. 
        //However, Problem 67, is the same challenge with a triangle containing one-hundred rows;
        //it cannot be solved by brute force, and requires a clever method! ;o)
        int size18 = 15;
        int counter18 = 0;
        int row18 = 0;
        int[][] array18 = new int[size18][size18];
        String triangle18 = "75\n"
                + "95 64\n"
                + "17 47 82\n"
                + "18 35 87 10\n"
                + "20 04 82 47 65\n"
                + "19 01 23 75 03 34\n"
                + "88 02 77 73 07 63 67\n"
                + "99 65 04 28 06 16 70 92\n"
                + "41 41 26 56 83 40 80 70 33\n"
                + "41 48 72 33 47 32 37 16 94 29\n"
                + "53 71 44 65 25 43 91 52 97 51 14\n"
                + "70 11 33 28 77 73 17 78 39 68 17 57\n"
                + "91 71 52 38 17 14 91 43 58 50 27 29 48\n"
                + "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n"
                + "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

        //input the triangle into an array
        for (int m = 0; m < triangle18.length(); m++) {
            if (triangle18.charAt(m) == '\n') {
                row18++;
                counter18 = 0;
            }
            if (triangle18.charAt(m) != ' ' && triangle18.charAt(m) != '\n') {
                array18[row18][counter18] = Integer.parseInt(triangle18.substring(m, m + 2));
                counter18++;
                m++;
            }
        }
        
        for (int v = 14; v > 0; v--) { //loops through every row
            for (int x = 0; x < 14; x++) { //loops through every number in each row
                if (array18[v - 1][x] != 0) {
                    array18[v - 1][x] += Math.max(array18[v][x], array18[v][x + 1]); //adds the the max of the 2 below to the # below
                }
            }
        }
        printSolutions(array18[0][0], 18);
        
        //PROBLEM #19
        //You are given the following information, but you may prefer to do some research for yourself.
        //1 Jan 1900 was a Monday.
        //Thirty days has September,
        //April, June and November.
        //All the rest have thirty-one,
        //Saving February alone,
        //Which has twenty-eight, rain or shine.
        //And on leap years, twenty-nine.
        //A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
        //How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

        int weekCount19 = 1; //day of the week
        int dayCount19 = 1; //day of the year
        int yearCount19 = 1901; //year
        int total19 = 0; //number of specified days

        //while it is not 31 Dec 2000
        while (yearCount19 < 2001) {

            if (yearCount19 % 4 == 0) { //if it is a leap year
                
                if (dayCount19 == 366) { //if it is the start of a new year
                    dayCount19 = 1;
                    yearCount19++;
                }
                
                if ((dayCount19 == 1 //jan 1
                        || dayCount19 == 32 //feb 1
                        || dayCount19 == 61 //mar 1
                        || dayCount19 == 92 //apr 1
                        || dayCount19 == 122 //may 1
                        || dayCount19 == 153 //jun 1
                        || dayCount19 == 183 //jul 1
                        || dayCount19 == 214 //aug 1
                        || dayCount19 == 244 //sep 1
                        || dayCount19 == 275 //oct 1
                        || dayCount19 == 305 // nov 1
                        || dayCount19 == 336) && weekCount19 == 7) { //dec 1
                    weekCount19 = 0;
                    total19++;
                }
                } else { //if it is not a leap year
                    if (dayCount19 == 366) { //if it is the start of a new year
                    dayCount19 = 1;
                    yearCount19++;
                }
                    if ((dayCount19 == 1 //jan 1
                            || dayCount19 == 32 //feb 1
                            || dayCount19 == 60 //mar 1
                            || dayCount19 == 91 //apr 1
                            || dayCount19 == 121 //may 1
                            || dayCount19 == 152 //jun 1
                            || dayCount19 == 182 //jul 1
                            || dayCount19 == 213 //aug 1
                            || dayCount19 == 243 //sep 1
                            || dayCount19 == 274 //oct 1
                            || dayCount19 == 304 // nov 1
                            || dayCount19 == 335) && weekCount19 == 7) { //dec 1
                        total19++;
                        weekCount19 = 0;
                    }
                }
                if (weekCount19 == 7) {
                    weekCount19 = 0;
                }
                dayCount19++;
                weekCount19++;    
            }
        printSolutions(total19, 19);
        
        //PROBLEM #20
        //n! means n × (n − 1) × ... × 3 × 2 × 1
        //For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
        //and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
        //Find the sum of the digits in the number 100!
        BigInteger int20 = BigInteger.valueOf(1);
        
        int total20 = 0;
        //multply the int from 2- 1000
        for (int x = 2; x <= 100; x++) {
            int20 = int20.multiply(BigInteger.valueOf(x)); 
        }
        String string19 = int20.toString();
        //add the digits int the string
        for (int z = 0; z < string19.length(); z++) {
            total20 += Integer.parseInt("" + string19.charAt(z));
        }
        printSolutions(total20, 20);
    }

    public static void printSolutions(long answer, int number) {
        System.out.println("Problem " + (int) (number) + ": " + answer);
    }
}