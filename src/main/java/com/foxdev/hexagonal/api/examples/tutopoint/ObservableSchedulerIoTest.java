package com.foxdev.hexagonal.api.examples.tutopoint;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.log4j.Log4j2;

/**
 * El método Schedulers.io() crea y devuelve un Programador destinado
 * al trabajo vinculado a IO. El grupo de subprocesos puede ampliarse según sea necesario.
 * Lo mejor para operaciones intensivas de E/S.
 * llamadas a apis
 */
@Log4j2
public class ObservableSchedulerIoTest {
    public static void main(String[] args) {
        Observable.just("A","AB","ABC","ACDD","ABCDE","ABCDEF")
                .flatMap(v -> ObservableTesterComputation.getLengthWithDelay(v)
                        .doOnNext(s-> log.info(""+Thread.currentThread().getName()))
                        .subscribeOn(Schedulers.io()))
                .subscribe(length -> System.out.println("Receiver Thread "
                        + Thread.currentThread().getName()
                        + ", Item length " + length));
    }
}
