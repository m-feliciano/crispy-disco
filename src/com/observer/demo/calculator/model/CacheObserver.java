package com.observer.demo.calculator.model;

@FunctionalInterface
public interface CacheObserver {

	void value(String newString);
}
