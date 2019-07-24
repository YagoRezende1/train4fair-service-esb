package de.fraunhofer.fit.train.persistence;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import de.fraunhofer.fit.train.model_v2.autogenerated.InternalId;

public interface IInternalIdRepository extends CrudRepository<InternalId, String>, QueryByExampleExecutor<InternalId> {

	@Query("{ '?0' : { $regex: ?1 } }")
	List<InternalId> findOneByQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<InternalId> findOneBySmampleQuery(String fieldStr,String cotent);
	
	@Query(value="{}", fields="{ '0' : ?1}")
	List<InternalId> findOneBySimpleQuery(String fieldStr,String cotent);

	@Query("{ ?0 : { $regex: ?1 } }")
	List<InternalId> findOneByRegexQuery(String fieldStr, String cotent);
	
	
}