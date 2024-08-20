package org.brayan.cinebackend.Services;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.brayan.cinebackend.Exceptions.DaoException;
import org.brayan.cinebackend.Exceptions.DomainException;
import org.brayan.cinebackend.Persistence.Entity.Cinema;
import org.brayan.cinebackend.Repository.CinemaRepository;
import org.brayan.cinebackend.Service.Interfaces.IService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class CinemaService implements IService<Cinema, Long> {

    private final CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public Cinema validateInput(@Valid Cinema cinema) throws ConstraintViolationException, DomainException {
        if (cinema == null) {
            throw new DomainException("the register is not valid");
        }
        return cinema;
    }

    @Override
    public Cinema save(Cinema cinema) throws DomainException, DaoException {
        cinemaRepository.save(cinema);
        return null;
    }

    @Override
    public boolean update(Cinema cinema) throws DomainException, DaoException {
        Cinema cinemaValidate = validateInput(cinema);
        List<Long> listEntries =
                cinemaValidate.getCin_list_entries();
        cinemaRepository.save(cinemaValidate);
        return false;
    }

    @Override
    public boolean deleteById(Long aLong) throws DaoException {
        return false;
    }

    @Override
    public List<Cinema> listAll() {
        return List.of();
    }

    @Override
    public Optional<Cinema> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existById(Long aLong) {
        return false;
    }
}
