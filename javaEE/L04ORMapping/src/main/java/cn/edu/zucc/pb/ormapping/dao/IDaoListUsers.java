package cn.edu.zucc.pb.ormapping.dao;

import java.util.List;

public interface IDaoListUsers<T> {
    List<T> getEntity(String key, String clazz);
}
