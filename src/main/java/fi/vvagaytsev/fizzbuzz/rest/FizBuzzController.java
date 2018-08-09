package fi.vvagaytsev.fizzbuzz.rest;

import fi.vvagaytsev.fizzbuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Vladimir Vagaytsev
 * Date: 09/08/2018
 */
@RestController
@RequestMapping("/api")
public class FizBuzzController {

    private final FizzBuzzService fizzBuzzService;

    @Autowired
    public FizBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @PostMapping("/fizz-buzz")
    public List<String> fizzBuzz(@RequestBody List<Long> numbers) {
        return fizzBuzzService.map(numbers);
    }
}