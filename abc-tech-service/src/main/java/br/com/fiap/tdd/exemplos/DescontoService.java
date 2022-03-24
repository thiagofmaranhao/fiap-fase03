package br.com.fiap.tdd.exemplos;

public class DescontoService {

    public double calcularDesconto(double valorDaCompra, FormaDePagamento formaDePagamento) throws IllegalAccessException {
        return valorDaCompra * formaDePagamento.percentualDesconto();
    }

}
