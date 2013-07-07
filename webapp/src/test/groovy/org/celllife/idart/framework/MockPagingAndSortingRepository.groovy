package org.celllife.idart.framework

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-17
 * Time: 12h14
 */
class MockPagingAndSortingRepository<T, ID extends Serializable> implements PagingAndSortingRepository<T, ID> {

    @Override
    <S extends T> S save(S entity) {
        return null
    }

    @Override
    <S extends T> Iterable<S> save(Iterable<S> entities) {
        return null
    }

    @Override
    T findOne(ID id) {
        return null
    }

    @Override
    boolean exists(ID id) {
        return false
    }

    @Override
    Iterable<T> findAll() {
        return null
    }

    @Override
    Iterable<T> findAll(Iterable<ID> ids) {
        return null
    }

    @Override
    long count() {
        return 0
    }

    @Override
    void delete(ID id) {

    }

    @Override
    void delete(T entity) {

    }

    @Override
    void delete(Iterable<? extends T> entities) {

    }

    @Override
    void deleteAll() {

    }

    @Override
    Iterable<T> findAll(Sort sort) {
        return null
    }

    @Override
    Page<T> findAll(Pageable pageable) {
        return null
    }
}
