package com.foxdev.hexagonal.api.examples.reactivex;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ObservableCreateDispose {

    public static void main(String[] args) {
        Observable.create(emitter -> {
          while (!emitter.isDisposed()){
              long time = System.currentTimeMillis();
              emitter.onNext(time);
              if (time % 2 !=0 ){
                  emitter.onError(new IllegalAccessException("Odd millisecond"));
                  break;
              }
          }
        }).subscribe(o -> log.info(o),
                throwable -> log.info(throwable));


    }
}
