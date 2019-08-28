package Procon;

public class Map {
    private int width;
    private int height;
    private int[][] points;
    private int startedAtUnixTime;
    private int turn;
    private int[][] tiled;
    private int []actions;
    private Teams []teams;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Teams[] getTeams() {
        return teams;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getPoints() {
        return points;
    }

    public int getStartedAtUnixTime() {
        return startedAtUnixTime;
    }

    public int getTurn() {
        return turn;
    }

    public int[][] getTiled() {
        return tiled;
    }

    public int[] getActions() {
        return actions;
    }


}
