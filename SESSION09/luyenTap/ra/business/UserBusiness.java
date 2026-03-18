package SESSION09.luyenTap.ra.business;

import SESSION09.KiemTra.PhysicalProduct;
import SESSION09.luyenTap.ra.entity.User;

import java.util.List;

public class UserBusiness {
    private List<User> userList;

    public UserBusiness(List<User> userList) {
        this.userList = userList;
    }

    //Các chức năng
    public List<User> displayInfo() {
        return userList;
    }

    //Add
    public void AddUser(User user) {
        userList.add(user);
    }
    //Update
    //Find
    public User findById(String id){
        for(User u: userList){
            if(u.getUserId().equalsIgnoreCase(id)){
                return u;
            }
        }
        return null;
    }
    //Delete
    //Filter
    //Sort
}
