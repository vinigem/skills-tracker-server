package com.vini.skillstracker;

import org.springframework.data.domain.AuditorAware;

/**
 * User Auditing class to get User name for audit data
 * @author Vinit Kumar
 *
 */
public class UserAuditing implements AuditorAware<String>{

    @Override
    public String getCurrentAuditor() {
        return AppConstant.SYSTEM;
    }

}