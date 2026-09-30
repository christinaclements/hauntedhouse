public class HauntedHouse {
    private boolean ghostPresent;
    private int candyCount;

    public HauntedHouse() {
        ghostPresent = true;
        candyCount = 10;
    }

    public boolean isGhostPresent() {
        return ghostPresent;
    }

    public void scareAwayGhost() {
        ghostPresent = false;
    }

    public void refillCandyBowl(int amount) {
            if (amount >= 0) {
                candyCount += amount;
            }
    }

    public void trickOrTreat(int people){
        if (people <= candyCount && people >= 0) {
            candyCount = candyCount - people;
        }
        runningLow();
    }

    public int getCandyCount() {
        return candyCount;
    }

    public String spookySound() {
        return "Boo!";
    }

    public void runningLow() {
        if (candyCount == 0){
            refillCandyBowl(10);
        }
    }

    public void haunting() {
        if (!isGhostPresent()){
            ghostPresent= true;
        }
    }

    @Override
    public String toString() {
        String result = "The house ";

        if(isGhostPresent()) {
            result += "is haunted by a Ghost and ";
        }
        result += "has " + candyCount + " candy.";
        return result;
    }
}

