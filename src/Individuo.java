public class Individuo {
    private int x;
    private int y;
    private int radio;

    public Individuo(){}

    public Individuo(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.radio = r;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadio() {
        return radio;
    }
}
