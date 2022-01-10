package Service;
import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class NotificationsService extends NotificationSignalement{

    public List<NotificationSignalement> getListNotification(String util)
    {
        NotificationSignalement not=new NotificationSignalement();
        String req="select s.dateS as dateDebut,st.dateS as dateFin,n.id as idNotification ,st.id as idSignalement from notification n join SignalementTermine st  on n.idSignTermine=st.id join signalementValide sv on sv.id=st.idSignV join Signalement s on s.id=sv.idSign where s.idUtilisateur="+util;
        return not.select(req);
    }

}
