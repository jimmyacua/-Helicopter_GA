import java.util.ArrayList;
/**
 * @brief Clase que permite representar un Obstáculo en el contexto del algoritmo genético.
 *
 * @author  Geovanny Cordero Valverde   (geovanny.corderovalverde@ucr.ac.cr)
 * @author  Carlos Delgado Rojas        (carlos.delgadorojas@ucr.ac.cr)
 * @author  Jimmy Acuña Díaz            (TODO agregar acá su email please)
 */
public class Obstaculo {
    /**
     *
     */
    private ArrayList<Integer> x;

    /**
     *
     */
    private ArrayList<Integer> y;

    /**
     *
     */
    public Obstaculo(){
        x = new ArrayList<>();
        y = new ArrayList<>();
    }

    /**
     *
     * @param xs
     * @param ys
     */
    public Obstaculo(ArrayList<Integer> xs, ArrayList<Integer> ys){
        x = xs;
        y = ys;
    }

    /**
     *
     * @param individuo
     * @return
     */
    public boolean hayInterseccion(Individuo individuo){
        //TODO
        return false;
    }
}
