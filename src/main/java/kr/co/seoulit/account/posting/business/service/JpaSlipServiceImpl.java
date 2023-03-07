package kr.co.seoulit.account.posting.business.service;

import kr.co.seoulit.account.posting.business.entity.SlipEntity;
import kr.co.seoulit.account.posting.business.repository.JournalRepository;
import kr.co.seoulit.account.posting.business.repository.SlipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaSlipServiceImpl implements JpaSlipService{
    @Autowired
    SlipRepository slipRepository;
    @Autowired
    JournalRepository journalRepository;

    @Override
    public List<SlipEntity> selectSlipList() {
        return null;
    }

    @Override
    public void removeSlip(String slipNo) {
        slipRepository.deleteById(slipNo);
    }

    @Override
    public void removeJournal(String journalNo) {
        journalRepository.deleteById(journalNo);
    }

}
