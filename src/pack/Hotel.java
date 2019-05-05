package pack;

/**
 * @author Victtor da Silva Mendes
 */
public class Hotel {
    
    public Hotel() {
        hospedes = new ArvoreBinaria<>();
        checkin = new LDDE<>();
        int id = 1;
        /* Faz 10 quartos de cada tipo */
        for (int tipo = 1; tipo <= 4; tipo++) {
            for (int i = 0; i < 10; i++) {
                //quartosDesocupados.insere(new Quarto(tipo, id, "DESCRIPTION", false));
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
        return hospedes.remove(hospede);
    }
    
    public Hospede getHospedePorCPF(String cpf) {
        NoArv<Hospede> temp = hospedes.busca(new Hospede("","",0,cpf,"","","",""));
        if (temp == null)
            return null;
        else
            return temp.getValor();
    }
    
    public void getTodosHospedes() {
        // TODO
    }
    
    //private LDE<Reserva> reservas;
    private ArvoreBinaria<Hospede> hospedes;
    private LDDE<Hospede> checkin;
    //private LDE<Quarto> quartosDesocupados;
    //private LDE<Quarto> quartosOcupados;
}
