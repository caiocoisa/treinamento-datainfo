package exercicio.heranca;

import java.lang.Math;
/**
 * 
 * @author Caio Silva
 *
 */
public class Cilindro extends Figura3D implements IDimensaoSuperficial, IDimensaoVolumetrica{

    private double altura;
    private double raioDaBase;

    public Cilindro(double altura, double raioDaBase, String nome, String cor){
        super(nome, cor);
        this.altura = altura;
        this.raioDaBase = raioDaBase;
    }

    @Override
    public double calcularArea() {
        /**
         * Área do cilindro:
         * areaCilindro == areaRetangulo + areaDaBaseCircular
         * onde:
         * areaDaBaseCircular == pi * raioDaBase**2
         * e
         * areaRetangulo == 2 * pi * raioDaBase * altura
         */
        double areaDaBaseCircular;
        double areaRetangulo;
        double areaDoCilindro;

        areaDaBaseCircular = Math.PI * Math.pow(this.raioDaBase, 2);

        areaRetangulo = 2 * Math.PI * this.raioDaBase * this.altura;

        areaDoCilindro = areaRetangulo + areaDaBaseCircular;

        return areaDoCilindro;
    }

    @Override
    public double calcularVolume() {
        /**
         * Volume do cilindro:
         * volume == areaDaBaseCircular * altura
         */
        
        double areaDaBaseCircular;
        double volumeCilindro;

        areaDaBaseCircular = Math.PI * Math.pow(this.raioDaBase, 2);

        volumeCilindro = areaDaBaseCircular * this.altura;

        return volumeCilindro;
    }

    public double getAltura() {
        return altura;
    }
    
}
