package org.nikita.vkpractisetask.services;

import lombok.RequiredArgsConstructor;
import org.nikita.vkpractisetask.models.Audit;
import org.nikita.vkpractisetask.repositories.AuditRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditRepository auditRepository;


    public void save(Audit audit) {
        auditRepository.save(audit);
    }
}
