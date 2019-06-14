package com.github.wz2cool.mdqvsother.jpa.dao;

import com.github.wz2cool.mdqvsother.jpa.model.entity.UserDO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.List;

@Service
public class UserCustomRepositoryImpl implements UserCustomRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<UserDO> getCustomUserList() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<UserDO> query = criteriaBuilder.createQuery(UserDO.class);
        Root<UserDO> root = query.from(UserDO.class);
        query.select(root);
        // List<Long> idList = Arrays.asList(new Long[]{1L, 2L, 3L});
        CriteriaBuilder.In<Long> inClause = criteriaBuilder.in(root.get("id"));
        inClause.in(1L);
        inClause.in(3L);
        return em.createQuery(query).getResultList();
    }
}
