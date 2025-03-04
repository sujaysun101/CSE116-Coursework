public class Character {
    private int battlesWon;
    private int xpPts;
    public Character() {
        this.battlesWon = 0;
        this.xpPts = 0;
    }
    public void winBattle(int xp) {
        this.battlesWon++;
        this.xpPts += xp;
    }
}
