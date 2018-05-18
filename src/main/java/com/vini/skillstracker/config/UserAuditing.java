package com.vini.skillstracker.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class UserAuditing implements AuditorAware<String>{

    @Override
    public String getCurrentAuditor() {
        return AppConstant.SYSTEM;
    }

}