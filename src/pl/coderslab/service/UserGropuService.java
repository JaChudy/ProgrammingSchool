package pl.coderslab.service;

import pl.coderslab.controller.UserGroupController;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.entity.UserGroup;

public class UserGropuService {



    public static void add(String newGroupName) throws Exception{
        UserGroup newUserGroup = new UserGroup();
        newUserGroup.setName(newGroupName);
        if(newUserGroup.getName().length() < 4){
           throw  new Exception("Group name must be at lest 4 characters long");
        }
        UserGroupDao.save(newUserGroup);

    }

    public static void edit(int groupId, String newGroupName) throws  Exception{
        if(newGroupName.length()<4){
            throw  new Exception("Group name must be at lest 4 characters long");
        }
        UserGroupDao.edit(groupId, newGroupName);
    }

    public static void delete(int groupId){
        UserGroupDao.delete(groupId);
    }

    public static void printAll() throws Exception{
        UserGroupDao.printAllFromTable();
    }
}
