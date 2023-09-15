package com.foxdev.hexagonal.api.examples.cursorx;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.log4j.Log4j2;

/**
 * Create RXjava test
 */
@Log4j2
public class CreateTest {
    public static void main(String[] args) throws InterruptedException {
        /*
            Create crea un observable con emiciones personalizadas y controladas
        */

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
                emitter.onNext("J");
                emitter.onNext("O");
                emitter.onNext("N");
                emitter.onNext("A");
                emitter.onNext("T");
                emitter.onNext("H");
                emitter.onNext("A");
                emitter.onNext("N");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.trampoline())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        log.info("TAG1 "+o+ " "+Thread.currentThread().getName());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



        Thread.sleep(30000);

    }
}
