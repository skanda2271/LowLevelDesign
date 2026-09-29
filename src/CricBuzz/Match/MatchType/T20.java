package CricBuzz.Match.MatchType;

public class T20 implements MatchType{
    @Override
    public int noOfOvers() {
        return 20;
    }

    @Override
    public int maxOverCountBowlers() {
        return 4;
    }
}
