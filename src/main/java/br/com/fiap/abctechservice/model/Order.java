package br.com.fiap.abctechservice.model;

import br.com.fiap.abctechservice.model.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "operator_id", nullable = false)
    private Long operatorId;

    @ManyToMany
    private List<Assistance> assistances;

    @OneToOne
    @JoinColumn(name = "start_order_location_id")
    private OrderLocation startOrderLocation;

    @OneToOne
    @JoinColumn(name = "end_order_location_id")
    private OrderLocation endOrderLocation;

    public Order(OrderDTO orderDTO) {
        this.id = orderDTO.getId();
        this.operatorId = orderDTO.getOperatorId();
        this.assistances = orderDTO.getAssistances()
                .stream()
                .map(assistanceDTO -> new Assistance(assistanceDTO))
                .collect(Collectors.toList());
        this.startOrderLocation = new OrderLocation(orderDTO.getStartOrderLocation());
        this.endOrderLocation = new OrderLocation(orderDTO.getEndOrderLocation());
    }

}
