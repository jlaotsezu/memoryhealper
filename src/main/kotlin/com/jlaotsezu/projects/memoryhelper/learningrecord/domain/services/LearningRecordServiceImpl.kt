package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.services

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.LearningRecord
import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.repositories.LearningRecordRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class LearningRecordServiceImpl : LearningRecordService {
    override fun fetch(page: Int, pageSize: Int): List<LearningRecord> {
        return learningRecordRepository.findAll(PageRequest.of(page - 1, pageSize)).content
    }

    @Autowired
    lateinit var learningRecordRepository: LearningRecordRepository
    override fun insert(record: LearningRecord) {
       learningRecordRepository.save(record)
    }

    override fun update(record: LearningRecord) {
        learningRecordRepository.save(record)
    }

    override fun search(keyword: String): List<LearningRecord> {
        val learningRecord = LearningRecord()

        learningRecord.question = keyword
        learningRecord.answer = keyword
        learningRecord.fields = keyword

        return learningRecordRepository.findAll(Example.of(learningRecord))
    }

    override fun fetchById(id: Long): LearningRecord {
        return learningRecordRepository.findById(id).get()
    }
}