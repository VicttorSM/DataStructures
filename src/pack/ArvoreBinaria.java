package pack;

/**
 * @author Victtor Mendes
 * @param <T> tipo de valor que será inserido na arvore
 */
public class ArvoreBinaria<T extends Comparable<T>> {

    public ArvoreBinaria() {
        this.raiz = null;
        this.n = 0;
    }
    
    public int size() {
        return n;
    }
    
    public boolean empty() {
        return n == 0;
    }
    
    public void insere(T valor) {
        NoArv<T> novo = new NoArv<>(valor);
        NoArv<T> anterior = null;
        NoArv<T> atual = raiz;
        while (atual != null) {
            int num = valor.compareTo(atual.getValor());
            anterior = atual;
            if (num < 0) {
                atual = atual.getEsq();
            }
            else {
                atual = atual.getDir();
            }
        }
        
        // arvore vazia
        if (anterior == null) {
            raiz = novo;
        }
        // novo vai para a esquerda
        else if (novo.getValor().compareTo(anterior.getValor()) < 0) {
            anterior.setEsq(novo);
        }
        // novo vai para a direita
        else {
            anterior.setDir(novo);
        }
        novo.setPai(anterior);
        n++;
    }
    
    public boolean remove(T valor) {
        return remove(busca(valor));
    }
    
    public boolean remove(NoArv<T> no) {
        if (no == null) {
            return false;
        }
        NoArv<T> pai = no.getPai();
        NoArv<T> filho;
        // no a ser removido possui um filho a esquerda
        if (no.getEsq() != null) {
            no.getEsq().setPai(pai);
            filho = no.getEsq();
        }
        // no a ser removido possui um filho a direita
        else if (no.getDir() != null) {
            no.getDir().setPai(pai);
            filho = no.getDir();
        }
        // no a ser removido nao possui nenhum filho
        else {
            filho = null;
        }
        
        // no a ser removido possui pai
        if (pai != null) {
            if (no.getValor().compareTo(pai.getValor()) < 0) {
                pai.setEsq(filho);
            }
            else {
                pai.setDir(filho);
            }
        }
        // no a ser removido eh a raiz
        else {
            raiz = filho;
        }
        
        // no a ser removido possui os dois filhos
        if (no.getEsq() != null && no.getDir() != null) {
            NoArv<T> now = no.getEsq();
            while (now.getDir() != null) {
                now = now.getDir();
            }
            now.setDir(no.getDir());
            no.getDir().setPai(now.getDir());
        }
        n--;
        return true;
    }
    
    public NoArv<T> busca(T valor) {
        NoArv<T> atual = raiz;
        while (atual != null && atual.getValor().compareTo(valor) != 0) {
            if (valor.compareTo(atual.getValor()) < 0) {
                atual = atual.getEsq();
            }
            else {
                atual = atual.getDir();
            }
        }
        return atual;
    }
    
    public void printERD() {
        printERD(raiz);
        System.out.println();
    }
    public void printERD(NoArv<T> raiz) {
        if (raiz == null)
            return;
        printERD(raiz.getEsq());
        System.out.print(raiz.toString() + " ");
        printERD(raiz.getDir());
    }
    
    public void printEDR() {
        printEDR(raiz);
        System.out.println();
    }
    public void printEDR(NoArv<T> raiz) {
        if (raiz == null)
            return;
        printEDR(raiz.getEsq());
        printEDR(raiz.getDir());
        System.out.print(raiz.toString() + " ");
    }
    
    public NoArv<T> getRaiz() {
        return raiz;
    }
    
    private NoArv<T> raiz;
    private int n;
}
