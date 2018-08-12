package fi.vvagaytsev.fizzbuzz.rest;

import fi.vvagaytsev.fizzbuzz.service.FizzBuzzService;
import java.util.stream.LongStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @author Vladimir Vagaytsev
 * Date: 09/08/2018
 */
@RestController
@RequestMapping("/api")
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;

    @Autowired
    public FizzBuzzController(FizzBuzzService fizzBuzzService) {
        this.fizzBuzzService = fizzBuzzService;
    }

    @PostMapping(
            value = "/fizz-buzz",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_STREAM_JSON_VALUE},
            produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public Flux<String> fizzBuzz(@RequestBody Flux<Long> numbers) {
        return numbers
                .map(fizzBuzzService::fizzBuzzify)
                .subscribeOn(Schedulers.elastic())
                .log();
    }

    @GetMapping(
            value = "/fizz-buzz-range/{start}/{end}",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public Flux<String> fizzBuzzRange(@PathVariable("start") Long start,
                                      @PathVariable("end") Long end) {
        return Flux.fromStream(LongStream.rangeClosed(start, end).boxed())
                .map(fizzBuzzService::fizzBuzzify)
                .subscribeOn(Schedulers.elastic())
                .log();
    }
}