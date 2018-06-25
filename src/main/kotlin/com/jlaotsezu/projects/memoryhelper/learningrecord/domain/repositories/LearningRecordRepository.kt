package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.repositories

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.LearningRecord
import java.util.*

interface LearningRecordRepository/*: JpaRepository<LearningRecord, String>*/{

   // @Query("select l from LearningRecord l where l.question like %?1% or l.answer like %?1% or l.fields like %?1%")
    fun findByKeyword(keyword: String): Iterable<LearningRecord>

    fun findAll(): Iterable<LearningRecord>

    fun findById(id: String): Optional<LearningRecord>

    fun save(learningRecord: LearningRecord): LearningRecord
}