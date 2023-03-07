package kr.co.seoulit.account.budget.formulation.service;

import kr.co.seoulit.account.budget.formulation.entity.BudgetEntity;

public interface JpaBudgetService {

    public void savebudget(BudgetEntity budgetEntity) throws Exception;
}

