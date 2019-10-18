public class King extends Figures{

    private String color;
    private int x;
    private int y;

    public King(String color, int x, int y){
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getColor(){
        return this.color;
    }

    public void changePosition(int x, int y){
        this.x = x;
        this.y = y;
    }

}
