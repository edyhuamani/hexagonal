package com.foxdev.hexagonal.api.examples.examples;

import io.reactivex.rxjava3.core.Observable;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MapExample {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(1,2,3,4,5,6,7,8,9);

        observable
                .map(integer -> integer+1)
                .map(integer -> "Hello world")
                .subscribe(integer -> log.info(integer));


        //mapOperatorReturnsDifferentData();
        //filterOperator()
        //combineMapAndFilter()

    }

    private static void combineMapAndFilter() {
    }

    private static void filterOperator() {
    }

    private static void mapOperatorReturnsDifferentData() {
    }


}
