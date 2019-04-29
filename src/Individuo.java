/**
 * @brief Clase que permite representar un individuo (posible solución)
 *  en el contexto del algoritmo genético. Son círculos.
 *
 * @author  Geovanny Cordero Valverde   (geovanny.corderovalverde@ucr.ac.cr)
 * @author  Carlos Delgado Rojas        (carlos.delgadorojas@ucr.ac.cr)
 * @author  Jimmy Acuña Díaz            (TODO agregar acá su email please)
 */
public class Individuo {
    /**
     *  Coordenada en X del centro
     */
    private int x;

    /**
     *  Coordenada en Y del centro
     */
    private int y;

    /**
     *  Longitud del radio
     */
    private int radio;

    /**
     *  Constructor por default
     */
    public Individuo(){

    }

    /**
     *  Constructor con parámetros
     * @param x coordenada en X del centro
     * @param y coordenada en Y del centro
     * @param r longitud del radio
     */
    public Individuo(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.radio = r;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @param radio
     */
    public void setRadio(int radio) {
        this.radio = radio;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return
     */
    public int getRadio() {
        return radio;
    }
}
