package com.foxdev.hexagonal.api.examples.reactivex;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import lombok.extern.log4j.Log4j2;

/**
 * Flowable: 0..N flows, supporting Reactive-Streams and backpressur
 * Observable: 0..N flows, no backpressure,
 * Single: a flow of exactly 1 item or an error,
 * Completable: a flow without items but only a completion or error signal,
 * Maybe: a flow with no items, exactly one item or an error.
 */
@Log4j2
public class RxJava1 {
    public static void main(String[] args) {
        Flowable.just("Hello World")
                .subscribe(s -> log.info(s));

        Flowable.just(1,2,3,4,5,6,7,8,9,10).subscribe(integer -> log.info("numero "+integer));

        Integer[] numeros ={1,2,3,4,5,6,7,8};
        Flowable.fromArray(numeros).subscribe(integer -> log.info("number  "+integer));

        Single.just("cadena de prueba")
                .map(s -> s.toUpperCase())
                .subscribe(s -> log.info("valor "+s));



        Flowable<Integer> flow = Flowable.range(1, 5)
                .map(v -> v * v)
                .filter(v -> v % 3 == 0)
                ;
        flow.subscribe(integer -> log.info(integer));

        Observable.create(emitter -> {
             emitter.onNext("1");
             emitter.onNext("2");
             emitter.onNext("3");
             emitter.onNext("4");

        }).subscribe(o -> log.info("elemento "+o));


        Flowable.fromCallable(() -> {
           Thread.sleep(1000);
           return "Done";
        });

    }

    public class Product{
        private String code;
        private String name;
    }
}
