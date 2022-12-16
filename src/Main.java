import java.util.Random;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();

    private static final String [] nomes = new String[] {"André", "João", "Valentina", "Sophia", "Miguel", "Ian", "Vinicius", "Lais", "Carlos", "Maria"};

    public static void main(String[] args) {

        Vendedor[] vendedoresFlores = new Vendedor[nomes.length];
        for (int i = 0; i < nomes.length; i++) {
            int indNomes = random.nextInt(nomes.length);
            String nome = nomes[indNomes];

            vendedoresFlores[i] = new Vendedor(nome);
        }

        Vendedor[] vendedoresFrutas = new Vendedor[nomes.length];
        for (int i = 0; i < nomes.length; i++) {
            int indNomes = random.nextInt(nomes.length);
            String nome = nomes[indNomes];

            vendedoresFrutas[i] = new Vendedor(nome);
        }

        Vendedor[] vendedoresRoupas = new Vendedor[nomes.length];
        for (int i = 0; i < nomes.length; i++) {
            int indNomes = random.nextInt(nomes.length);
            String nome = nomes[indNomes];

            vendedoresRoupas[i] = new Vendedor(nome);
        }

        Mercado mercadoFlores = new Mercado("Mercado das Flores", vendedoresFlores, "Praça XV", 300);
        Mercado mercadoFrutas = new Mercado("Mercado das Frutas", vendedoresFrutas, "Praça JK", 500);
        Mercado mercadoRoupas = new Mercado("Mercado das Roupas", vendedoresRoupas, "Praça da Cidade", 700);

        Comprador comprador = new Comprador();
        for (int i = 0; i < nomes.length; i++) {
            comprador.comprar(mercadoFlores.vendedores[i]);
            comprador.comprar(mercadoFrutas.vendedores[i]);
            comprador.comprar(mercadoRoupas.vendedores[i]);
        }

        Regulador regulador = new Regulador();
        regulador.aplicarBonificacao(mercadoFlores);
        regulador.aplicarBonificacao(mercadoFrutas);
        regulador.aplicarBonificacao(mercadoRoupas);

        System.out.println("Bonificações:");
        System.out.println("");
        anunciarBonificacao(mercadoFlores);
        System.out.println("---------------------------------------------------------------");
        anunciarBonificacao(mercadoFrutas);
        System.out.println("---------------------------------------------------------------");
        anunciarBonificacao(mercadoRoupas);

    }

    private static void anunciarBonificacao(Mercado mercado) {
        for (int i = 0; i < mercado.vendedores.length; i++) {
            if (mercado.vendedores[i].getValorBonificacao() > 0) {
                System.out.printf("O vendedor %s, do %s, vendeu R$ %.2f e ganhou R$ %.2f de bonificação.\n",
                        mercado.vendedores[i].getNome(), mercado.getNome(), mercado.vendedores[i].getValorVendas(),
                        mercado.vendedores[i].getValorBonificacao());
            }
        }
    }


}

class Regulador {
    public void aplicarBonificacao(Mercado mercado) {
        for (int i = 0; i < mercado.vendedores.length; i++) {
            if (mercado.vendedores[i].getValorVendas() > mercado.getMeta()) {
                mercado.vendedores[i].setValorBonificacao();
            }
        }
    }

}

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

    public void calcularTotalVendas(Vendedor[] vendedores) {
        for (int i = 0; i < vendedores.length; i++) {
            totalVendas += vendedores[i].getValorVendas();
        }
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

        return totalVendas;
    }

    public double getMeta() {

        return meta;
    }

}
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

class Comprador {
    public void comprar(Vendedor valor) {
        valor.pagamento(Main.random.nextInt(100,1000));
    }
}

