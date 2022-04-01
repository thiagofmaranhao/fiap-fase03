package br.com.fiap.abctechservice.model.dto;

import br.com.fiap.abctechservice.model.Assistance;
import br.com.fiap.abctechservice.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ```json
 * {
 * "operator_id" : 0,
 * "services" : [1 , 2, 3],
 * "start" : {
 * 	"latitude" : 0.0,
 * 	"longitude" : 0.0,
 * 	"datetime" : "2022-02-19 00:00:00"
 * },
 * "end" : {
 * 	"latitude" : 0.0,
 * 	"longitude" : 0.0,
 * 	"datetime" : "2022-02-19 00:00:00"
 * }
 * ```
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private Long operatorId;
    private List<Long> assistances;
    private OrderLocationDTO startOrderLocation;
    private OrderLocationDTO endOrderLocation;

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.operatorId = order.getOperatorId();
        this.assistances = order.getAssistances()
                .stream()
                .map(Assistance::getId)
                .collect(Collectors.toList());
        this.startOrderLocation = new OrderLocationDTO(order.getEndOrderLocation());
        this.endOrderLocation = new OrderLocationDTO(order.getEndOrderLocation());
    }

}
