package Lab2.ex2;

import java.util.Random;

public class Vers{

    public String processedVerse_;
    private final String verse_;

    private int wordSum_=0;
    private int vowelSum_=0;
    static private final String vowels_ = "aeiou";
    private final double generatedNumber_ = new Random().nextDouble(100)/100;

    Vers(String vers,String chosenWord)
    {
        calculateSums(vers);
        verse_ =vers;
        processVerse(chosenWord);
    }

    public void processVerse(String chosenWord){
        processedVerse_= verse_;
        if(generatedNumber_< 0.1) processedVerse_ = processedVerse_.toUpperCase();
        processedVerse_+=" "+wordSum_+" "+vowelSum_;
        if(processedVerse_.contains(chosenWord)) processedVerse_+=" *";
    }

    public int getWordCount(){
        return wordSum_;
    }
    public int getVowelCount(){
        return vowelSum_;
    }
    private void calculateSums(String vers){
        for(var charr : vers.toLowerCase().toCharArray()){
            vowelSum_ = vowels_.indexOf(charr) == -1 ? vowelSum_ : vowelSum_+1;
        }
        wordSum_ = vers.split(" ").length;
    }

}
