package com.foxdev.hexagonal.api.examples.cursorx;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.TimeUnit;
@Log4j2
public class IntervalTest {
    public static void main(String[] args) throws InterruptedException {
      /*
        Interva establece un perido de tiempo de ejecucion al observable.
        para que se detenga, se establece un take para tomar una cantidad de items
        generados por el interval.
      */
        Observable
                .interval(1, TimeUnit.SECONDS)
                .take(25)
                .subscribeOn(Schedulers.trampoline())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        log.info("TAG1 "+aLong, "INTERVAL -> onNext: " + aLong);
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
