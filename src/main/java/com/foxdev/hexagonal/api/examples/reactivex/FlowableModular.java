package com.foxdev.hexagonal.api.examples.reactivex;

import io.reactivex.rxjava3.core.BackpressureOverflowStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


@Log4j2
public class FlowableModular {
    public static void main(String[] args) throws InterruptedException {

        Flowable<String> source = Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";

        });


        Flowable<String> runBackground = source.subscribeOn(Schedulers.io());

        Flowable<String> showForeground = runBackground.observeOn(Schedulers.single());

        //showForeground.subscribe(System.out::println, Throwable::printStackTrace);

        showForeground.subscribe(s ->
                        log.info("valor "+s),
                        throwable -> log.info(throwable.getMessage()));

        Thread.sleep(2000);

        log.info("Example 1");
        Flowable<String> floawableExample = Flowable.just("A","B","C","D","E");
        floawableExample.map(s -> s.toUpperCase()).subscribe(s -> log.info(s));

        log.info("Example 2");

        String[] letras = new String[]{"A","B","C","D","E","F","G","H"};
        Flowable<String> flowableExample2 = Flowable.fromArray(letras);
        flowableExample2.subscribe(s -> log.info("flowable iterable  "+s));

        log.info("Example 3");

        List<String> letraList = Arrays.asList("A","B","C","D","E","F");
        Flowable<String> flowableExample3 = Flowable.fromIterable(letraList);
        flowableExample3.subscribe(s -> log.info("flowable iterable list "+s));

        log.info("Example 4");
        Optional<String> optional = Optional.ofNullable("cadena");
        Flowable<String> flowableExample4 = Flowable.fromOptional(optional);
        flowableExample4.subscribe(s -> log.info(" from optional  "+s));

        log.info("Example 5");
        Flowable<String> flowableExanmple5 = Flowable.fromCallable(() -> "cadena" );
        flowableExanmple5.subscribe(s -> log.info(s));

        Supplier<String> proveedor = () -> "supplier string";

        Flowable<String> flowableExample6 =  Flowable.fromSupplier(proveedor);



        Flowable<String> letrasFlow = Flowable.just("A","B","C","D","E");

        //Flowable<Integer> numerosFlow = Flowable.just(1,2,3,4,5,6).
        //subscribe(integer -> log.info(integer)).

        Flowable<Integer> numeros = Flowable.range(1,1000)
                .onBackpressureBuffer(20,() -> {}, BackpressureOverflowStrategy.DROP_OLDEST)
                //Simplemente onBackpressureDrop()descartarán las emisiones si el proceso descendente está demasiado ocupado para procesarlas
                .onBackpressureDrop(integer -> log.info(" "+integer))
                .delay(5, TimeUnit.MILLISECONDS)
                .doOnNext(integer -> log.info(" got  "+integer))
                        .observeOn(Schedulers.newThread(),true);

        Disposable disposable = numeros.subscribe(
                integer -> log.info("handled   "+integer),
                throwable -> log.info(throwable),
               () -> log.info("terminado")
        );

        Thread.sleep(5000);










    }
}
