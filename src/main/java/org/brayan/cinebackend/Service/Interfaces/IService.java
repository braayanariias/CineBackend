package org.brayan.cinebackend.Service.Interfaces;

import org.brayan.cinebackend.Exceptions.DaoException;
import org.brayan.cinebackend.Exceptions.DomainException;

import java.util.List;
import java.util.Optional;

public interface IService< T, S > {

    T save(T t) throws DomainException, DaoException;

    boolean update(T t) throws DomainException, DaoException;

    boolean deleteById(S s) throws DaoException;

    List<T> listAll();

    Optional<T> findById(S s);

    boolean existById(S s);
}
