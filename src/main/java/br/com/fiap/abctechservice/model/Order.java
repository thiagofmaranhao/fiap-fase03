package br.com.fiap.abctechservice.model;

import br.com.fiap.abctechservice.model.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {
 * "operator_id" : 0,
 * "services" : [1 , 2, 3],
 * "start" : {
 * "latitude" : 0.0,
 * "longitude" : 0.0,
 * "datetime" : "2022-02-19 00:00:00"
 * },
 * "end" : {
 * "latitude" : 0.0,
 * "longitude" : 0.0,
 * "datetime" : "2022-02-19 00:00:00"
 * }
 */
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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "start_order_location_id")
    private OrderLocation startOrderLocation;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "end_order_location_id")
    private OrderLocation endOrderLocation;

    public boolean hasMinAssists() {
        return assistances.size() > 0;
    }

    public boolean exceedsMaxAssists() {
        return assistances.size() > 15;
    }

}
