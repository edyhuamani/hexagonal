package com.foxdev.hexagonal.api.examples.reactivex;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class FlowableSchedullers {
    public static void main(String[] args) throws InterruptedException {
        Flowable.range(1,10)
                .observeOn(Schedulers.computation())
                .map(integer -> integer * integer)
                .blockingSubscribe(integer -> log.info(integer));

        Flowable.range(1,20)
                .observeOn(Schedulers.computation())
                .map(integer -> integer * integer)
                .subscribe(integer -> log.info(integer));


        Thread.sleep(5000);
        //Schedulers.computation(): Ejecute un trabajo informático intensivo en un número fijo de subprocesos
        Flowable.range(1,10)
                .flatMap(v ->
                        Flowable.just(v).
                        subscribeOn(Schedulers.computation())
                        .map(w-> w * w * w )
                )
                .blockingSubscribe(integer -> log.info(integer));

        Flowable.range(1,10)
                .parallel()
                .runOn(Schedulers.computation())
                .map(v ->  v * v)
                .sequential()
                .blockingSubscribe(integer -> log.info(integer));

    }
}
