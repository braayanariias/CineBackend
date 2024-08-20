package org.brayan.cinebackend.Repository;

import org.brayan.cinebackend.Persistence.Entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {



}
