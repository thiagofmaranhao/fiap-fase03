package br.com.fiap.abctechservice.service;

import br.com.fiap.abctechservice.model.Assistance;
import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.model.OrderLocation;
import br.com.fiap.abctechservice.repository.AssistanceRepository;
import br.com.fiap.abctechservice.repository.OrderRepository;
import br.com.fiap.abctechservice.service.impl.AssistanceServiceImpl;
import br.com.fiap.abctechservice.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.*;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    private OrderService orderService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderServiceImpl(orderRepository);
    }

    @Test
    public void test_list_success() {

        Assistance itemAssist = new Assistance(1L, "Mock Name", "Mock Description");
        Assistance itemAssist2 = new Assistance(2L, "Mock Name 2", "Mock Description 2");

        OrderLocation startOrderLocation = new OrderLocation(1L, 2, 2, null);
        OrderLocation endOrderLocation = new OrderLocation(1L, 2, 2, null);


        Order o1 = new Order(1L, 2L, List.of(itemAssist, itemAssist2), startOrderLocation, endOrderLocation);

        when(orderRepository.findAll()).thenReturn(List.of(o1));

        List<Order> values = orderService.getOrderList();

        Assertions.assertEquals(values.size(), 1);
        Assertions.assertSame(values.get(0), o1);

    }
}

