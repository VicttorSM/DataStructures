package pack;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Comparable<Reserva>, Serializable {
    private int id;
    private int numPessoas,dias;
    private Date entrada,saida;
    private Quarto quarto;
    private LES hospedes;
    
    public Reserva (Date entrada, Date saida, int numPessoas) {
        hospedes = new LES(4);
        this.dias =  (int) ((saida.getTime()-entrada.getTime())%86400000);
        this.entrada = entrada; //data de entrada no hotel   
        this.saida = saida;
        this.numPessoas = numPessoas;//combo box
    }
    
    public boolean cadastraHospede(Hospede hospede) {
        return hospedes.insere(hospede);
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    double getTotal(Quarto quarto){
        switch (quarto.getTipo()) {
            case 1:
                return quarto.calculaValor()* dias;
            case 2:
                return quarto.calculaValor()* dias;
            case 3:
                return quarto.calculaValor()* dias;
            default:
                return quarto.calculaValor()*dias;
        }
         
    }

    @Override
    public int compareTo(Reserva other) {
        if (getId() < other.getId())
            return -1;
        else if (getId() > other.getId())
            return 1;
        else
            return 0;
    }
}
