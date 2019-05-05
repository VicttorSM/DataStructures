/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import pack.Reserva;

class Quarto implements Comparable<Quarto> {

    private int tipo;
    private int id;

    public Quarto(int tipo, int id) {
        this.tipo = tipo;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    double calculaValor() {
        switch (tipo) {
            case 1:
                //cama solteiro
                return 50.0;
            case 2:
                //uma casal ou duas solteiro
                return 100.0;
            case 3:
                //3 camas solteiro ou 1 casal 1 solteiro
                return 200.0;
            default:
                //4 camas solteiro ou 2 camas de casal ou 1 de casal e 2 solteiro
                return 250.0;
        }
    }

    @Override
    public int compareTo(Quarto other) {
        
        if (getTipo() < other.getTipo()) {
            return -1;
        
        } else if (getTipo() > other.getTipo()) {
            return 1;
        
        } else {
            return 0;
        }
    }

}
