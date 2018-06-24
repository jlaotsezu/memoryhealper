package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.repositories

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.LearningRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface LearningRecordRepository: JpaRepository<LearningRecord, String>{
    @Query("select l from LearningRecord l where l.question like %?1% or l.answer like %?1% or l.fields like %?1%")
    fun findByKeyword(keyword: String): List<LearningRecord>
}