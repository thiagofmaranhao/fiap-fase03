package br.com.fiap.abctechservice.application;

import br.com.fiap.abctechservice.model.dto.OrderDTO;

public interface OrderApplication {

    void createOrder(OrderDTO orderDto);

}
