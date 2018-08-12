# fizzbuzz-api

Simple Reactive REST API for FizzBuzz game.

# How to launch
1. Run maven build from the repo root: `mvn clean package`
2. Execute the jar file from the `target` dir or run the project form the IDE

# Reactive REST API
The service has 2 endpoints:
1. `POST {baseUrl}/api/fizz-buzz` accepts an array of numbers as a payload. Returns the stream of fizz-buzzed numbers.
2. `GET {baseUrl}/api/fizz-buzz-range/{start}/{end}` accepts 2 numbers as path variables. converts the closed range of `[start, end]` to the fizz-buzz number and returns tje result as a stream.