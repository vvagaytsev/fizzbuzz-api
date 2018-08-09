package fi.vvagaytsev.fizzbuzz.service;

import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vladimir Vagaytsev
 * Date: 09/08/2018
 */
@Service
public class FizzBuzzService {

    @Nonnull
    public List<String> map(@Nonnull List<Long> numbers) {
        return numbers.stream()
                .map(this::fizzBuzzify)
                .collect(Collectors.toList());
    }

    @Nonnull
    private String fizzBuzzify(@Nonnull Long number) {
        if (isDivisibleBy(number, 15)) {
            return "FizzBuzz";
        }
        if (isDivisibleBy(number, 5)) {
            return "Buzz";
        }
        if (isDivisibleBy(number, 3)) {
            return "Fizz";
        }
        return String.valueOf(number);
    }

    private boolean isDivisibleBy(long number, long divisor) {
        return number % divisor == 0;
    }
}