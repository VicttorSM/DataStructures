package pack;

import java.io.Serializable;

/**
 * @author Victtor da Silva Mendes
 */
public class Hotel implements Serializable {
    
    public Hotel() {
        quartos = new LDE<>();
        hospedes = new ArvoreBinaria<>();
        checkin = new LDDE<>();
        //reserva = new LES<>;
        int id = 1;
        /* Faz 10 quartos de cada tipo */
        for (int tipo = 1; tipo <= 4; tipo++) {
            for (int i = 0; i < 10; i++) {
                quartos.insere(new Quarto(tipo, id));
            }
            id++;
        }
    }
    
    public void cadastraCheckIn(Hospede hospede){
        checkin.insere(hospede);
        
    }
    public NoLDDE<Hospede> buscaNoLDDE(){
        return checkin.getPrimeiro();
    }
    
    public boolean cadastrarHospede(Hospede hospede) {
        return hospedes.insere(hospede);
       
    }
    
    public boolean removerHospede(Hospede hospede) {
        checkin.remove(hospede);
        return hospedes.remove(hospede);
    }
    
    public Hospede getHospedePorCPF(String cpf) {
        NoArv<Hospede> temp = hospedes.busca(new Hospede("","",0,cpf,"","","",""));
        if (temp == null)
            return null;
        else
            return temp.getValor();
    }
    
    public No<Quarto> getPrimeiroNoQuarto() {
        return quartos.getPrimeiro();
    }
    
    private LDE<Quarto> quartos;
    private ArvoreBinaria<Hospede> hospedes;
    private LDDE<Hospede> checkin;
}
