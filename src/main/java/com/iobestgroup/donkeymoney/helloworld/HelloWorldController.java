package com.iobestgroup.donkeymoney.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * W tym miejscu rejestrujemy 2 http requesty
 *
 * @author miwas
 * @version 1.0
 * @since 21.10.17
 */
@RestController
public class HelloWorldController {

    @Autowired
    public HelloWorldController(HelloWorldRepository helloWorldRepository) {
        this.helloWorldRepository = helloWorldRepository;
    }

    @GetMapping("googlece1bc7e841e70594")
    public String googlece1bc7e841e70594(){
        return "googlece1bc7e841e70594";
    }

    // sprawia, że baza danych jest automatycznie podłączona
    private final HelloWorldRepository helloWorldRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public
    Iterable<HelloWorld> getAllHelloWorldsFromDatabase() {
        return helloWorldRepository.findAll();
    }

    /**
     * Po wysłaniu POST'a z JSON'em:
     * {
     * "message": "test"
     * }
     * do tabeli hello_world zostanie zapisany nowy rekord
     */
    @PostMapping(value = "/add") // skrócona wersja od @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewHelloWorld(@Param("message") String message) { // po wysłaniu JSON'a
        HelloWorld newItem = new HelloWorld();
        newItem.setMessage(message);

        helloWorldRepository.save(newItem);

        return "OK";
    }

    @GetMapping(value = "/")
    public String index() {
        return "DonkeyMoney's gonna make you rich!";
    }

    @GetMapping(value = "/ping")
    public String ping() {
        return "pong";
    }
}
