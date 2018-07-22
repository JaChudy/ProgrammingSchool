package pl.coderslab.dao;

import pl.coderslab.controller.UserGroupController;
import pl.coderslab.entity.UserGroup;
import pl.coderslab.service.DbService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserGroupDao {

    public static UserGroup findByName(String name) throws Exception{
        String querry = "Select * from user_group WHERE name = ?";
        List<String> params = new ArrayList<>();
        params.add(name);
        try {
            List<String[]> result = DbService.getData(querry, params, "ProgrammingSchool");

            if(result.size()!=0 ){
                UserGroup ug = new UserGroup();
                ug.setId(Integer.parseInt(result.get(0)[0]));
                ug.setName(result.get(0)[1]);
                return ug;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }



    public static void edit(int groupId, String newName){
        String querry = "UPDATE user_group SET name = ? Where id = ? ";
        List<String> params = new ArrayList<>();
        params.add(newName);
        params.add(String.valueOf(groupId));

        try {
            DbService.executeQuery(querry, params,"ProgrammingSchool");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void save(UserGroup userGroup) throws Exception{

        if(findByName(userGroup.getName()) != null)
            throw new Exception("Grupa istnieje");

        String querry = "Insert INTO user_group (`name`) VALUES (?)";
        List<String> params = new ArrayList<>();
        params.add(userGroup.getName());



        try {
            int newId = DbService.insertIntoDatabase(querry, params, "ProgrammingSchool");
            //uzupełnienie o id nadane przez bazę
            userGroup.setId(newId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void printAllFromTable() throws Exception{
        String querry = "SELECT * from user_group";
        List<String> params = new ArrayList<>();
        //params.add("user_group");
        try {
            List<String[]> results = DbService.getData(querry, params, "ProgrammingSchool");
            for(String[] result : results){
                System.out.println(Arrays.toString(result));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


//    public List<UserGroup> findAll(){
//
//    }
}
