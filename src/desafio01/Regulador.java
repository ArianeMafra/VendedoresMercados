package desafio01;

import desafio01.Mercado;

class Regulador {
    public void aplicarBonificacao(Mercado mercado) {
        for (int i = 0; i < mercado.vendedores.length; i++) {
            if (mercado.vendedores[i].getValorVendas() > mercado.getMeta()) {
                mercado.vendedores[i].setValorBonificacao();
            }
        }
    }

}
