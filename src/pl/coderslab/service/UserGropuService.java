package pl.coderslab.service;

import pl.coderslab.controller.UserGroupController;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.entity.UserGroup;

public class UserGropuService {



    public static void add(String newGroupName) throws Exception{
        UserGroup newUserGroup = new UserGroup();
        newUserGroup.setName(newGroupName);
        if(newUserGroup.getName().length() < 4){
           throw  new Exception("Nazwa grupy musi być dłuższa niż 3 znaki");
        }
        UserGroupDao.save(newUserGroup);

    }
}
