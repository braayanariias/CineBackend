package org.brayan.cinebackend.Persistance.Interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Transient;

public interface Model {

    //Return True if object is valid for insert
    @Transient
    @JsonIgnore
    public boolean isInsertValid();

    //Return True if object is valid for update
    @Transient
    @JsonIgnore
    public boolean isUpdateValid();

}
