package com.conpinion.util;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public sealed interface Result<R, L> {
    record Right<R,L>(R value) implements Result<R, L> {
    }

    record Left<R,L>(L value) implements Result<R,L> {
    }

    static <R,L> Result<R, L> right(R value) {
        return new Right(value);
    }

    static <R, L> Result<R, L> left(L value) {
        return new Left<R,L>(value);
    }

    default <X> Result<X, L> map(Function<R, X> fn) {
        return switch (this) {
            case Right<R,L> r -> Result.right(fn.apply(r.value));
            case Left<R, L> l -> Result.left(l.value());
        };
    }

    default <X> Result<X, L> then(Consumer<R> fn) {
        return switch (this) {
            case Right<R,L> r -> {
                fn.accept(r.value);
                yield Result.right(null);
            }
            case Left<R, L> l -> Result.left(l.value());
        };
    }

    default void orError(Consumer<L> fn) {
        if (this instanceof Left<R, L> l) {
            fn.accept(l.value);
        }
    }
}
