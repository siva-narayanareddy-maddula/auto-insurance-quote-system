package org.siva.narayan.aiqs.repo;

import org.siva.narayan.aiqs.entity.LoginCredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(value = "aiqsTransactionManager")
public interface LoginCredentialsRepo extends JpaRepository<LoginCredentialsEntity, Long> {

	
}
