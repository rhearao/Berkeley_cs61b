
public class OffByN implements CharacterComparator {
    private int n;
    //constructor
    public OffByN(int i){
        n = i;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return (Math.abs(x-y) == n);
    }
}
