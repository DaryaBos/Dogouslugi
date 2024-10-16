package ru.practice.dogouslugi.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.practice.dogouslugi.model.DogoServiceEntity;

public interface DogoServiceRepository extends CrudRepository<DogoServiceEntity, Long> {
    @Query("from DogoServiceEntity kse where kse.id = :id")
    DogoServiceEntity findByServiceId(@Param("id") Integer id);

    @Query("select kse.title from DogoServiceEntity kse where kse.mnemonic = :mnemonic")
    String findTitleByServiceMnemonic(@Param("mnemonic") String mnemonic);
}
