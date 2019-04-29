package pack;
import pack.Reserva;
class Quarto {
    public static int tipo;
    private int id;
    private String descricao;
    private boolean ocupado;
    
    public Quarto(int tipo, int id, String descricao, boolean ocupado){
        this.tipo = tipo;
        this.descricao = descricao;
        this.id = id;
        this.ocupado = ocupado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo() {
        this.tipo = tipo;
    }
    
    double calculaValor(){
        if(tipo == 1){ //cama casal
            return 50.0;
        }
        else if(tipo == 2){ //uma casal e duas solteiro
            return 100.0;
        }
        else if(tipo == 3){//1 casal, e duas solteiro
            return 200.0;
        }
        else
            return 250.0;
        }
       
    }

   

