package com.example.StudentInformationSystem.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectDegreeDTO {
    private int subject_id;
    private String Subject_name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<DegreeDTo> DegreeList;

    public SubjectDegreeDTO(int subject_id, String subject_name, List<DegreeDTo> degree_id) {
        this.subject_id = subject_id;
        Subject_name = subject_name;
        DegreeList = degree_id;
    }

    public SubjectDegreeDTO() {

    }
}
