package kr.co.seoulit.account.operate.system.repository;

import kr.co.seoulit.account.operate.system.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, String> {

}
