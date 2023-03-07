package kr.co.seoulit.account.budget.formulation.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "budget")
@NoArgsConstructor
@Data
@IdClass(BudgetId.class)
public class BudgetEntity implements Serializable {



    @Id
    private String accountInnerCode;
    @Id
    private String accountPeriodNo;
    @Id
    private String budgetingCode;
    @Id
    private String deptCode;
    @Id
    private String workplaceCode;
    private String m1Budget;
    private String m2Budget;
    private String m3Budget;
    private String m4Budget;
    private String m5Budget;
    private String m6Budget;
    private String m7Budget;
    private String m8Budget;
    private String m9Budget;
    private String m10Budget;
    private String m11Budget;
    private String m12Budget;
}
