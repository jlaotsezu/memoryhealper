package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.repositories

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.LearningRecord
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class InMemLearningRecordRepositoryImpl : LearningRecordRepository{
    private val learningRecords: MutableMap<String, LearningRecord> = mutableMapOf()
    init{
        learningRecords["1"] = LearningRecord("1", "Q1", "A1", "F1")
        learningRecords["2"] = LearningRecord("2", "Q2", "A2", "F2")
        learningRecords["3"] = LearningRecord("3", "Q3", "A3", "F3")
        learningRecords["4"] = LearningRecord("4", "Q4", "A4", "F4")
        learningRecords["5"] = LearningRecord("5", "Q5", "A5", "F5")
    }
    override fun findByKeyword(keyword: String): Iterable<LearningRecord> {
        return learningRecords.values.filter{
            it.question.contains(keyword) || it.answer.contains(keyword) || it.fields.contains(keyword)
        }
    }

    override fun findAll(): Iterable<LearningRecord> {
        return learningRecords.values
    }

    override fun findById(id: String): Optional<LearningRecord> {
        return Optional.ofNullable(learningRecords[id])
    }

    override fun save(learningRecord: LearningRecord): LearningRecord {
        if(learningRecord.id.isBlank())
            learningRecord.id = UUID.randomUUID().toString()
        learningRecords[learningRecord.id] = learningRecord
        return learningRecord
    }
}