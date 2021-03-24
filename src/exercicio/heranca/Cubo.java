package exercicio.heranca;

import java.lang.Math;

/**
 * 
 * @author Caio Silva
 *
 */
public class Cubo extends Figura3D implements IDimensaoSuperficial, IDimensaoVolumetrica{

    /** Um cubo possui todas as arestas com a mesma medida */
    private double aresta;

    public Cubo(double aresta, String nome, String cor){
        super(nome, cor);
        this.aresta = aresta;
    }
    
    @Override
    public double calcularArea() {
        
        double areaCubo = 6 * Math.pow(this.aresta, 2);

        return areaCubo;
    }

    @Override
    public double calcularVolume() {
        
        double volumeCubo = Math.pow(this.aresta, 3);
        
        return volumeCubo;
    }

    public double getAresta() {
        return aresta;
    }
        
}
