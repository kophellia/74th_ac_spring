package kr.co.seoulit.account.posting.business.service;

import kr.co.seoulit.account.posting.business.entity.SlipEntity;

import java.util.List;

public interface JpaSlipService {
    List<SlipEntity> selectSlipList();
    void removeSlip(String slipNo);
    void removeJournal(String journalNo);
}
