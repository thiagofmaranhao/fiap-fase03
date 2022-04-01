package br.com.fiap.abctechservice.model;

import br.com.fiap.abctechservice.model.dto.OrderLocationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "date", nullable = false)
    private Date date;

    public OrderLocation(OrderLocationDTO orderLocation) {
        this.id = orderLocation.getId();
        this.latitude = orderLocation.getLatitude();
        this.longitude = orderLocation.getLongitude();
        this.date = orderLocation.getDate();
    }

}
