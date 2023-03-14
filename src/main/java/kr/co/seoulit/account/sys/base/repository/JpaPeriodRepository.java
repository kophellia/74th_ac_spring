package kr.co.seoulit.account.sys.base.repository;

import kr.co.seoulit.account.sys.base.entity.PeriodEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface JpaPeriodRepository extends CrudRepository<PeriodEntity, String> {
    ArrayList<PeriodEntity> findAllBy();

    PeriodEntity findAccountPeriodNoByPeriodStartDateAndPeriodEndDate(LocalDate periodStartDate, LocalDate periodEndDate);
}
