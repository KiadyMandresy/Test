package Service;
import Entity.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;

    public interface TokkenAdminDAO extends MongoRepository<TokkenAdmin, String> {

        public List<TokkenAdmin> findAll();
    }

