#language: pt

  Funcionalidade: "Descontos de acordo com forma de pagamento"
    Cenario: Deve conceder desconto de 10% para pagamentos em dinheiro cujo valor maior ou igual a R$500,00
      Dado que cliente faça uma compra com valor de R$600,00
      Quando ele decide pagar á vista em dinheiro
      Então um desconto de 10% é concedido

    Cenario: Deve conceder desconto de 6% para pagamentos no débito cujo valor maior ou igual a R$500,00
      Dado que o cliente faça uma compra com valor de R$600,00
      Quando ele decide pagar no débito
      Então um desconto de 6% é concedido

