package exercicio.heranca;

import java.lang.Math;
/**
 * 
 * @author Caio Silva
 *
 */
public class Quadrado extends Figura2D implements IDimensaoSuperficial{
    
    private double lado;

    public Quadrado (double lado, String nome, String cor){
        super(nome, cor);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        
        double area = Math.pow(this.lado, 2);

        return area;
    }

    public double getLado() {
        return lado;
    }
}
