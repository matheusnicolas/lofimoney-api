package com.lofi.lofimoney.api.repository;

import com.lofi.lofimoney.api.model.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release, Long> {
}
