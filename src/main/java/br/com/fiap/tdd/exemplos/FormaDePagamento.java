package br.com.fiap.tdd.exemplos;

public enum FormaDePagamento {

    DINHEIRO {
        public double percentualDesconto() {
            return 0.1;
        }
    },
    DEBITO {
        public double percentualDesconto() {
            return 0.06;
        }
    },
    CREDITO {
        public double percentualDesconto() {
            throw new IllegalArgumentException("Para cartão de crédito, não é permitido desconto!");
        }
    };

    public abstract double percentualDesconto();

}