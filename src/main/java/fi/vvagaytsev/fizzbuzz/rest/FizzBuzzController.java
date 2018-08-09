package fi.vvagaytsev.fizzbuzz.rest;

import fi.vvagaytsev.fizzbuzz.service.FizzBuzzService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Vladimir Vagaytsev
 * Date: 09/08/2018
 */
@Api(description = "FizzBuzz API")
@RestController
@RequestMapping("/api")
@Validated
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @PostMapping("/fizz-buzz")
    public List<String> fizzBuzz(@RequestBody
                                 @NotNull
                                 @Size(min = 1, max = 100)
                                 List<@NotNull @Positive Long> numbers) {
        return fizzBuzzService.map(numbers);
    }
}