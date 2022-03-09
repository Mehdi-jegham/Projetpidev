package Service;

import Entity.capsule;
import Helpers.DbConnect;
import IService.IService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceCapsule implements IService <capsule>{
    Connection cnx;

    public ServiceCapsule() {
        cnx = DbConnect.getConnect();
    }


    @Override
    public void add(capsule t) throws SQLException {

        Statement st = cnx.createStatement();
        String query = "insert into capsule (id,nomcapsule,typecapsule,longcapsule,programmecapsule,chemincapsule,cible,image)values(NULL, '" + t.getNomcapsule() + "', '" + t.getTypecapsule() + "', '" +t.getLongcasule()+ "', '" + t.getProgrammecapsule() +"','"+t.getChemincapsule()+ "','" + t.getCible() + "','" + t.getImage() + "')";
        st.executeUpdate(query);


    }

    @Override
    public List<capsule> read() throws SQLException {

        List<capsule> ls = new ArrayList<capsule>();
        Statement st = cnx.createStatement();
        String req = "select * from capsule order by id";
        ResultSet rs = st.executeQuery(req);
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String nomcapsule = rs.getString("nomcapsule");
            String typecapsule = rs.getString("typecapsule");
            String longcapsule = rs.getString("longcapsule");
            String programmecapsule = rs.getString("programmecapsule");
            String chemincapsule = rs.getString("chemincapsule");
            String cible = rs.getString("cible");
            String image = rs.getString("image");
            capsule p = new capsule(id,nomcapsule,typecapsule,longcapsule,programmecapsule,chemincapsule,cible,image);
            ls.add(p);
        }

        return ls;
    }

    @Override
    public void update(capsule t) throws SQLException {

        Statement st = cnx.createStatement();


        String query = "UPDATE `capsule` SET `nomcapsule` = '" + t.getNomcapsule() + "',`typecapsule` = '" + t.getTypecapsule() + "', `longcapsule` = '" + t.getLongcasule() + "', `programmecapsule` = '" + t.getProgrammecapsule() + "', `chemincapsule` = '" + t.getChemincapsule() + "', `cible` = '"
                + t.getCible() + "', `image` = '" + t.getImage() + "' WHERE `capsule`.`id` = " + t.getId() + " ;";
        st.executeUpdate(query);

    }

    @Override
    public void delete(Long id) throws SQLException {

        Statement st = cnx.createStatement();
        String query = "DELETE FROM `capsule` WHERE `capsule`.`id` = '" + id + "'";
        st.executeUpdate(query);

    }
}
