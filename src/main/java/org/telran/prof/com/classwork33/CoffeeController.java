package org.telran.prof.com.classwork33;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoffeeController {
    private List<Coffee> coffees = new ArrayList<>();


    public CoffeeController() {
        coffees.addAll(
                List.of(new Coffee("Arabica"),
                        new Coffee("Ganador"),
                        new Coffee("Tchibo"))
        );
    }
    @GetMapping("/coffeelist")
    public  Iterable<Coffee> getCoffee(){
        return coffees;
    }

    @PostMapping("/coffeelist/coffee")
    public Coffee createCoffee(@RequestBody Coffee coffee){
        coffees.add(coffee);
        return coffee;
    }

    @DeleteMapping("/coffeelist/{uuid}")
    public void deleteCoffee(@PathVariable String uuid){
        coffees.removeIf(c -> c.getUuid().equals(uuid));
    }

    @PutMapping("/coffeelist/{uuid}")
    public Coffee putCoffee(@PathVariable String uuid, @RequestBody Coffee coffee) {
        for (Coffee c : coffees) {
            if (c.getUuid().equals(uuid)) {
                c.setName(coffee.getName());
                return c;
            }
        }
        return  null;
    }

}
