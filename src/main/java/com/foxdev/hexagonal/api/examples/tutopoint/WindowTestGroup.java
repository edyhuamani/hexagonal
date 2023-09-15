package com.foxdev.hexagonal.api.examples.tutopoint;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * El operador de ventanas funciona de manera similar al operador de búfer, pero permite reunir
 * elementos emitidos por un Observable en otro observable en lugar de una colección y emitir esos
 * Observables en lugar de colecciones
 */
public class WindowTestGroup {
    public static void main(String[] args) throws InterruptedException {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4,
                5, 6, 7, 8, 9);
        observable.subscribeOn(Schedulers.io())
                .delay(2, TimeUnit.SECONDS,Schedulers.io())
                .window(3)  //<--- agrupado por ese numero de elementos
                .subscribe(new Observer<Observable<Integer>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("Subscribed");
                    }

                    @Override
                    public void onNext(@NonNull Observable<Integer> integerObservable) {
                        System.out.println("onNext: ");
                        integerObservable.subscribe(value -> System.out.println(value));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println("Error");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done! ");
                    }
                });


        Thread.sleep(3000);
    }
}
