package com.devTest.UnitTestingWithSpringJunitAndMockito.repository;

import com.devTest.UnitTestingWithSpringJunitAndMockito.model.EConfirm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EConfirmRepository extends JpaRepository<EConfirm, Integer> {
}
