package com.dmt.web.util;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author mali.sahin
 * @date 28-Mar-18
 */
public class SearchPage<T extends Object> extends LazyDataModel<T> {
    private JpaRepository<T, String> repository;

    public SearchPage(JpaRepository<T, String> repository) {
        this.repository = repository;
    }

    public void setRowIndex(int rowIndex) {
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        } else
            super.setRowIndex(rowIndex % getPageSize());
    }


    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        this.setRowCount((int) repository.count());
        this.setPageSize(pageSize);
        if (sortOrder == SortOrder.UNSORTED || StringUtils.isBlank(sortField)) {
            PageRequest request = new PageRequest(first / pageSize, pageSize);
            return repository.findAll(request).getContent();
        } else {
            Sort sort = new Sort(sortOrder == SortOrder.ASCENDING ? Sort.Direction.ASC : Sort.Direction.DESC, sortField);
            PageRequest request = new PageRequest(first / pageSize, pageSize, sort);
            return repository.findAll(request).getContent();
        }
    }


}
