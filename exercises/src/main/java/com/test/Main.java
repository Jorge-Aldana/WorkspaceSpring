package com.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println(QuestionsMarks("acc?7??sss?3rr1??????5"));

        int[] i = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        HashMap<String, String> map = new HashMap<>();

        Set<Entry<String, String>> entrySet = map.entrySet();


    }

    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            return false;
        }
        return true;
    }

    public static int validateSublist(int[] list){

        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        int minSize = 0;
        int counter = 1;

        for (int i = 1; i < list.length; i++) {
            if(list[i] - list[i - 1] == 1) {
                counter++;
            } else {
                System.out.println("Counter: " + counter);
                if (counter > minSize ) {
                    minSize = counter;
                    System.out.println("New minSize found: " + minSize);
                }
                counter = 1;
            }
        }
        System.out.println("Final Counter: " + counter);
        return counter > minSize ? counter : minSize;
    }

    public static int FSerie(int n){
        if(n<=0){
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return FSerie(n - 1) + FSerie(n - 2);
        }
    }

    private static int FSerieMemoization(int n, int[] memo) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = FSerieMemoization(n - 1, memo) + FSerieMemoization(n - 2, memo);
        return memo[n];
    }
    public static int FSerieMemoization(int n) {
        int[] memo = new int[n + 1];
        return FSerieMemoization(n, memo);
    }

    public static long FSerieIterative(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        long a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public static String FindIntersection(String[] strArr) {
    // code goes here  
    HashMap<Integer,Integer> counts = new HashMap<>();
    Arrays.stream(strArr[0].split(",")).forEach(s->{
      int c = Integer.parseInt(s.trim());
      counts.put(c,counts.get(c)!=null?counts.get(c)+1:1);});

    String j = Arrays.stream(strArr[1].split(",")).filter(s-> {
      int i = Integer.parseInt(s.trim());
      return counts.get(i)!=null;
      }
      ).collect(Collectors.joining(","));

    return j;
  }

  public static String LongestWord(String sen) {
    // code goes here 
    String res = Pattern.compile("[A-Za-z0-9]+")  // Cambié * por + (una o más letras)
      .matcher(sen)
      .results()  // Stream de MatchResult
      .map(MatchResult::group)  // Extrae las coincidencias
      .max(Comparator.comparing(String::length))  // Encuentra la más larga
      .orElse("");
    return res;
  }
  public static String QuestionsMarks(String str) {
    int qmCounter = 0;
        int digit1 = -1;
        boolean foundValidPair = false;
        
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                if (digit1 == -1) {
                    // Primer dígito encontrado
                    digit1 = Character.getNumericValue(c);
                    qmCounter = 0; // Reiniciar contador
                } else {
                    // Segundo dígito encontrado
                    int digit2 = Character.getNumericValue(c);
                    
                    if (digit1 + digit2 == 10) {
                        foundValidPair = true;
                        if (qmCounter != 3) {
                            return "false";
                        }
                    }
                    
                    // Preparar para siguiente par
                    digit1 = digit2;
                    qmCounter = 0;
                }
            } else if (c == '?') {
                qmCounter++;
            }
        }
        
        return foundValidPair ? "true" : "false";
  }

  public static int stepsOrder(int n, int[] A, String s){

    int res = 0;

    for (int i = 1; i < A.length; i++) {
        int bitAnterior = getBit(s, i - 1);

      if (getBit(s, i) == 0 && bitAnterior == 1 && A[i] > A[i - 1]) {
        res ++;
      }
    }

    return res;
  }

  public static int getBit(String s, int i) {
    return Integer.parseInt(String.valueOf(s.charAt(i)));
  }
  
}