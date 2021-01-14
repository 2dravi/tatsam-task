package com.tatsam.demo.priority.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

public class AppUserServiceImpl implements AppUserService{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Object findAppUserById(Long userID) {
        String sql= "SELECT n_user_id, " +
                "    c_first_name, " +
                "    c_last_name, " +
                "    c_email, " +
                "    c_city, " +
                "    n_age, " +
                "    mobile_number, " +
                "    t_created_at, " +
                "    t_lupdated_at " +
                "FROM tatsam.USER_DETAILS;";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("n_user_id",userID);
        return query.getSingleResult();
    }

    private String getSingleResultNull(Query query) {
        String ret = null;
        Object obj = getFirst(query).orElse((Object)null);
        if (obj != null) {
            ret = obj.toString();
        }

        return ret;
    }

    @NotNull
    private Optional getFirst(Query query) {
        return query.getResultList().stream().filter(Objects::nonNull).findFirst();
    }
}
