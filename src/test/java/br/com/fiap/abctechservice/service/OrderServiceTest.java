package br.com.fiap.abctechservice.service;

import br.com.fiap.abctechservice.handler.exception.MaximumAssistancesException;
import br.com.fiap.abctechservice.handler.exception.MinimumAssistancesRequiredException;
import br.com.fiap.abctechservice.model.Assistance;
import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.repository.AssistanceRepository;
import br.com.fiap.abctechservice.repository.OrderRepository;
import br.com.fiap.abctechservice.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private AssistanceRepository assistanceRepository;
    private OrderService orderService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);

        orderService = new OrderServiceImpl(orderRepository, assistanceRepository);
        when(assistanceRepository.findById(any())).thenReturn(Optional.of(new Assistance(1L, "Teste", "Teste Description")));
    }

    @Test
    public void order_service_not_null() {
        Assertions.assertNotNull(orderService);
    }

    @Test
    public void create_order_success() throws Exception {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        orderService.saveOrder(newOrder, generate_mock_assistance(1));
        verify(orderRepository, times(1)).save(newOrder);
    }

    @Test
    public void create_order_error_minimum() throws Exception {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        Assertions.assertThrows(MinimumAssistancesRequiredException.class, () -> orderService.saveOrder(newOrder, List.of()));
        verify(orderRepository, times(0)).save(newOrder);
    }

    @Test
    public void create_order_error_null() throws Exception {
        Order newOrder = new Order();
        newOrder.setOperatorId(null);
        Assertions.assertThrows(MinimumAssistancesRequiredException.class, () -> orderService.saveOrder(newOrder, List.of()));
        verify(orderRepository, times(0)).save(newOrder);
    }

    @Test
    public void create_order_error_maximum() throws Exception {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        Assertions.assertThrows(MaximumAssistancesException.class, () -> orderService.saveOrder(newOrder, generate_mock_assistance(20)));
        verify(orderRepository, times(0)).save(newOrder);
    }

    @Test
    public void void_create_order_with_operatorId_Null() {
        Order newOrder = new Order();
        Assertions.assertThrows(NullPointerException.class, () -> orderService.saveOrder(newOrder, null));
    }

    private List<Long> generate_mock_assistance(int number) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int x = 0; x < number; x++) {
            arrayList.add(Integer.toUnsignedLong(x));
        }
        return arrayList;
    }

}

