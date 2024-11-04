package fag;

public class Quarto {
    public int numero;
    public String tipo;
    public double precoDiario;
    public boolean disponivel;

    public Quarto(int numero, String tipo, double precoDiario) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponivel = true; 
    }

    public void alterarDisponibilidade(boolean status) {
        this.disponivel = status;
    }
}
