import java.lang.reflect.Array;

public class Palindrome {

    public Deque<Character> wordToDeque(String word){

        LinkedListDeque<Character> newList = new LinkedListDeque<Character>();

        for(int i=0; i<word.length();i++){
            newList.addLast(word.charAt(i));
        }
        return newList;
    }

    public boolean isPalindrome(String word){
        Deque<Character> newList = wordToDeque(word);
        while (newList.size() > 1) {
            if (newList.removeFirst() != newList.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> newList = wordToDeque(word);
        while (newList.size() > 1) {
            if(!cc.equalChars(newList.removeFirst(), newList.removeLast())){
                return false;
            }
        }
        return true;
    }
}
