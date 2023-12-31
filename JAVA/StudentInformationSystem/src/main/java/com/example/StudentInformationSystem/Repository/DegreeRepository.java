package com.example.StudentInformationSystem.Repository;

import com.example.StudentInformationSystem.DTO.DegreeDTo;
import com.example.StudentInformationSystem.Entity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DegreeRepository extends JpaRepository<Degree,Integer> {
    Optional<Degree> findByDegreeName(String degreeName);

    List<Degree> findAllByIdIn(List<DegreeDTo> degreeIds);
}
