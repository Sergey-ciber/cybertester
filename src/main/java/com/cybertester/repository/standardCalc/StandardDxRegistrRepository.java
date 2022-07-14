package com.cybertester.repository.standardCalc;

import com.cybertester.entity.standardCalc.StandardDxRegistrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StandardDxRegistrRepository extends JpaRepository<StandardDxRegistrEntity, Long> {

        // Получаем GUID_INPUT по RECORD_UQ документа
        @Query(value = "SELECT s.guidInput  FROM StandardDxRegistrEntity s WHERE s.recordUq = :reqordUq")
        String getGuid(@Param("reqordUq") long recordUq);


        // Получаем сущность по GUID_INPUT
        StandardDxRegistrEntity getFirstByGuidInput(String guidInput);

        // Получаем список сущностей по RECORD_UQ
        List<StandardDxRegistrEntity> getAllByRecordUq(Long recordU);



}
