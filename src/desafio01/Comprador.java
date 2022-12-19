package desafio01;

import desafio01.Main;

class Comprador {

    private String nome;
    private double compra;
    private double totalCompras;

    public Comprador(String nome) {
        this.nome = nome;
    }

    public void comprar(Vendedor valor) {
        compra = Main.random.nextInt(100, 1000);
        valor.pagamento(compra);
        totalCompras += compra;
    }

    public String getNome() {
        return nome;
    }

    public double getTotalCompras() {
        return totalCompras;
    }
}
