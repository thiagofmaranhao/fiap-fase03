package br.com.fiap.abctechservice.utils;

import br.com.fiap.abctechservice.model.Assistance;
import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.model.OrderLocation;
import br.com.fiap.abctechservice.model.dto.OrderDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.util.Calendar;
import java.util.List;

/**
 * Utilizado para gerar json dos objetos do sistema.
 */
public class JsonGenerator {

    public static void main(String[] args) throws JsonProcessingException {

        Assistance itemAssist = new Assistance(1L, "Mock Name", "Mock Description");
        Assistance itemAssist2 = new Assistance(2L, "Mock Name 2", "Mock Description 2");

        OrderLocation startOrderLocation = new OrderLocation(1L, 2.0, 2.0, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        OrderLocation endOrderLocation = new OrderLocation(1L, 2.0, 2.0, new java.sql.Date(Calendar.getInstance().getTime().getTime()));

        Order o1 = new Order(1L, 2L, List.of(itemAssist, itemAssist2), startOrderLocation, endOrderLocation);

        OrderDTO orderDTO = new OrderDTO(o1);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(orderDTO);

        System.out.println(json);

    }

}
