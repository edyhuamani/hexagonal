package com.foxdev.hexagonal;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Log4j2
public class ObservableFactories {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5,6,7,8);

        Observable.create(emitter -> log.info(1));

        List<String> numbers= Arrays.asList("A","b","C","D","E","F");

        Observable.fromArray(numbers);

        Optional<String> key="123456789".describeConstable();
        Observable.fromOptional(key);


    }
}
