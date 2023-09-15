package com.foxdev.hexagonal.api.examples.create;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CreateJustTest {
    public static void main(String[] args) {
        // Just solo soporta 10 elementos
        Observable<Integer> observable = Observable.just(1,2,3,4,5,6,7,8,9,10);


        Observer observer1 = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                log.info("observer 1 "+Thread.currentThread().getName()+" "+o);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        Observer observer2 = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                log.info("observer 2 "+Thread.currentThread().getName()+" "+o);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        Observer observer3 = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                log.info("observer 3 "+Thread.currentThread().getName()+" "+o);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribeOn(Schedulers.newThread());
        observable.subscribe(observer1);
        observable.subscribe(observer2);
        observable.subscribe(observer3);

    }
}
