package com.orsolyazolcsak.allamvizsga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orsolyazolcsak.allamvizsga.model.Test;

@Repository
public interface TestRepository extends CrudRepository<Test, Long>{
	Test findByProblem(long problemId);
}
