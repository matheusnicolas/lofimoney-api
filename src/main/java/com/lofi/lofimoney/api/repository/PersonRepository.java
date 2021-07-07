package com.lofi.lofimoney.api.repository;

import com.lofi.lofimoney.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
