package com.foxdev.hexagonal.api.examples.tutopoint;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RxJavaOperator {
    public static void main(String[] args) {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        StringBuilder result = new StringBuilder();
        Observable<String> observable = Observable.fromArray(letters);
        observable
                .map(s -> s.toUpperCase())
                .subscribe(s -> result.append(s));
        log.info(result);

        observable
                .map(s -> s.toUpperCase())
                .subscribe(s ->log.info(" elemento "+s));

        // Repeat 5 times
        observable
                .repeat(5)
                .map(s -> s.toUpperCase())
                .subscribe(s ->log.info(" elemento "+s));

        observable
                .map(s -> s.toUpperCase())

                .subscribe(s ->log.info(" elemento "+s));


    }
}
