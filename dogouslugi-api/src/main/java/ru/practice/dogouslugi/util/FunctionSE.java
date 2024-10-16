package ru.practice.dogouslugi.util;

import ru.practice.dogouslugi.exception.ServiceException;

@FunctionalInterface
public interface FunctionSE<T>  {
    T apply(T t) throws ServiceException;
}

