package org.example;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class ReactiveController {

    /*
    Change "jumped" to "jumps" to get a full alphabetical list.
     */
    private List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );

    public Observable<List<String>> getWords() {

        return Observable
                .just(words);
    }

    public Observable<String> getNumberedWords() {

        return Observable
                .fromArray(words.toArray())
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));
    }

    public Observable<String> getLetters() {

        return Observable
                .fromArray(words.toArray())
                .flatMap(word -> Observable.fromArray(((String) word).split("")))
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));
    }

    public Observable<String> getUniqueLetters() {

        return Observable
                .fromArray(words.toArray())
                .flatMap(word -> Observable.fromArray(((String) word).split("")))
                .distinct()
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));
    }

    public Observable<String> getUniqueSortedLetters() {

        return Observable
                .fromArray(words.toArray())
                .flatMap(word -> Observable.fromArray(((String) word).split("")))
                .distinct()
                .sorted()
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string));
    }
}
