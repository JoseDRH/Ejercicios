package com.example.block11uploaddownloadfiles.application.repositoryFile;

import com.example.block11uploaddownloadfiles.application.file.model.EntityFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFile extends CrudRepository<EntityFile,Integer> {
}
