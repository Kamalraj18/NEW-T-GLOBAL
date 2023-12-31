package com.example.StudentInformationSystem.Entity;

import com.example.StudentInformationSystem.util.constants.Previllages;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Authority {

    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    private Previllages privilege;






}
