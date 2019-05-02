/**
 * @brief Clase principal para la ejecución del algoritmo genético.
 *
 * @author  Geovanny Cordero Valverde   (geovanny.corderovalverde@ucr.ac.cr)
 * @author  Carlos Delgado Rojas        (carlos.delgadorojas@ucr.ac.cr)
 * @author  Jimmy Acuña Díaz            (jimmy.acuna@ucr.ac.cr)
 */
public class Main {
    /**
     * Main
     * @param args args
     */
    public static void main(String[] args){
        // TODO
        //Obstaculo obstaculo = new Obstaculo(3,9);
        AG ag = new AG(100,20,20,20,100, 2);
        ag.generarPoblacionInicial();
        ag.seleccionar();
    }
}