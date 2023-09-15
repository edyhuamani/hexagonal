package com.foxdev.hexagonal.api.examples.tutopoint;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.log4j.Log4j2;

import java.util.Random;

/**
 * El método Schedulers.newThread() crea y devuelve un Programador que crea un
 * nuevo subproceso para cada unidad de trabajo.
 */
@Log4j2
public class ObservableNewThreadTester {
    public static void main(String[] args) throws InterruptedException {


        Observable.just("A","AB","ABC")
                .flatMap(s -> getLengthWithDelay(s)
                                .doOnNext(o -> log.info("Processing Thread  "+Thread.currentThread().getName()))
                                .subscribeOn(Schedulers.newThread()))
                .subscribe(
                        length -> log.info(" Receiver Thread "+Thread.currentThread().getName()+" Item length "+length),
                        error -> log.info(error.getMessage()),
                        () -> log.info("finalizado")
                );


        Thread.sleep(10000);
    }

    private static Observable<Integer> getLengthWithDelay(String s) {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(3)*1000);
            log.info("longitud "+s.length());
            return Observable.just(s.length());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;

    }
}
