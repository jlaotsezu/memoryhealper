package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.services

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.LearningRecord
import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.repositories.LearningRecordRepository
import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.valueobjects.LearningRecordVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class LearningRecordServiceImpl : LearningRecordService {
    override fun fetchAll(): List<LearningRecordVO> {
        return learningRecordRepository.findAll().map{
            LearningRecordVO(it)
        }
    }

    @Autowired
    lateinit var learningRecordRepository: LearningRecordRepository

    override fun fetch(page: Int, pageSize: Int): List<LearningRecordVO> {
        return learningRecordRepository.findAll(PageRequest.of(page - 1, pageSize)).content.map {
            LearningRecordVO(it)
        }
    }

    override fun insert(record: LearningRecordVO) = LearningRecordVO(learningRecordRepository.save(
            LearningRecord(
                    question = record.question!!,
                    answer =  record.answer ?: "",
                    fields = record.fields!!
            )
    ))


    override fun update(record: LearningRecordVO): LearningRecordVO{
        val learningRecord = learningRecordRepository.findById(record.id).get()
        learningRecord.question = record.question ?: learningRecord.question
        learningRecord.answer = record.answer ?: learningRecord.answer
        learningRecord.fields = record.fields ?: learningRecord.fields
        learningRecord.reviewTime = if(record.reviewTime != 0) record.reviewTime else 0
        learningRecord.updated = System.currentTimeMillis()
        return LearningRecordVO(learningRecord)
    }


    override fun search(keyword: String): List<LearningRecordVO> {
        return learningRecordRepository.findByKeyword(keyword).map {
            LearningRecordVO(it)
        }
    }

    override fun fetchById(id: String) = LearningRecordVO(learningRecordRepository.findById(id).get())
}