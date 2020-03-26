package cn.edu.zucc.pb.ormapping.service;


import cn.edu.zucc.pb.ormapping.dao.*;
import cn.edu.zucc.pb.ormapping.entity.DepartmentEntity;
import cn.edu.zucc.pb.ormapping.entity.UserEntity;
import cn.edu.zucc.pb.ormapping.view.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService implements IDepartment{
    public static List<Department> departments=new ArrayList<Department>();

    @Override
    public boolean add(String ID,String name) {
        IDaoAdd dao = new DaoAdd();
        List<String> values = new ArrayList<String>();
        values.add(name);
        values.add(ID);
        boolean addResult = dao.addEntity(values, DepartmentEntity.class.getName());

        return addResult;
    }
    @Override
    public boolean delete(String ID) {
        IDaoDelete dao = new DaoDelete();
        boolean deleteResult = dao.deleteEntity(ID,DepartmentEntity.class.getName());

        return deleteResult;
    }
    @Override
    public boolean register(String depID, String uID) {
        IDAOUpdate dao= new DaoUpdate();
        boolean updateResult = dao.updateEntity(depID,uID);

        //无该部门
        return updateResult;
    }
    @Override
    public List<DepartmentEntity> list() {
        IDaoListAll<DepartmentEntity> dao = new DaoListAll<DepartmentEntity>();
        List<DepartmentEntity> list = dao.listAllEntity(DepartmentEntity.class.getName());
        return list;
    }

    @Override
    public List<UserEntity> listUser(String depID) {
        IDaoListUsers<UserEntity> dao = new DaoListUsers<UserEntity>();
        List<UserEntity> list = dao.getEntity(depID,UserEntity.class.getName());

        return list;
    }
}
