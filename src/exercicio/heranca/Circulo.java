package exercicio.heranca;

import java.lang.Math;
/**
 * 
 * @author Caio Silva
 *
 */
public class Circulo extends Figura2D implements IDimensaoSuperficial{
    
    private double raio;
    
    public Circulo(double raio, String nome, String cor){
        super(nome, cor);
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        double areaCirculo;

        areaCirculo = Math.PI * Math.pow(this.raio, 2);

        return areaCirculo;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    
}
