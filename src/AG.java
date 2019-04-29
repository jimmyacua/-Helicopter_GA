import java.util.ArrayList;

public class AG {

    private int poblacionInicial; // cuántos individuos hay en la población inicial
    private double margenSupervivenciaDebiles; // cuántos chapas sobreviven por generación
    private int dimension; //maximo del plano cartesiano
    private int cantidadGeneraciones;
    private double proporcionMutar;
    private double proporcionCruzar;

    private ArrayList<Obstaculo> obstaculos;
    private ArrayList<Individuo> generacionActual;
    private ArrayList<Individuo> generacionNueva;

    public AG(int poblacionInicial, double margenSupervivenciaDebiles, int dimensionPlano, int cantidadGeneraciones, double proporcionCruzar, double proporcionMutar){
        this.poblacionInicial = poblacionInicial;
        this.margenSupervivenciaDebiles = margenSupervivenciaDebiles;
        this.cantidadGeneraciones = cantidadGeneraciones;
        this.proporcionCruzar = proporcionCruzar;
        this.proporcionMutar = proporcionMutar;
        dimension = dimensionPlano;
        obstaculos = new ArrayList<>();
        generacionActual = new ArrayList<>();
        generacionNueva = new ArrayList<>();
    }

    /**
     * Llena el vector de individuos, creando estos de manera aleatoria.
     */
    public void generarPoblacionInicial(){
        for(int i = 0; i<poblacionInicial; i++){
            Individuo individuo = new Individuo(
                    (int) (Math.random()*dimension),
                    (int) (Math.random()*dimension),
                    (int) (Math.random()*(dimension/2))
            );
            generacionActual.add(individuo);
        }
    }

    /**
     * Genera un nuevo individuo a partir de los atributos de individuos diferentes.
     */
    public Individuo cruzar(Individuo x, Individuo y){
        Individuo individuo;
        int r = ((int) Math.random()* 10)%2;
        if(0 == r){
            individuo = new Individuo(x.getX(), y.getY(), x.getRadio());
        } else{
            individuo = new Individuo(x.getX(), y.getY(), y.getRadio());
        }
        return individuo;
    }

    /**
     * Modifica algún atributo del individuo para generar uno nuevo.
     */
    public Individuo mutar(Individuo x){
        Individuo individuo = x;
        int random = ((int) Math.random()* 30)%3;
        switch (random){
            case 0:
                individuo.setX((int) (Math.random()*dimension));
                break;
            case 1:
                individuo.setY((int) (Math.random()*dimension));
                break;
            case 2:
                individuo.setRadio((int) (Math.random()*(dimension/2)));
                break;
        }
        return individuo;
    }

    /**
     * Modifica el vector de individuos, creando la nueva generación.
     */
    public void seleccionar(){}

}
