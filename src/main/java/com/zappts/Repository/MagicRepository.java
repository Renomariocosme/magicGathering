package com.zappts.Repository;

import org.springframework.data.repository.CrudRepository;

import com.zappts.Models.MagicGatheringModel;

public interface MagicRepository extends CrudRepository<MagicGatheringModel, Long> {

	
}
