import com.softserv.todolist.dao.DBConnection;
import com.softserv.todolist.dao.UserDao;
import com.softserv.todolist.entity.User;

import java.sql.Connection;

/**
 * Created by IRA on 19.06.2017.
 */
public class test {
    public static void main(String[] args) {
        Connection con = DBConnection.getInstance().getConnection();
        System.out.println(UserDao.INSTANCE.getUserByLoginAndPassword("petro","1111"));
      //  UserDao.INSTANCE.saveUser()
        User user = new User("dsa","dsa","wdq","dwq","dwq");
        System.out.println(user);

        System.out.println( user.getUserDTO());
    }

}
