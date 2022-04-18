package br.com.fiap.abctechservice.application;

import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.model.dto.OrderDTO;

public interface OrderApplication {

    Order createOrder(OrderDTO orderDto);

}
