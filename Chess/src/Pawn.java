public class Pawn extends Figures {

    private String color;
    private int x;
    private int y;

    public Pawn(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getColor(){
        return this.color;
    }

}
