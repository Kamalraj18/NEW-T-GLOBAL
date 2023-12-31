package com.example.StudentInformationSystem.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DegreeDTo {

    private int degreeId;
    private String degreeName;

    public DegreeDTo(int degreeId, String degreeName) {
        this.degreeId = degreeId;
        this.degreeName = degreeName;
    }

    public DegreeDTo() {
    }
}
