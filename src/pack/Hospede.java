package pack;

import java.util.Date;

/**
 * @author Victtor da Silva Mendes
 */
public class Hospede extends Pessoa implements Comparable<Hospede> {

    public Hospede(String nome,
                   String sobrenome,
                   int idade,
                   String cpf,
                   String sexo,
                   String cidade,
                   String email,
                   String telefone) {
        super(nome, sobrenome, idade, cpf, sexo, cidade);
        setEmail(email);
        setTelefone(telefone);
        this.checkin = null;
        this.checkout = null;
    }

    @Override
    public int compareTo(Hospede other) {
        return getCPF().compareTo(other.getCPF());
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public boolean fazerCheckin() {
        if (checkin != null)
            return false;
        checkin = new Date();
        return true;
    }
    
    public Date getCheckin() {
        return checkin;
    }
    
    public boolean fazerCheckout() {
        if (checkin == null || checkout != null)
            return false;
        checkout = new Date();
        return true;
    }
    
    public Date getCheckout() {
        return checkout;
    }

    private Date checkin;
    private Date checkout;
    private String email;
    private String telefone;
}
