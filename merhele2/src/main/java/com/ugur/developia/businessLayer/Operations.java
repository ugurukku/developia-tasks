package com.ugur.developia.businessLayer;

import java.util.List;

public interface Operations<S> {

    List<S> getAll();

    S getById(Integer id);

    boolean  removeById(Integer id);

    boolean add(S entity);

    boolean updateById(S entity,Integer id);

}
