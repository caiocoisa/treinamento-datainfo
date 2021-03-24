package exercicio.heranca;

import java.lang.Math;

/**
 * 
 * @author Caio Silva
 *
 */
public class Piramide extends Figura3D implements IDimensaoSuperficial, IDimensaoVolumetrica{
    
    private double ladoDaBase;
    private double altura;

    public Piramide(String nome, String cor, double ladoDaBase, double altura) {
        super(nome, cor);
        this.ladoDaBase = ladoDaBase;
        this.altura = altura;
    }
    
    @Override
    public double calcularArea() {
        /**
         *  Formula da área da pirâmide de base quadrada:
         *  areaPiramide == (areaFaceLateral*4) + areaBase
         *  onde:
         *  areaFaceLateral == apotema * ladoBase
         *  e
         *  apotema**2 == altura**2 + (ladoBase/2)**2
         */

        double alturaAoQuadrado;
        double apotema;
        double areaFaceLateral;
        double areaPiramide;

        alturaAoQuadrado = Math.pow(this.altura, 2);

        apotema = alturaAoQuadrado + Math.pow(this.ladoDaBase/2D, 2);

        areaFaceLateral = apotema * this.ladoDaBase;

        areaPiramide = areaFaceLateral*4 + Math.pow(this.ladoDaBase, 2);

        return areaPiramide;
    }

    @Override
    public double calcularVolume(){
        /**
         *  Fórmula do volume da pirâmide:
         *  volumePiramide == (areaDaBase * altura) / 3  
         */

        double areaDaBase;
        double volumePiramide;

        areaDaBase = Math.pow(this.ladoDaBase, 2);

        volumePiramide = (areaDaBase * this.altura) / 3D;

        return volumePiramide;
    }

}
