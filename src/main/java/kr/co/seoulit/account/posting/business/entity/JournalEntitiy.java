package kr.co.seoulit.account.posting.business.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Journal")
@NoArgsConstructor
@Data
public class JournalEntitiy {

    @Id
    private String journalNo;
    private String balanceDivision;
    private String accountCode;
    private String accountName;
    private String customerCode;
    private String customerName;
    private String leftDebtorPrice;
    private String rightCreditsPrice;
    private String price;
    private String deptCode;
    private String accountPeriodNo;
//    private List<JournalDetailBean> journalDetailList;

    private String id;
    private String slipNo;


}
