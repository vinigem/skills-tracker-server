package com.vini.skillstracker;

import org.springframework.data.domain.AuditorAware;

public class UserAuditing implements AuditorAware<String>{

    @Override
    public String getCurrentAuditor() {
        return AppConstant.SYSTEM;
    }

}