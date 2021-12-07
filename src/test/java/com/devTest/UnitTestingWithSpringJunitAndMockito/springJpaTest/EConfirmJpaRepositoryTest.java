package com.devTest.UnitTestingWithSpringJunitAndMockito.springJpaTest;


import com.devTest.UnitTestingWithSpringJunitAndMockito.model.EConfirm;
import com.devTest.UnitTestingWithSpringJunitAndMockito.repository.EConfirmRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EConfirmJpaRepositoryTest {
    @Autowired
    private EConfirmRepository eConfirmRepository;


    @BeforeEach
    public void setUp() {
        EConfirm eConfirm = new EConfirm(1,"001","test", LocalDate.parse("2021-12-02"),
                LocalDate.parse("2021-12-01"));
        eConfirmRepository.save(eConfirm);
    }

    @Test
    public void whencalledsave_thencorrectuser() {
        EConfirm eConfirm = new EConfirm(1,"001","test", LocalDate.parse("2021-12-02"),
                LocalDate.parse("2021-12-01"));
        eConfirmRepository.save(eConfirm);
        List<EConfirm> econfirmList = eConfirmRepository.findAll();
        Assertions.assertEquals(econfirmList.size(), 1);
    }

    @Test
    public void whencalledsave_thencorrectuser1() {
        Optional<EConfirm> mayBeEConfirm = eConfirmRepository.findById(1);
        Assertions.assertEquals(mayBeEConfirm.isPresent(), true);
        EConfirm eConfirm = mayBeEConfirm.get();
        Assertions.assertEquals(eConfirm.getEmployeeNo(), "001");
    }


}
