package CricBuzz.Match;

public class PlayerDetails {
    public Player person;
    public Role playerType;
    public BattingScoreCard battingScoreCard;
    public BowlingScoreCard bowlingScoreCard;

    public PlayerDetails(Player person, Role playerType) {
        this.person = person;
        this.playerType = playerType;
        battingScoreCard = new BattingScoreCard();
        bowlingScoreCard = new BowlingScoreCard();
    }

    public void printBattingScoreCard() {
        System.out.println("PlayerName: " + person.name + " -- totalRuns: " + battingScoreCard.totalRuns
                + " -- totalBallsPlayed: " + battingScoreCard.totalBallsPlayed + " -- 4s: " + battingScoreCard.totalFours
                + " -- 6s: " + battingScoreCard.totalSix + " -- outby: " + ((battingScoreCard.wicketDetails != null) ? battingScoreCard.wicketDetails.takenBy.person.name : "notout"));
    }

    public void printBowlingScoreCard() {
        System.out.println("PlayerName: " + person.name + " -- totalOversThrown: " + bowlingScoreCard.totalOversCount
                + " -- totalRunsGiven: " + bowlingScoreCard.runsGiven + " -- WicketsTaken: " + bowlingScoreCard.wicketsTaken);
    }
}
