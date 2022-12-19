package desafio01;

class Vendedor {
    private String nome;
    private double valorVendas;
    private double valorBonificacao;

    public Vendedor(String nome) {
        this.nome = nome;
    }

    public void pagamento(double valor) {
        this.valorVendas += valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public double getValorBonificacao() {
        return valorBonificacao;
    }

    public void setValorBonificacao() {
        valorBonificacao = valorVendas * 0.1;
    }
}
