package br.tdd.exemplos;

import br.com.fiap.tdd.exemplos.DescontoService;
import br.com.fiap.tdd.exemplos.FormaDePagamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DescontosServiceTest {

    @Test
    void deveConcederDescontoQuandoPagamentoAVistaEmDinheiro() throws IllegalAccessException {
        DescontoService descontoService = new DescontoService();
        double desconto = descontoService.calcularDesconto(1000.00, FormaDePagamento.DINHEIRO);
        double descontoEsperado = 100.00;
        Assertions.assertEquals(descontoEsperado, desconto);
    }

    @Test
    void deveConcederDescontoQuandoPagamentoAVistaNoDebito() throws IllegalAccessException {
        DescontoService descontoService = new DescontoService();
        double desconto = descontoService.calcularDesconto(1000.00, FormaDePagamento.DEBITO);
        double descontoEsperado = 60.00;
        Assertions.assertEquals(descontoEsperado, desconto);
    }

    @Test
    void deveLancarExcecaoQuandoPagamentoNoCredito() {
        DescontoService descontoService = new DescontoService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            descontoService.calcularDesconto(1000.00, FormaDePagamento.CREDITO);
        }, "Para cartão de crédito, não é permitido desconto!");
    }

}
