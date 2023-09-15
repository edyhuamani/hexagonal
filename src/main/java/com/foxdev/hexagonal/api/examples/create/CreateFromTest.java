package com.foxdev.hexagonal.api.examples.create;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class CreateFromTest {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17);

        List<Integer> numeros2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17);

        String[] letters =   {"a","b","c","d","e","f","g","h","i","j","k","l"};


        // acepta una coleccion y los maneja individualmente
        Observable<Integer> observable = Observable.fromIterable(numeros);
        // acepta una coleccion y los manipula como un grupo o una unica lista
        Observable<List<Integer>> observableNumbers = Observable.fromArray(numeros2);

        Observable<String> observableLetters = Observable.fromArray(letters);


        Observer observer =new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                log.info("elemento "+o);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


        observable.subscribe(observer);


        Observer observer2 =new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                log.info("elemento array "+o);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observableNumbers
                .map(integers -> integers)
                .subscribe(observer2);


        Observer observerLetter =new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                log.info("elemento letter "+o);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


    }
}
