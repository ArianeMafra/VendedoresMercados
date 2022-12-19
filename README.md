# MÓDULO 2:  PROGRAMAÇÃO ORIENTADA A OBJETOS I 
# #BeTheNext - Ada/Sinqia
## Desafio 01

## Contexto
Representar vendedores em um pool de vários mercados que são bonificados com aumento de 10% em suas vendas ao alcançar a meta estabelecida por cada mercado atuante, segundo um órgão regulador.

### Para o desafio considerar
- Crie três instâncias da classe mercado
- Cada mercado tem 10 instâncias de vendedor atuando
- Defina o valor de venda aleatório do vendedor compreendido entre [100,1000]
- Defina as metas fixas para cada mercado [m1=300], [m2=500], [m3=700]
- Se a venda do vendedor for acima da meta estabelecida no mercado que o pertencer, bonificá-lo em 10% pelo órgão regulador
- Haverão três classes desafio01.Mercado, desafio01.Vendedor e desafio01.Regulador

### Para a classe desafio01.Mercado considerar
- Um mercado tem um array de Vendedores
- Um mercado tem atributos de nome, local e total em vendas 
- O total de vendas deste mercado não deve considerar as bonificações dos vendedores
- No construtor da classe mercado deve receber um pool de vendedores (desafio01.Vendedor[] vendedores)
- Implementar os métodos getVendedores(), getTotalVendas(), getLocal(), getNome()

### Para a classe desafio01.Vendedor considerar
- O vendedor tem atributos como nome, valor de vendas (aleatório <=1000) e valor de bonificação
- O vendedor tem um atributo mercado (classe), indicando seu pertencimento
- O vendedor deve ter um construtor que define seus atributos incluindo valor aleatório das vendas
- O construtor do vendedor deve ser ter o atributo nome apenas
- Neste construtor atribuir o valor da venda a um método estático pagamento() <= 1000
- Colocar o método pagamento() em uma classe chamada desafio01.Comprador.java que terá apenas este método
- Quem vai dizer o valor da bonificação é o órgão regulador, explicado mais adiante

### Para a classe desafio01.Regulador considerar
- Haverá por fim uma classe chamada desafio01.Regulador que vai apurar todas as vendas 
- Esse órgão regulador vai verificar cada venda e aplicar a bonificação para cada vendedor
- A classe desafio01.Regulador deve ter um método estático chamado aplicar(desafio01.Mercado[] mercados)

### Em resumo
- Haverão 3 classes desafio01.Mercado, desafio01.Vendedor e desafio01.Regulador
- Haverá uma classe extra desafio01.Comprador
- Criar em uma classe chamada desafio01.Main toda a lógica
- Exiba como foram as vendas de cada mercado e seus vendedores com ou sem bonificação
- Exiba um sumário sobre como foi cada mercado
