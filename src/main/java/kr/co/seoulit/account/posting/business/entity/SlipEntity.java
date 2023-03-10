package kr.co.seoulit.account.posting.business.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "slip")
@NoArgsConstructor
@Data
public class SlipEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String slipNo;
    private String accountPeriodNo;
    private String deptCode;
    private String slipType;
    private String expenseReport;
    private String reportingEmpCode;
    private String approvalEmpCode;
    private String approvalDate;
    private String slipStatus;

//    private String deptName;
//    private String id;
//    private String authorizationStatus;
//    private String reportingEmpName;
//    private String reportingDate;
//    private String balanceDivision;
//    private String positionCode;
}
