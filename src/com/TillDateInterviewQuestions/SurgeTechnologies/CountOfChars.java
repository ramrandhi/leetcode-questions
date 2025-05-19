package com.TillDateInterviewQuestions.SurgeTechnologies;

public class CountOfChars {
    public static void main(String[] args) {
        findNumberOfSpecificChars("JH$%^8785GUY$%^gUHG88u");
    }

    static void findNumberOfSpecificChars(String str) {
        String alphabets = str.replaceAll("[^a-zA-Z]","");
        String numbers = str.replaceAll("[^0-9]","");
        System.out.println("Alphabets : " + alphabets.length());
        System.out.println("Numbers : " + numbers.length());
        System.out.println("Special Characters : " + (str.length() - (alphabets.length() + numbers.length())));
    }
}
