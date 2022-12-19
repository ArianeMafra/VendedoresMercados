package desafio01;

class Mercado {

    private String nome;
    Vendedor[] vendedores;
    private String local;
    private double meta;
    public double totalVendas;

    public Mercado(String nome, Vendedor[] vendedores, String local, double meta) {
        this.nome = nome;
        this.vendedores = vendedores;
        this.local = local;
        this.meta = meta;
    }

    public String getNome() {

        return nome;
    }

    public Vendedor[] getVendedores() {

        return vendedores;
    }

    public String getLocal() {

        return local;
    }

    public double getTotalVendas() {
        for (int i = 0; i < vendedores.length; i++) {
            totalVendas += vendedores[i].getValorVendas();
        }

        return totalVendas;
    }

    public double getMeta() {

        return meta;
    }

}
