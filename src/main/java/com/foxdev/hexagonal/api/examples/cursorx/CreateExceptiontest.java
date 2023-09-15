package com.foxdev.hexagonal.api.examples.cursorx;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CreateExceptiontest {
    public static void main(String[] args) throws InterruptedException {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                emitter.onNext(15/3);
                emitter.onNext(5/0);
            }
        }).subscribeOn(Schedulers.io())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        log.info("TAG CREATE EXCEPTION -> onNext: " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        log.info("TAG CREATE EXCEPTION -> onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


        Thread.sleep(30000);
    }
}
