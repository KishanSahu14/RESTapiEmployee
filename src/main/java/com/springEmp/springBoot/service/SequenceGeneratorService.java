package com.springEmp.springBoot.service;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import com.springEmp.springBoot.entity.DbSequence;

import jakarta.annotation.PostConstruct;

@Service
public class SequenceGeneratorService {

	
	private MongoOperations mongoOperations;
	
	
	
	 public SequenceGeneratorService(MongoOperations mongoOperations) {
	        this.mongoOperations = mongoOperations;
	    }
	public int getSequenceNumber(String sequenceName) {
		
		Query query= new Query(Criteria.where("id").is(sequenceName));
		Update update = new Update().inc("seq", 1);
		
		DbSequence counter= mongoOperations
				.findAndModify(query,update, options().returnNew(true).upsert(true),DbSequence.class);
		
		return !Objects.isNull(counter) ? counter.getSeq(): 1;
		
		
		
		
	}
	
}
