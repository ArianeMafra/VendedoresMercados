import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();

    private static final String [] nomesVendedores = new String[] {"André", "João", "Valentina", "Sophia", "Miguel", "Ian", "Vinicius", "Lais", "Carlos", "Maria"};

    private static final String [] nomesCompradores = new String[] {"Alisson", "José", "Vitória", "Sandra", "Mateus", "Igor", "Vicente", "Laura", "Caio", "Mariana"};
    public static void main(String[] args) {

        Vendedor[] vendedoresFlores = criarVendedores();
        Vendedor[] vendedoresFrutas = criarVendedores();
        Vendedor[] vendedoresRoupas = criarVendedores();

        Mercado mercadoFlores = new Mercado("Mercado das Flores", vendedoresFlores, "Praça XV", 300);
        Mercado mercadoFrutas = new Mercado("Mercado das Frutas", vendedoresFrutas, "Praça JK", 500);
        Mercado mercadoRoupas = new Mercado("Mercado das Roupas", vendedoresRoupas, "Praça da Cidade", 700);

        Comprador[] comprador = criarCompradores();

        for  (int i = 0; i < nomesVendedores.length; i++) {
            comprador[i].comprar(mercadoFlores.vendedores[i]);
            comprador[i].comprar(mercadoFrutas.vendedores[i]);
            comprador[i].comprar(mercadoRoupas.vendedores[i]);

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
        System.out.println("---------------------------------------------------------------");
        System.out.println("---------------------------Ranking-----------------------------");
        maisLucrativo(mercadoFlores, mercadoFrutas, mercadoRoupas);
        rankingVendedores(mercadoFlores, mercadoFrutas, mercadoRoupas);
        rankingCompradores(comprador);

    }

    private static void rankingCompradores(Comprador[] comprador) {
        double [] valoresCompra = new double[comprador.length];
        for (int i = 0; i < comprador.length; i++) {
            valoresCompra[i] = comprador[i].getTotalCompras();
        }
        Arrays.sort(valoresCompra);
        System.out.println("\nOs três maiores compradores foram: ");
        for (int i = 0; i < comprador.length; i++) {
            if (valoresCompra[comprador.length -1] == comprador[i].getTotalCompras()) {
                System.out.println("1º - " + comprador[i].getNome());
            }
        }
        for (int i = 0; i < comprador.length; i++) {
            if (valoresCompra[comprador.length -2] == comprador[i].getTotalCompras()) {
                System.out.println("2º - " + comprador[i].getNome());
            }
        }
        for (int i = 0; i < comprador.length; i++) {
            if (valoresCompra[comprador.length -3] == comprador[i].getTotalCompras()) {
                System.out.println("3º - " + comprador[i].getNome());
            }
        }
    }

    public static void rankingVendedores(Mercado mercado1,Mercado mercado2,Mercado mercado3){
        Vendedor []maior= new Vendedor[3];
        maior[0]=mercado1.vendedores[0];
        maior[0].pagamento(0);
        maior[1]=maior[0];
        maior[2]=maior[0];
        String[] maiorMerc= new String[3];
        System.out.println("\nOs três maiores vendedores foram: ");
        for (int i=0;i<3;i++){
            for (int j = 0; j < 10; j++) {
                if(i==0) {
                    if (mercado1.vendedores[j].getValorVendas() > maior[i].getValorVendas()) {
                        maior[i] = mercado1.vendedores[j];
                        maiorMerc[i] = mercado1.getNome();
                    }
                    if (mercado2.vendedores[j].getValorVendas() > maior[i].getValorVendas()) {
                        maior[i] = mercado2.vendedores[j];
                        maiorMerc[i] = mercado2.getNome();
                    }
                    if (mercado3.vendedores[j].getValorVendas() > maior[i].getValorVendas()) {
                        maior[i] = mercado3.vendedores[j];
                        maiorMerc[i] = mercado3.getNome();
                    }
                }
                else{
                    if (mercado1.vendedores[j].getValorVendas()>maior[i].getValorVendas() &&
                            mercado1.vendedores[j].getValorVendas()<maior[i-1].getValorVendas()){
                        maior[i]=mercado1.vendedores[j];
                        maiorMerc[i]=mercado1.getNome();
                    }
                    if (mercado2.vendedores[j].getValorVendas()>maior[i].getValorVendas() &&
                            mercado2.vendedores[j].getValorVendas()<maior[i-1].getValorVendas()){
                        maior[i]=mercado2.vendedores[j];
                        maiorMerc[i]=mercado2.getNome();
                    }
                    if (mercado3.vendedores[j].getValorVendas()>maior[i].getValorVendas() &&
                            mercado3.vendedores[j].getValorVendas()<maior[i-1].getValorVendas()){
                        maior[i]=mercado3.vendedores[j];
                        maiorMerc[i]=mercado3.getNome();
                    }
                }
            }
        }
        for (int i=0;i<3;i++){
            System.out.println((i+1)+"º - "+
                    maior[i].getNome()+
                    ", com R$ "+maior[i].getValorVendas()+
                    " vendidos no "+ maiorMerc[i]);
        }
    }
    private static void maisLucrativo(Mercado mercado1, Mercado mercado2, Mercado mercado3) {
        double lucroM1 = mercado1.getTotalVendas();
        double lucroM2 = mercado2.getTotalVendas();
        double lucroM3 = mercado3.getTotalVendas();

        if (lucroM1 > lucroM2 && lucroM1 > lucroM3) {
            System.out.printf("O %s foi o mercado mais lucratico.\n\n", mercado1.getNome());
        } else if (lucroM2 > lucroM1 && lucroM2 > lucroM3) {
            System.out.printf("O %s foi o mercado mais lucratico.\n\n", mercado2.getNome());
        } else {
            System.out.printf("O %s foi o mercado mais lucratico.\n\n", mercado3.getNome());
        }
    }

    private static Comprador[] criarCompradores() {
        Comprador[] compradores = new Comprador[nomesCompradores.length];
        for (int i = 0; i < nomesCompradores.length; i++) {
            int indNomes = random.nextInt(nomesCompradores.length);
            String nome = nomesCompradores[indNomes];

            compradores[i] = new Comprador(nome);
        }
        return compradores;
    }

    private static Vendedor[] criarVendedores() {
        Vendedor[] vendedores = new Vendedor[nomesVendedores.length];
        for (int i = 0; i < nomesVendedores.length; i++) {
            int indNomes = random.nextInt(nomesVendedores.length);
            String nome = nomesVendedores[indNomes];

            vendedores[i] = new Vendedor(nome);
        }
        return vendedores;
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

    private String nome;
    private double compra;
    private double totalCompras;

    public Comprador(String nome) {
        this.nome = nome;
    }

    public void comprar(Vendedor valor) {
        compra = Main.random.nextInt(100,1000);
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

