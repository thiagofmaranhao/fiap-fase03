package br.com.fiap.abctechservice.model.dto;

import br.com.fiap.abctechservice.model.OrderLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLocationDTO {

    private Long id;
    private Double latitude;
    private Double longitude;
    private Date date;

    public OrderLocationDTO(OrderLocation orderLocation) {
        this.id = orderLocation.getId();
        this.latitude = orderLocation.getLatitude();
        this.longitude = orderLocation.getLongitude();
        this.date = orderLocation.getDate();
    }

}
