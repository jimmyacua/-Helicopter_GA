import javafx.util.Pair;

import java.lang.Math;
import java.util.ArrayList;

/**
 * @brief Clase que permite representar un Obstáculo en el contexto del algoritmo genético.
 *
 * @author  Geovanny Cordero Valverde   (geovanny.corderovalverde@ucr.ac.cr)
 * @author  Carlos Delgado Rojas        (carlos.delgadorojas@ucr.ac.cr)
 * @author  Jimmy Acuña Díaz            (jimmy.acuna@ucr.ac.cr)
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

    private ArrayList<Pair> puntos;

    /**
     *  Constructor por defecto
     * @param x coordena en eje x de la esquina inferior izquierda
     * @param y coordena en eje y de la esquina inferior izquierda
     */
    public Obstaculo(int x, int y/*, double ancho, double largo*/){
        this.x = x;
        this.y = y;

        //para entrega del 02/mayo suponer que los obstaculos son puntos.
        //this.ancho = ancho;
        //this.largo = largo;
    }

    /**
     *  Dado un individuo, permite saber si este colisiona con el obstaculo o no.
     * @param individuo individuo para analizar
     * @return true si hay colisión, false en caso contrario
     */
    public boolean hayInterseccion(Individuo individuo){

        if(individuo.getX()==this.x){
            if(y <= individuo.getX()+individuo.getRadio() || y >= individuo.getX()+individuo.getRadio()){
                individuo.incrementarColisiones();
                return true;
            }
        } else if(individuo.getY()==this.y){
            if(x <= individuo.getY()+individuo.getRadio() || x >= individuo.getY()+individuo.getRadio()){
                individuo.incrementarColisiones();
                return true;
            }
        } else {
            int cateto = x-individuo.getX();
            int cateto2 = y-individuo.getY();
            int hipot = (int) (Math.pow(cateto,2) + Math.pow(cateto2,2));
            if(hipot<=individuo.getRadio()){
                individuo.incrementarColisiones();
                return true;
            }
        }
        return false;

        /*double puntox = this.x;
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
        return false;*/
    }

    private boolean buscarInterseccionEjeX(Individuo individuo, double puntox , double puntoy){
        while(puntox <= puntox + this.ancho){
            if (Math.sqrt (
                    Math.pow(individuo.getX() - puntox , 2)
                            + Math.pow(individuo.getY() - puntoy , 2)
            ) <= individuo.getRadio()){
                return true;
            } else{
                puntox += 5; //.01 es una medida arbitraria de desplazamiento
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
                puntoy += 5; //.01 es una medida arbitraria de desplazamiento
            }
        }
        return false;
    }
}
