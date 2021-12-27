package Service;
import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
public class RegionService extends Region {
    public List<Region> getAll()
    {
        return select("select * from region");
    }
}
