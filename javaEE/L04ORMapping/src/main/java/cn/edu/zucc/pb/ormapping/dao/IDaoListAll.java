package cn.edu.zucc.pb.ormapping.dao;

import java.util.List;

public interface IDaoListAll<T> {
    List<T> listAllEntity(String clazz);
}
