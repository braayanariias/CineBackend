package org.brayan.cinebackend.Persistence.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.brayan.cinebackend.Persistance.Interfaces.Model;
import org.brayan.cinebackend.Utils.Routines;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cinema")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cinema implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Cinema;

    @Column(nullable = false, length = 50)
    @NotEmpty
    private String cin_name;

    @Column(nullable = false, length = 100)
    @NotEmpty
    private String cin_address;

    @Column(length = 100)
    private String cin_neighborhood;

    @Column(nullable = false)
    @Positive
    @DecimalMax(value = "1000")
    private String cin_capacity;

    @ElementCollection
    private List<Long> cin_list_entries;


    @Override
    public boolean isInsertValid() {
        return false;
    }

    @Override
    public boolean isUpdateValid() {
        return false;
    }

    public void setCustomCin_List_Entries(List<Long> cin_list_entries) {
        if (Routines.isEmptyOrNull(cin_list_entries)) {
            cin_list_entries = new ArrayList<Long>();
        }
        this.cin_list_entries = cin_list_entries;
    }
}
