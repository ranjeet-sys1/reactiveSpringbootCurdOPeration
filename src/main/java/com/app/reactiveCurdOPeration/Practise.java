package com.app.reactiveCurdOPeration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Practise {
    public static void main(String[] args) {

        //getMOno().subscribe(System.out::println);
        getFlux().subscribe(System.out::println);
    }
    public static Mono<String> getMOno(){
        return Mono.just("Java").log();
    }
    public static Flux<String> getFlux(){
        List<String> java = List.of("Java", ".net", "c#", "python");
        return Flux.fromIterable(java).log();

    }
}
