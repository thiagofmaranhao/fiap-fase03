package br.tdd.exemplos;

import br.com.fiap.tdd.exemplos.DescontoService;
import br.com.fiap.tdd.exemplos.FormaDePagamento;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
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
        IllegalArgumentException t = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            descontoService.calcularDesconto(1000.00, FormaDePagamento.CREDITO);
        });
        Assertions.assertEquals("Para cartão de crédito, não é permitido desconto!", t.getMessage());
    }

    Double valorDaCompra;

    @Dado("que o cliente faça uma compra com valor de R${double}")
    public void que_o_cliente_faça_uma_compra_com_valor_de_r$(Double valor) {
        valorDaCompra = valor;
    }

    private double desconto;
    @Quando("ele decide pagar à vista em dinheiro")
    public void ele_decide_pagar_à_vista_em_dinheiro() {
        DescontoService descontoService = new DescontoService();
        desconto = descontoService.calcularDesconto(valorDaCompra, FormaDePagamento.DINHEIRO);
    }

    @Então("um desconto de {int}% é concedido")
    public void um_desconto_de_é_concedido(Integer porcentagemDesconto) {
        double descontoEsperado = valorDaCompra * (porcentagemDesconto / 100.00);
        Assertions.assertEquals(descontoEsperado, desconto);
    }

    @Quando("ele decide pagar no débito")
    public void ele_decide_pagar_no_débito() {
        DescontoService descontoService = new DescontoService();
        desconto = descontoService.calcularDesconto(valorDaCompra, FormaDePagamento.DEBITO);
    }

}