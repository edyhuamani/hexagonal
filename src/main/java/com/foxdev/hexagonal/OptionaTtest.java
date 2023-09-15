package com.foxdev.hexagonal;

import lombok.extern.log4j.Log4j2;

import java.util.Optional;
@Log4j2
public class OptionaTtest {
    public static void main(String[] args) {
        //Optional<String> optional= Optional.of("mensaje");
        Optional<String> optional= Optional.ofNullable(null);

        log.info("empty  "+optional.isEmpty());
        log.info("present "+ optional.isPresent());
        /*
        String  orElse = optional
                .map(String::toUpperCase)
                .orElse("world");
        */
        /*
        String  orElse = optional
                .map(String::toUpperCase)
                .orElseGet(() -> {return "world2"});
        */
        /*
        String  orElse = optional
                .map(String::toUpperCase)
                .orElseGet(() -> {return "world2"});
        */
        /*
        String  orElse = optional
                .map(String::toUpperCase)
                .orElseThrow(() -> new IllegalStateException("ilegal excepcion "));
        */
        optional.ifPresent(s -> log.info(s));

        //String  orElse = optional.orElse("other world");
        //log.info(" "+orElse);





    }


}
