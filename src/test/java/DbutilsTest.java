import com.MaYanzhen.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;


import java.sql.SQLException;
import java.util.List;

public class DbutilsTest {


    @Test
    public void tset() throws SQLException {
        System.out.println("----------");
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT * FROM usertable";
        List<User> query = qr.query(sql, new BeanListHandler<>(User.class));
        for (User u:  query) {
            System.out.println(u.toString());
        }
    }
}
