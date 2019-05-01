import java.lang.Math;
/**
 * @brief Clase que permite representar un Obstáculo en el contexto del algoritmo genético.
 *
 * @author  Geovanny Cordero Valverde   (geovanny.corderovalverde@ucr.ac.cr)
 * @author  Carlos Delgado Rojas        (carlos.delgadorojas@ucr.ac.cr)
 * @author  Jimmy Acuña Díaz            (TODO agregar acá su email please)
 */
public class Obstaculo {
    /**
     *  Coordenada en eje X de la esquina inferior izquierda
     */
    private int x;

    /**
     * Coordenada en eje Y de la esquina inferior izquierda
     */
    private int y;

    /**
     *  Ancho del rectangulo
     */
    private double ancho;

    /**
     *  Largo del rectangulo
     */
    private double largo;

    /**
     *  Constructor por defecto
     * @param x coordena en eje x de la esquina inferior izquierda
     * @param y coordena en eje y de la esquina inferior izquierda
     * @param ancho ancho del rectangulo
     * @param largo largo del rectangulo
     */
    public Obstaculo(int x, int y, double ancho, double largo){
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.largo = largo;
    }

    /**
     *  Dado un individuo, permite saber si este colisiona con el obstaculo o no.
     * @param individuo individuo para analizar
     * @return true si hay colisión, false en caso contrario
     */
    public boolean hayInterseccion(Individuo individuo){
        double puntox = this.x;
        double puntoy = this.y;
        boolean intersecado = false;

        // recorrido de la linea inferior del rectangulo
        intersecado = buscarInterseccionEjeX(individuo,puntox,puntoy);
        if(intersecado){
           individuo.incrementarColisiones();
           return true;
        }
        //recorrido de la linea lateral izquierda
        intersecado = buscarInterseccionEjeY(individuo,puntox,puntoy);
        if(intersecado){
            individuo.incrementarColisiones();
            return true;
        }
        // recorrido de la linea superior del rectangulo
        puntoy = this.y + this.largo;
        intersecado = buscarInterseccionEjeX(individuo,puntox,puntoy);
        if(intersecado){
            individuo.incrementarColisiones();
            return true;
        }
        //recorrido de la linea lateral derecha
        puntox = this.x + this.ancho;
        puntoy = this.y;
        intersecado = buscarInterseccionEjeY(individuo,puntox,puntoy);
        if(intersecado){
            individuo.incrementarColisiones();
            return true;
        }
        return false;
    }

    private boolean buscarInterseccionEjeX(Individuo individuo, double puntox , double puntoy){
        while(puntox <= puntox + this.ancho){
            if (Math.sqrt (
                    Math.pow(individuo.getX() - puntox , 2)
                            + Math.pow(individuo.getY() - puntoy , 2)
            ) <= individuo.getRadio()){
                return true;
            } else{
                puntox += 0.01; //.01 es una medida arbitraria de desplazamiento
            }
        }
        return false;
    }

    private boolean buscarInterseccionEjeY(Individuo individuo, double puntox, double puntoy){
        while(puntoy<=puntoy + this.largo){
            if (Math.sqrt (
                    Math.pow(individuo.getX() - puntox , 2)
                            + Math.pow(individuo.getY() - puntoy , 2)
            ) <= individuo.getRadio()){
                return true;
            } else{
                puntoy += 0.01; //.01 es una medida arbitraria de desplazamiento
            }
        }
        return false;
    }
}
