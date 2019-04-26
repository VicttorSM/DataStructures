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
        
        /* encontra o sucessor e o troca de lugar com o no */
        NoArv<T> sucessor;
        switch (numDeFilhos(no)) {
            case 1:
                if (no.getEsq() != null) {
                    sucessor = no.getEsq();
                }
                else {
                    sucessor = no.getDir();
                }   
                sucessor.setPai(pai);
                break;
            case 2:
                sucessor = no.getDir();
                while (sucessor.getEsq() != null) {
                    sucessor = sucessor.getEsq();
                }
                if (sucessor.getPai().getEsq() == sucessor) {
                    sucessor.getPai().setEsq(sucessor.getDir());
                    if (sucessor.getDir() != null) {
                        sucessor.getDir().setPai(sucessor.getPai());
                    }
                    sucessor.setDir(no.getDir());
                }
                sucessor.setEsq(no.getEsq());
                sucessor.setPai(pai);
                break;
            default:
                sucessor = null;
                break;
        }
        
        if (pai == null) {
            raiz = sucessor;
        }
        else {
            if (pai.getEsq() == no) {
                pai.setEsq(sucessor);
            }
            else {
                pai.setDir(sucessor);
            }
        }
        if (sucessor != null) {
            if (sucessor.getEsq() != null) {
                sucessor.getEsq().setPai(sucessor);
            }
            if (sucessor.getDir() != null) {
                sucessor.getDir().setPai(sucessor);
            }
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
    
    public void printEDR() {
        printEDR(raiz);
        System.out.println();
    }
        
    public void printRED() {
        printRED(raiz);
        System.out.println();
    }
    
    public NoArv<T> getRaiz() {
        return raiz;
    }
    
    private int numDeFilhos(NoArv<T> no) {
        if (no.getEsq() == null && no.getDir() == null)
            return 0;
        if (no.getEsq() == null || no.getDir() == null)
            return 1;
        return 2;
    }
    
    private void printERD(NoArv<T> raiz) {
        if (raiz == null)
            return;
        printERD(raiz.getEsq());
        System.out.print(raiz.toString() + " ");
        printERD(raiz.getDir());
    }
    
    private void printEDR(NoArv<T> raiz) {
        if (raiz == null)
            return;
        printEDR(raiz.getEsq());
        printEDR(raiz.getDir());
        System.out.print(raiz.toString() + " ");
    }
    
    private void printRED(NoArv<T> raiz) {
        if (raiz == null)
            return;
        System.out.print(raiz.toString() + " ");
        printRED(raiz.getEsq());
        printRED(raiz.getDir());
    }
    
    private NoArv<T> raiz;
    private int n;
}