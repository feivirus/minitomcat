package com.feivirus.minitomcat.util;

@FunctionalInterface
public interface Parser<T, R> {
    R parse(T value);
}
