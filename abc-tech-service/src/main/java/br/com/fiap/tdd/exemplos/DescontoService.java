package br.com.fiap.tdd.exemplos;

public class DescontoService {

    public double calcularDesconto(double valorDaCompra, FormaDePagamento formaDePagamento) throws IllegalArgumentException {
        return valorDaCompra * formaDePagamento.percentualDesconto();
    }

}
