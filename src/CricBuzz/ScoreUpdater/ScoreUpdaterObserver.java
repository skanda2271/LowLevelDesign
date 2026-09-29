package CricBuzz.ScoreUpdater;

import CricBuzz.Innings.BallDetails;

public interface ScoreUpdaterObserver {
    public void update(BallDetails ballDetails);
}
