package pl.camp.it;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import pl.camp.it.model.Address;
import pl.camp.it.model.User;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String url = "http://localhost:8080/user/";

        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(url + "1",
                User.class,
                new HashMap<>());

        System.out.println(user);

        Address address1 = new Address();
        address1.setId(1);
        address1.setCity("Bytom");
        address1.setStreet("Ogorodowa");
        address1.setNo(5);

        User user1 = new User();
        user1.setId(5);
        user1.setLogin("mateusz2");
        user1.setPass("mateusz");
        user1.setAddress(address1);

        //---------------------------- NAGŁÓWKI ----------------------
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("important-header", "costam");

        //--------------------- ZAPYTANIE (REQUEST) ---------------------
        HttpEntity<User> request = new HttpEntity<>(user1, httpHeaders);

        //----------------- WYKONANIE ZAPYTANIA ------------------------
        User responseEntity = restTemplate.postForObject(url+"1",
                request,
                User.class,
                new HashMap<>());

        System.out.println(responseEntity);
    }
}