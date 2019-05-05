package pack;

public class NoLDDE <P extends Comparable<P>> {
    public P valor;
    public NoLDDE<P> proximo;
    public NoLDDE<P> anterior;
        
    public NoLDDE(){
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }   

    public P getValor() {
        return valor;
    }

    public void setValor(P valor) {
        this.valor = valor;
    }

    public NoLDDE<P> getProximo() {
        return proximo;
    }

    public void setProximo(NoLDDE<P> proximo) {
        this.proximo = proximo;
    }

    public NoLDDE<P> getAnterior() {
        return anterior;
    }

    public void setAnterior(NoLDDE<P> anterior) {
        this.anterior = anterior;
    }
    
    
}
