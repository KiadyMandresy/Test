package Service;
import Entity.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.*;
@Repository
public interface TokenFrontDAO extends MongoRepository<TokenFront, String>{
    public List<TokenFront> findByTokenAndDateExpireGreaterThan(String to,Date t);
    public void deleteByToken(String token);
}
