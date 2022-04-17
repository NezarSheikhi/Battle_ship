/*
    Author_1: <Nezar Sheikhi>
*/
package Model;

public abstract class Ship {
    private int x;
    private boolean horizontal;

    public Ship(int x,boolean horizontal){
        this.x = x;
        this.horizontal = horizontal;
    }

    public int getX() {
        return x;
    }


    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

}
