package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.repositories

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.LearningRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface LearningRecordRepository: JpaRepository<LearningRecord, String>{
    //@Query("select l from LearningRecord l where ?1")
    //fun lateThan
}