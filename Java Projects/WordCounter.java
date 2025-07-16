import java.util.*;
public class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isValidInput = false;
        String User_Input;
        do {
            System.out.print("Enter The String : ");
            User_Input = sc.nextLine();
            if(User_Input.isEmpty()) {
                System.out.println("Error: Empty input. Please enter a non-empty text.");
            }
            else isValidInput = true;
        }
        while(!isValidInput);

        List<String> stopWords = Arrays.asList("the", "and", "is", "of", "in", "a", "to", "for", "with", "on");

        String wordsArray[] = User_Input.split("[\\s\\p{Punct}]+");

        String[] uniqueWords = new String[wordsArray.length];
        int[] wordFrequencies = new int[wordsArray.length];
        int uniqueWordCount = 0;
        int count = 0;
        for(String Word : wordsArray) {
            count++;
            String lowercaseWords = Word.toLowerCase();
            if(stopWords.contains(lowercaseWords )) {
                continue;
            }
            boolean Found = false;
            for(int i=0; i<uniqueWordCount; i++) {
                if(uniqueWords[i].equals(lowercaseWords)) {
                    wordFrequencies[i]++;
                    Found = true;
                    break;
                }
            }
            if(!Found) {
                uniqueWords[uniqueWordCount] = lowercaseWords;
                wordFrequencies[uniqueWordCount] = 1;
                uniqueWordCount++;
            }
        }
        System.out.println("Total no of Words : "+count);
        System.out.println("Number of Unique Words: " + uniqueWordCount);
        System.out.println("Word Frequencies:");
        for (int i = 0; i < uniqueWordCount; i++) {
            System.out.println(uniqueWords[i] + ": " + wordFrequencies[i]);
        }
    }
}
