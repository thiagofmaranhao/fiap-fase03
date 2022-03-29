package br.com.fiap.abctechservice.model.dto;

import br.com.fiap.abctechservice.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private Long operatorId;
    private List<AssistanceDTO> assistances;
    private OrderLocationDTO startOrderLocation;
    private OrderLocationDTO endOrderLocation;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.operatorId = order.getOperatorId();
        this.assistances = order.getAssistances()
                .stream()
                .map(assistance -> new AssistanceDTO(assistance))
                .collect(Collectors.toList());
        this.startOrderLocation = new OrderLocationDTO(order.getEndOrderLocation());
        this.endOrderLocation = new OrderLocationDTO(order.getEndOrderLocation());
    }

}
