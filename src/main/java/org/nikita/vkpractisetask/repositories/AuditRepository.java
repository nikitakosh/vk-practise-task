package org.nikita.vkpractisetask.repositories;

import org.nikita.vkpractisetask.models.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Integer> {

}
