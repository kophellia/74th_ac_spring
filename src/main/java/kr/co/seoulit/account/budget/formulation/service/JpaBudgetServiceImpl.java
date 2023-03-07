package kr.co.seoulit.account.budget.formulation.service;

import kr.co.seoulit.account.budget.formulation.entity.BudgetEntity;
import kr.co.seoulit.account.budget.formulation.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaBudgetServiceImpl implements JpaBudgetService {
   @Autowired
   BudgetRepository budgetRepository;

   @Override
   public void savebudget(BudgetEntity budgetEntity) throws Exception{
      budgetRepository.save(budgetEntity);
   }
}

