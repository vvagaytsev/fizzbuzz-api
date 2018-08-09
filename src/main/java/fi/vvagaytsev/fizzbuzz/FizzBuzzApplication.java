package fi.vvagaytsev.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * @author Vladimir Vagaytsev
 * Date: 09/08/2018
 */
@SpringBootApplication
public class FizzBuzzApplication {

    public static void main(String[] args) {
        SpringApplication.run(FizzBuzzApplication.class, args);
    }

    @Bean
    public CommonsRequestLoggingFilter commonsRequestLoggingFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(1000);
        filter.setIncludeHeaders(false);
        filter.setBeforeMessagePrefix("INCOMING REQUEST : ");
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
    }
}