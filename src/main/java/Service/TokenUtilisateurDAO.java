package Service;
import Entity.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.*;
    @Repository
public interface TokenUtilisateurDAO extends MongoRepository<TokenUtilisateur, String> {
    public List<TokenUtilisateur> findByTokenAndDateExpireGreaterThan(String to,Date t);
    public void deleteByToken(String token);
}
