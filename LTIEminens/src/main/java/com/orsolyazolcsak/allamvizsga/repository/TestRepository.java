package com.orsolyazolcsak.allamvizsga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orsolyazolcsak.allamvizsga.model.Test;

import java.util.List;

@Repository
public interface TestRepository extends CrudRepository<Test, Long>{

	List<Test> findAll();

	Test findById(Long id);

	void deleteById(Long id);
}
