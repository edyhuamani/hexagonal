package com.foxdev.hexagonal.api.examples.tutopoint;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.log4j.Log4j2;

import java.util.Random;

/**
 * El método Schedulers.trampoline() crea y devuelve un programador que pone en cola el trabajo en
 * el hilo actual para que se ejecute después de que se complete el trabajo actual.
 */
@Log4j2
public class ObservableTrampolineTester {
    public static void main(String[] args) {
        Observable.just("A","AB","ABC")
                .flatMap(s -> getLeghtwithDelay(s))
                .doOnNext(integer -> log.info(integer+" Processing thread  "+Thread.currentThread().getName()))
                .subscribeOn(Schedulers.trampoline())
                .subscribe(
                        integer -> log.info("Receiver Thread "+integer+" "+Thread.currentThread().getName()),
                        error-> log.error(error),
                        () -> log.info("completado")
                );
    }

    private static ObservableSource<Integer> getLeghtwithDelay(String s) {
        log.info(s);
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(3)*1000);
            log.info("longitud "+s.length());
            return Observable.just(s.length());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
