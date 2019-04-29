package pack;
public class Reserva{
    private int numPessoas,dias,checkIn,checkOut;
    private float total;
    private Quarto quarto;
    
    public Reserva () {
        this.dias = dias;
        this.total = total;
        this.checkIn = checkIn; //data de entrada no hotel   
        this.checkOut = checkOut;
        this.numPessoas = numPessoas;//combo box
        
}
    
    
    
    double calculaTotal(Quarto quarto){
        if(quarto.getTipo() == 1){
          return quarto.calculaValor()* dias;            
        }
        else if(quarto.getTipo() == 2){
            return quarto.calculaValor()* dias;
        }
        else if (quarto.getTipo() == 3){
            return quarto.calculaValor()* dias;
        }
        else{
            return quarto.calculaValor()*dias;
        }
         
    }
}
