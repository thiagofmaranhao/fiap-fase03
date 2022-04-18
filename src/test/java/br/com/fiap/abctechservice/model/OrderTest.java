package br.com.fiap.abctechservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class OrderTest {

    @Test
    void test_min_assists_false() {
        Order order = new Order();
        order.setAssistances(new ArrayList<>());
        Assertions.assertFalse(order.hasMinAssists());
    }

    @Test
    void test_min_assists_true() {
        Order order = new Order();
        List<Assistance> assistanceList = new ArrayList<>();

        for(int i =1; i <= 5; i++) {
            assistanceList.add(new Assistance());
        }

        order.setAssistances(assistanceList);

        Assertions.assertTrue(order.hasMinAssists());
    }

    @Test
    void test_exceeds_max_assists() {
        Order order = new Order();
        List<Assistance> assistanceList = new ArrayList<>();

        for(int i =1; i <= 25; i++) {
            assistanceList.add(new Assistance());
        }

        order.setAssistances(assistanceList);

        Assertions.assertTrue(order.exceedsMaxAssists());
    }

}
