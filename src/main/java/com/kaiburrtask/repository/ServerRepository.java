package com.kaiburrtask.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.kaiburrtask.model.ServerObj;

public interface ServerRepository  extends MongoRepository<ServerObj,String>{

    List<ServerObj> findByName(String name);;
}
