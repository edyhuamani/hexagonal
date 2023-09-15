package com.foxdev.hexagonal.api.examples.tutopoint;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Random;


/**
 * El método Schedulers.computation() crea y devuelve un programador destinado al trabajo computacional.
 * El número de subprocesos que se programarán depende de las CPU presentes en el sistema. Se permite
 * un hilo por CPU. Lo mejor para bucles de eventos u operaciones de devolución de llamadas.
 */
public class ObservableTesterComputation {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("A", "AB", "ABC")
                .flatMap(v -> getLengthWithDelay(v)
                        .doOnNext(s -> System.out.println("Processing Thread "+ Thread.currentThread().getName()))
                        .subscribeOn(Schedulers.computation())
                )
                .subscribe(length -> System.out.println("Receiver Thread "
                        + Thread.currentThread().getName()
                        + ", Item length " + length));

        Thread.sleep(10000);
    }

    protected static Observable<Integer> getLengthWithDelay(String v) {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(3) * 1000);
            return Observable.just(v.length());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
