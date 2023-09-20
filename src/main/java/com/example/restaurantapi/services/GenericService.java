package com.example.restaurantapi.services;

import com.example.restaurantapi.models.AbstractEntity;
import com.example.restaurantapi.models.GenericEntity;
import com.example.restaurantapi.repositories.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public abstract class GenericService<T extends GenericEntity<T>>
{
        private final GenericRepository<T> repository;

        protected GenericService(GenericRepository<T> repository) {
            this.repository = repository;
        }

        public Page<T> getPage(Pageable pageable){
            return repository.findAll(pageable);
        }

        public T findById(Long id){
            return repository.findById(id).get();
        }
        @Transactional
        public T create(T newDomain){
            T dbDomain = newDomain.createNewInstance();
            return repository.save(dbDomain);
        }

        @Transactional
        public void delete(Long id){
            //check if object with this id exists
            if (repository.existsById(id))
                repository.deleteById(id);
        }
        @Transactional
        public T update(T updated){
            T dbDomain = findById(updated.getId());
            dbDomain.update(updated);

            return repository.save(dbDomain);
        }


}
