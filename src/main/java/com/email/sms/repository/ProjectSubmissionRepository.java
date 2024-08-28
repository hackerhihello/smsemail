package com.email.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.email.sms.model.EmailRequest;

public interface ProjectSubmissionRepository extends JpaRepository<EmailRequest, Long> {
}
