package exercicio.heranca;

/**
 * 
 * @author Caio Silva
 *
 */
public class Triangulo extends Figura2D implements IDimensaoSuperficial{
    
    private double base;
    private double altura;

    public Triangulo(double base, double altura, String nome, String cor){
        super(nome, cor);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        
        double area;

        area = (this.base * this.altura) / 2D;

        return area;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
}
