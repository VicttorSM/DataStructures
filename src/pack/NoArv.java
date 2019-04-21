package pack;

/**
 * @author Victtor Mendes
 * @param <T> tipo de valor que será inserido no nó
 */

public class NoArv<T> {

    public NoArv(T valor) {
        this.valor = valor;
        this.pai = null;
        this.esq = null;
        this.dir = null;
    }

    @Override
    public String toString() {
        return valor.toString();
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoArv<T> getPai() {
        return pai;
    }

    public void setPai(NoArv<T> pai) {
        this.pai = pai;
    }

    public NoArv<T> getEsq() {
        return esq;
    }

    public void setEsq(NoArv<T> esq) {
        this.esq = esq;
    }

    public NoArv<T> getDir() {
        return dir;
    }

    public void setDir(NoArv<T> dir) {
        this.dir = dir;
    }
    
    private T valor;
    private NoArv<T> pai;
    private NoArv<T> esq;
    private NoArv<T> dir;
}
