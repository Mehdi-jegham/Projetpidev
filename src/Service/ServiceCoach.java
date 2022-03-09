package Service;

import Entity.coach;
import Helpers.DbConnect;
import IService.IService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceCoach implements IService<coach> {

    Connection cnx;

    public ServiceCoach() {
        cnx = DbConnect.getConnect();
    }

    @Override
    public void add(coach coach) throws SQLException {



    }

    @Override
    public List<coach> read() throws SQLException {
        List<coach> ls = new ArrayList<coach>();
        Statement st = cnx.createStatement();
        String req = "select * from coach order by idcoach";
        ResultSet rs = st.executeQuery(req);
        while (rs.next()) {
            Integer idcoach = rs.getInt("idcoach");
            String nomprenom = rs.getString("nomprenom");
            //   LocalDate born = rs.getDate("born").toLocalDate();
            String email = rs.getString("email");

            Date dob = rs.getDate("dob");
            String image = rs.getString("image");

            coach p = new coach(idcoach,nomprenom,email, (java.sql.Date) dob,image);
            ls.add(p);
        }

        return ls;
    }

    @Override
    public void update(coach coach) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }
}
