package Service;
import Entity.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.*;
    @Repository
    public interface TokkenAdminDAO extends MongoRepository<TokkenAdmin, String> {
        public List<TokkenAdmin> findAll();
        public List<TokkenAdmin> findByTokkenAndDateExpireGreaterThan(String to,Date t);
        public void deleteByTokken(String token);
    }

