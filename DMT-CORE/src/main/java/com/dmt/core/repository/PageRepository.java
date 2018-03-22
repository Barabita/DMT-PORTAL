package com.dmt.core.repository;

import com.dmt.core.domain.general.Page;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author mali.sahin
 * @date 21-Mar-18
 */
@Repository
public interface PageRepository extends JpaRepository<Page, String>, JpaSpecificationExecutor {

    public Page findByName(String name);
}
