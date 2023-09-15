package com.foxdev.hexagonal.api.examples.tutopoint;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;


import java.util.concurrent.Executors;

import static com.foxdev.hexagonal.api.examples.tutopoint.ObservableTesterComputation.getLengthWithDelay;

/**
 * El método Schedulers.from(Executor) convierte un Ejecutor en una nueva instancia del Programador.
 */
public class ObservableSchedulerFrom {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("A", "AB", "ABC")
                .flatMap(s -> getLengthWithDelay(s)
                    .doOnNext(v -> System.out.println("Processing Thread "
                        + Thread.currentThread().getName()))
                    .subscribeOn(Schedulers.from(Executors.newFixedThreadPool(3))))
                .subscribe(integer ->  System.out.println("Receiver Thread suscriptor "
                        + Thread.currentThread().getName()
                        + ", Item length " + integer) );
        Thread.sleep(10000);
    }
}
