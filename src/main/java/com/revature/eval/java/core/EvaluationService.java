package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.time.*;
import java.time.temporal.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import javax.xml.stream.events.Characters;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		// TODO Write an implementation for this method declaration
		
		
		String revString= new String();
		
		for(int i = string.length()-1; i>= 0; i--) {
			revString +=string.charAt(i);
		}
		return revString;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String newPhrase= phrase.replaceAll("-", " ");
		String acro = new String();
		acro+= newPhrase.charAt(0);
		int i=1;
		while(newPhrase.length() > i) {
			char space=' ';
			if (newPhrase.charAt(i) == space && i != newPhrase.length()-1)
			{
				acro+=newPhrase.charAt(i+1);
				i++;
			}
			else {
				i++;
			}
			
		}
		
		acro=acro.toUpperCase();
		//System.out.println(acro);
		
		return acro;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			boolean isEq;
			if(this.sideOne == this.sideTwo && this.sideTwo == this.sideThree && this.sideOne== this.sideThree) {
				isEq=true;
			}
			else {
				isEq=false;
			}
			return isEq;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			boolean isIso;
			if( this.sideOne== this.sideTwo || this.sideOne == this.sideThree|| this.sideTwo== this.sideThree) {
				isIso=true;
			}
			else
				isIso=false;
			return isIso;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			boolean isSca= (this.isEquilateral() || this.isIsosceles()) ? false: true;
			
			return isSca;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		/*
		HashMap<Character, Integer > onePoint= new HashMap<>();
		onePoint.put(Character.valueOf('A'), 1);
		onePoint.put(Character.valueOf('E'), 1);
		onePoint.put(Character.valueOf('I'), 1);
		onePoint.put(Character.valueOf('O'), 1);
		onePoint.put(Character.valueOf('A'), 1);
		*/
		
		int counter=0;
		char[] onePoint= {'A','E','I','O','U','L','N','R','S','T'};
		char[] twoPoint= {'D','G'};
		char[] threePoint= {'B','C','M','P'};
		char[] fourPoint= {'F','H','V','W','Y'};
		char[] fivePoint= {'K'};
		char[] eightPoint= {'J','X'};
		char[] tenPoint= {'Q','Z'};
		String bucket= new String();
		String caps=string.toUpperCase();
		int score=0;
		while (counter<string.length()) {
			
			for(char h: onePoint)
				if(h==caps.charAt(counter)) {
					bucket="One Point";
					System.out.println("Letter in: " +bucket+" bucket");
					break;
				}
			for(char h: twoPoint)
				if(h==caps.charAt(counter)) {
					System.out.println("Letter in 2pt bucket");
					bucket="Two Point";
					break;
				}
			for(char h: threePoint)
				if(h==caps.charAt(counter)) {
					System.out.println("Letter in 3pt bucket");
					bucket="Three Point";
					break;
				}
			for(char h: fourPoint)
				if(h==caps.charAt(counter)) {
					System.out.println("Letter in 4pt bucket");
					bucket="Four Point";
					break;
				}
			for(char h: fivePoint)
				if(h==caps.charAt(counter)) {
					bucket="Five Point";
					System.out.println("Letter in 5pt bucket");
					break;
				}
			for(char h: eightPoint)
				if(h==caps.charAt(counter)) {
					System.out.println("Letter in 8pt bucket");
					bucket="Eight Point";
					break;
				}
			for(char h: tenPoint)
				if(h==caps.charAt(counter)) {
					System.out.println("Letter in 10pt bucket");
					bucket="Ten Point";
					break;
				}
			
			
			switch(bucket){
			
				case "One Point":{
					score+=1;
					counter++;
					System.out.println("A point has been added "+ score);
					break;
				}
				
				case "Two Point":{
					score+=2;
					counter++;
					System.out.println(score);
					break;
				}
				case "Three Point":
				{
					score+=3;
					counter++;
					System.out.println(score);
					break;
					
				}
				case "Four Point":
				{
					score+=4;
					counter++;
					System.out.println(score);
					break;
				}
				case "Five Point":
				{
					score+=5;
					counter++;
					System.out.println(score);
					break;
				}
				case "Eight Point":
				{
					score+=8;
					counter++;
					System.out.println(score);
					break;
				}
				case "Ten Point":
				{
					score+=10;
					counter++;
					System.out.println(score);
					break;
				}
				default: 
					counter++;
					System.out.println(score);
			
			}//end switch
			//counter++;
		} //end whileloop
			
		System.out.println(score);
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		String noPunc= string;
		
		String result= new String();
		 noPunc=noPunc.replace(".", "");
		 noPunc= noPunc.replace("-", "");
		 noPunc= noPunc.replace("(", "");
		 noPunc= noPunc.replace(")", "");
		 noPunc= noPunc.replace("_", "");
		 noPunc= noPunc.replace(" ", "");
		// noPunc= noPunc.replaceAll("@", "");
		 noPunc= noPunc.replace(":", "");
		 noPunc= noPunc.replace("!", "");
		 System.out.println(noPunc);
		 //this iteration should have no punctuation left
		 if(noPunc.contains("a")) {
			 throw new IllegalArgumentException();
		 }
		 else if(noPunc.contains("@")) {
			 throw new IllegalArgumentException();
		 }
		 else if(noPunc.length()>11 || noPunc.length() < 10) {
			 throw new IllegalArgumentException();
		 }
		 
		 else if (noPunc.startsWith("1")) {
					// noPunc=noPunc.re
				 noPunc=noPunc.replaceFirst("1", "");
				 }
		 else
			 result=noPunc;
		 
		 System.out.println(result);
		 return result;
		 

	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		Map<String, Integer> result= new HashMap<>();
		
		String cleanString= string;
		cleanString =cleanString.replace(",\n", ",");
		//System.out.println(cleanString);	
		char[] charArr=cleanString.toCharArray(); //creates char array allowing us to iterate though it
		//System.out.println(charArr);
		String wholeWord= new String();
		int index1=0;
		int index2=0;
		Integer wordCount=1;
		
		//nested while loops
		for (char c: charArr) {
			if(c==' ' || c==',' || index2>=cleanString.length()-1){ //dont count any starting spaces
				if(index2>=cleanString.length()-1) {
					wholeWord=cleanString.substring(index1, index2+1);
				}
				else {
					wholeWord=cleanString.substring(index1, index2);
				}
				
				index1=index2+1;
				//System.out.println("word is: "+ wholeWord);
				//prints the complete word it has found to the console
				if( result.containsKey(wholeWord)) {
					wordCount=result.get(wholeWord)+1;
					result.put(wholeWord, wordCount);
				//	System.out.println(result.keySet());
					//System.out.println(result.values());
					wordCount=1;	
				}
				else {
					result.put(wholeWord, wordCount);
					System.out.println(result.keySet());
					System.out.println(result.values());
				}
			}
			index2++;
		}
		//System.out.println(result.);
		return result;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			//LinkedList<T> el = new LinkedList();
			//sortedList.
			String w="w";
			
			
			Comparator<T> c = new Comparator<T>() {
				@Override
				public int compare(T a, T b) {
					// TODO Auto-generated method stub
					if(t instanceof String)
					{
					return ((String) a).compareTo((String) b);
					}
					else {
						return ((Integer) a).compareTo((Integer) b);
					}
				}};
				
				
			   //   sortedList.sort(c);
			
			      
			
			
			
		
	
			//sortedList.indexOf(t);
			//that works
			return Collections.binarySearch(sortedList, t, c);
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	
 
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		//a, e, i , o ,u + ay
		// consonants, first_letter +ay
		String worker="";
		char mover;
		char[] charArr=string.toCharArray();
		String[] input=string.split(" ");
		
		int str=0;
		int count=0;
		LinkedList <Character> vowels = new LinkedList<Character>();
		vowels.addLast('a');
		vowels.addLast('e');
		vowels.addLast('i');
		vowels.addLast('o');
		vowels.addLast('u');
		
for(String s:input) {
			
			
			//old execution
			if(vowels.contains(s.charAt(0))) {
				
				worker=s+"ay";
				str++;
			}
			else {
				for(char c:charArr) {
					if(vowels.contains(c)) {
						break;
					}
					else {
						
						count++;
					}
				}
					int i=count;
					charArr=s.substring(count).toCharArray();
					
					for(char r: charArr) {
						worker+=r;
					}
					for(int j=0;j<count;j++) {
						worker+=s.charAt(j);
					}
					worker+="ay";
					str++;
				}
			if(str<input.length) {
				worker+=" ";
			}
			}
				return worker;
			///worker=string.substring(count)+string.charAt(0)+"ay";
		}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		boolean answer=false;
		int sum=0;
		int digitSum=0;
		String inputString=Integer.toString(input);
		int[] digits= new int[inputString.length()];
		
		if(inputString.length()>1) {	
			for(int i=0; i<inputString.length(); i++) {
				digits[i]=Character.getNumericValue(inputString.charAt(i));
				digitSum=digits[i];
					for(int j=1;j<inputString.length();j++) {					
						digitSum=digitSum*digits[i];
					}
				sum+=digitSum;
			}
			answer = (sum==input)? true:false; 
		}//only for numbers of more than one digit
		else {
			answer=true;
		}//for one digit numbers, 0-9
		  return answer;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		 
		//Scanner sc= new Scanner(System.in);
		Long num=l;
		List <Long> digits= new ArrayList<>();
		int count=3;
		
		//for even inputs, keep until no longer divisble by 2
        while (num%2==0)
        {
            num /= 2;
            digits.add((long) 2);
        }
 
 //for odd input
        	while(count<= Math.sqrt(num)){
        		//run up to the square root of the number
	            while (num%count == 0)
	            	//as long as this num is divisble by another odd, keep going
	            {
	                num /= count;
	                if(count>1)
	                {
	                	digits.add((long) count);
	                }//dont add 1 to the list bc it isnt a prime
	            }
            count+=2;
        }
 
//input is a prime num >2
        if (num > 2)
        {
			digits.add(num);
        }
		return digits;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			//should return the same punctuation and whitespaces
			//only letters should be rotated
		
			
		//	Collections.sort(lowerArr);
//			int index1=0;
//			int index2=0;
			 StringBuffer delta= new StringBuffer();
			 String answer= new String();
			 int upperCase=65;
			 int lowerCase=97; //ascii values for lowercase 
			 char upperChar;
			 char lowerChar;
			 
			 
	        for (int i=0; i<string.length(); i++)
	        {
	        	//check for letters
	        	if((int)string.charAt(i)<upperCase || 
	        			(int)string.charAt(i)> lowerCase+25|| 
	        			(  (int)string.charAt(i) >90 &&(int)string.charAt(i)<97)   )	        		
	        	{
	        		delta.append(string.charAt(i));
		            
	        	}
	        	else {
	        		if (Character.isUpperCase(string.charAt(i)))
		            {
		                upperChar = (char)( ((int)string.charAt(i)+key-upperCase)%26 +upperCase);
		                //mod takes care of the useless keys 0 and 26
		                delta.append(upperChar);
		            }
		            else
		            {
		                lowerChar = (char)( ((int)string.charAt(i)+key-lowerCase)%26 +lowerCase);
		                delta.append(lowerChar);
		            }
	        	}
	        }
	        answer=delta.toString();
	        return answer;
			

		
		}
		
 
		

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		
		//how to find out if the current number is prime
		if(i==0) {
			throw new IllegalArgumentException();
		}
		Vector<Integer> primes= new Vector<>();
		int j=2;
		boolean prime =true;
		while (primes.size()<i) {		
			for(int h = 2; h < j; ++h) {
		        if (j % h == 0) {
		            // We are naive, but not stupid, if
		            // the number has a divisor other
		            // than 1 or itself, we return immediately.
		            prime= false;
		            break;
		        }
		        prime=true;
		    }
		    //is a prime no
			if (prime)
			{
			primes.add(j);
			}
			j++;
		}
		
	    int index=primes.size();
	    int answer=primes.get(index-1);
	    System.out.println(primes);
	    
		return answer;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in  groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			
			HashMap<Character, Character> bet= new HashMap<>();
			bet.put('a', 'z');
			bet.put('b', 'y');
			bet.put('c', 'x');
			bet.put('d', 'w');
			bet.put('e', 'v');
			bet.put('f', 'u');
			bet.put('g', 't');
			bet.put('h', 's');
			bet.put('i', 'r');
			bet.put('j', 'q');
			bet.put('k', 'p');
			bet.put('l', 'o');
			bet.put('m', 'n');
			bet.put('n', 'm');
			bet.put('o', 'l');
			bet.put('p', 'k');
			bet.put('q', 'j');
			bet.put('r', 'i');
			bet.put('s', 'h');
			bet.put('t', 'g');
			bet.put('u', 'f');
			bet.put('v', 'e');
			bet.put('w', 'd');
			bet.put('x', 'c');
			bet.put('y', 'b');
			bet.put('z', 'a');
			
			
//			//similar to Caesar cipher
//			int shift=25;
			char delta;
//			int lower=97;
			StringBuilder bash= new StringBuilder();
			String small=string.toLowerCase();
			int count=0;
			for (int i=0; i<small.length();i++) {		
				if(count ==5 && i<small.length()-1) {
					bash.append(" ");
					count=0;
				}
				if(small.charAt(i) > 96 && small.charAt(i) <123 ) {
					delta=bet.get(small.charAt(i));
					bash.append(delta);
					System.out.println(delta);
					count++;
				}
				else if(small.charAt(i) >47 && small.charAt(i)<58 ){
					//if its a number
					bash.append(small.charAt(i));
					count++;
				}
				else
				{}
			}
			return bash.toString();
			
		}
			
			

		

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			HashMap<Character, Character> bet= new HashMap<>();
			bet.put('a', 'z');
			bet.put('b', 'y');
			bet.put('c', 'x');
			bet.put('d', 'w');
			bet.put('e', 'v');
			bet.put('f', 'u');
			bet.put('g', 't');
			bet.put('h', 's');
			bet.put('i', 'r');
			bet.put('j', 'q');
			bet.put('k', 'p');
			bet.put('l', 'o');
			bet.put('m', 'n');
			bet.put('n', 'm');
			bet.put('o', 'l');
			bet.put('p', 'k');
			bet.put('q', 'j');
			bet.put('r', 'i');
			bet.put('s', 'h');
			bet.put('t', 'g');
			bet.put('u', 'f');
			bet.put('v', 'e');
			bet.put('w', 'd');
			bet.put('x', 'c');
			bet.put('y', 'b');
			bet.put('z', 'a');
			char delta;
//			int lower=97;
			StringBuilder bash= new StringBuilder();
			String small=string.toLowerCase();
			int count=0;
			for (int i=0; i<small.length();i++) {		
				
				if(small.charAt(i) > 96 && small.charAt(i) <123 ) {
					delta=bet.get(small.charAt(i));
					bash.append(delta);
					System.out.println(delta);
					count++;
				}
				else if(small.charAt(i) >47 && small.charAt(i)<58 ){
					//if its a number
					bash.append(small.charAt(i));
					count++;
				}
				else
				{}
			}
			return bash.toString();
			
			
			//return null;
		}
		
	}
	

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		String h=string;
		String clean =h.replace("-", "");
		System.out.println(clean);
		boolean result=false;
		int sum=0;
		int count=10;
		//int r=0;
		HashSet<String> valids= new HashSet<>();
		valids.add("X");
		valids.add("0");
		valids.add("1");
		valids.add("2");
		valids.add("3");
		valids.add("4");
		valids.add("5");
		valids.add("6");
		valids.add("7");
		valids.add("8");
		valids.add("9");
	
		
		for (int i=0; i< clean.length();i++) {
			if( valids.contains(String.valueOf(clean.charAt(i)))) {
				if(clean.charAt(i) =='X') {
					System.out.println(true);
					sum+=10;	
				}
				else {
					sum+= Integer.parseInt(String.valueOf(clean.charAt(i))) *(count);
				}
				count--;
				System.out.println(sum);
				
			}
			else {
				
				return false;
			}		
		}
		return (sum%11==0) ? true:false;
//		String.va)
//		char [] is= string.toCharArray();
//		for(char c:is) {
//			if((int) String.valueOf(c) <1  ) {
//				
//			}
		
		
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		String clean=string.replace(" ", "");
		clean=clean.toLowerCase();
		boolean [] haha= new boolean[26];
		char [] input=string.toCharArray();
		char [] alpha= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int indexA=0;
		int count=0;
		
		for (int i=0;i<clean.length();i++) {
			for(int j=0;j<26;j++) {
				if(clean.charAt(i)==alpha[j])
				{
					haha[j]=true;
				}
			}
		}
		
		for(int k=0;k<26;k++) {
			if(haha[k]==false)
			{
				return false;
			}
		}
		
		
		
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
	
		//LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59);
		//LocalDate hey =LocalDate.of(2011, Month.APRIL, 25);

		
		//hey=hey.plus(1000000000, ChronoUnit.SECONDS);
		//Temporal yes;
		Temporal yup= given;
		//given.plus(1000000000, ChronoUnit.SECONDS);
		if(given.isSupported(ChronoUnit.SECONDS))
		{
			//yes=given;
			yup=((LocalDateTime) yup).plusYears(31);
			yup=((LocalDateTime) yup).plusWeeks(35);
			yup=((LocalDateTime) yup).plusDays(6);
			yup=((LocalDateTime) yup).plusHours(1);
			yup=((LocalDateTime) yup).plusMinutes(46);
			yup=((LocalDateTime) yup).plusSeconds(40);
	
				return yup;
			
		}
		else {
			yup=((LocalDate) yup).plusYears(31);
			yup=((LocalDate) yup).plusWeeks(35);
			yup=((LocalDate) yup).plusDays(6);
			
	
			LocalDateTime now =((LocalDate) yup).atTime(0, 0, 0);
			now=now.plusHours(1);
			now=now.plusMinutes(46);
			now=now.plusSeconds(40);
				System.out.println(given);
				System.out.println(now);
				return now;
		}
					
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		
		/*
		 * for every int in the set, mod each number, increasing by one
		 * if the current number is divisible by any of the numbers in the set , save it, then add them all up
		 */
		//StringBuilder mults= new StringBuilder();
		//Vector<String> sum= new Vector<>();
		HashSet<Integer> yup= new HashSet();
		int sum=0;
		
		//mults.
		
//		for(int h:set) {
//			mults.append(h);
//		}
		
		int count=0;
		while(count <i) {
			//do stuff
			for(int j:set) {
				if(count%j ==0) {
					//sum.add(count);	
					yup.add(count);
				}
			}
			count++;
		}
		
		for(Integer q:yup) {
			sum+=q;
		}
//		Iterator sumIt= yup.iterator();
//		while(sumIt.hasNext()) {
//			sum+=sumIt.
//			sumIt.next();
//		}
		
		
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		HashSet<Character> check= new HashSet<>();
		check.add('1');
		check.add('2');
		check.add('3');
		check.add('4');
		check.add('5');
		check.add('6');
		check.add('7');
		check.add('8');
		check.add('9');
		check.add('0');
		
		
		String clean=string.replace(" ", "");
		System.out.println(clean);
	//	char [] working=string.toCharArray();
		int length = clean.length();
		int sum=0;
		int dbl; 
	    int nSum = 0;
	    boolean thisOne = false;
	    for (int i = length - 1; i >= 0; i--) 
	    {	
	    	if( check.contains(
	    					clean.charAt(i)) ) {
	    		
		        if (thisOne == true)
		        {
		        	 dbl= Integer.parseInt( String.valueOf(clean.charAt(i)))  * 2;
		        	dbl= (dbl>9)? dbl-9:dbl;
		        	sum+=dbl;
		        	System.out.println(dbl);
		        	
		        }
		        sum+=Integer.parseInt( String.valueOf(clean.charAt(i)));
		        thisOne = !thisOne;
	    	}
	    	else {
	    		return false;
	    	}
	    }
	    return (sum % 10 == 0);
		
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		return 0;
	}
	
}
