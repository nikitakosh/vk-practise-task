package org.nikita.vkpractisetask.aop;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.nikita.vkpractisetask.models.Audit;
import org.nikita.vkpractisetask.services.AuditService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class AuditAspect {

    private final AuditService auditService;

    @Before("within(org.nikita.vkpractisetask.controller.*)")
    public void saveRequestInDataBase() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        log.info("audit");
        Audit audit = new Audit();
        audit.setRequestTime(LocalDateTime.now());
        audit.setUsername(userDetails.getUsername());
        auditService.save(audit);
    }

}
