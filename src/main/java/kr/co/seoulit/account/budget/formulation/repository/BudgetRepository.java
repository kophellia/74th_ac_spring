package kr.co.seoulit.account.budget.formulation.repository;

import kr.co.seoulit.account.budget.formulation.entity.BudgetEntity;
import kr.co.seoulit.account.budget.formulation.entity.BudgetId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends CrudRepository<BudgetEntity, BudgetId>{

}
