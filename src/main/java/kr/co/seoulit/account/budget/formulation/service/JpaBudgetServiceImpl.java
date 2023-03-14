package kr.co.seoulit.account.budget.formulation.service;

import kr.co.seoulit.account.budget.formulation.entity.BudgetEntity;
import kr.co.seoulit.account.budget.formulation.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JpaBudgetServiceImpl implements JpaBudgetService {
   @Autowired
   BudgetRepository budgetRepository;

   @Override
   public void save(BudgetEntity budgetEntity){
      budgetRepository.save(budgetEntity);
   }

   @Override
   public ArrayList<BudgetEntity> findBudget(String deptCode, String workplaceCode, String accountPeriodNo, String accountInnerCode, String budgetingCode) {
      return budgetRepository.findByDeptCodeAndWorkplaceCodeAndAccountInnerCodeAndAccountPeriodNoAndBudgetingCode(deptCode, workplaceCode, accountInnerCode, accountPeriodNo, budgetingCode);
   }
}

