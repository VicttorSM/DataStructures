package pack;

import pack.NoLDDE;
public class LDDE<P extends Comparable<P>>{
    private NoLDDE<P> primeiro,ultimo;
    private int n;

    public LDDE(){
        this.n = 0;
        this.primeiro = null;
        this.ultimo = null;
    }
    boolean insere(P valor){
        NoLDDE<P> novo = new NoLDDE<P>();
        novo.getValor();
        if(novo == null){
            return false;
        }
        NoLDDE<P> ptrAnt = null;
        NoLDDE<P> ptrAtual = primeiro;
        while(ptrAtual != null && ptrAtual.getValor().compareTo(valor) < 0){
            ptrAnt = ptrAtual;
            ptrAtual = ptrAtual.getProximo();
        }
        novo.setAnterior(ptrAnt);
        if(ptrAnt != null){
           ptrAnt.setProximo(novo);
        }else{
            primeiro = novo;
        }
        novo.setProximo(ptrAtual);
        if(ptrAtual != null){
            ptrAtual.setAnterior(novo);
        }else{
            ultimo = novo;
        }
        n++;
        return true;
    }
    
    P busca(P valor){
        NoLDDE<P> ptrAtual = primeiro;
        while(ptrAtual != null && ptrAtual.getValor().compareTo(valor) < 0){
            ptrAtual = ptrAtual.getProximo();
        }
        if(ptrAtual == null || ptrAtual.getValor() != valor){
            return null;
        }
        return valor;
    }
    
    boolean remove(P valor){
        NoLDDE<P> ptrAtual = primeiro;
        while(ptrAtual != null && ptrAtual.getValor().compareTo(valor) < 0){
            ptrAtual = ptrAtual.getProximo();
        }
        if(ptrAtual == null || ptrAtual.getValor().compareTo(valor) < 0){
            return false;
        }
        NoLDDE<P> ptrAnt = ptrAtual.getAnterior();
        NoLDDE<P> ptrProximo = ptrAtual.getProximo();
        if(ptrAnt != null){
            ptrAnt.setProximo(ptrProximo);
        }else{
            primeiro = ptrProximo;
        }
        if(ptrProximo != null){
            ptrProximo.setAnterior(ptrAnt);
        }else{
            ultimo = ptrAnt;
        }
        n--;
        return true;
    }

    void insere(LDDE<Hospede> checkin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
