package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.valueobjects

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.LearningRecord
import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.RotableTime

class LearningRecordVO(private val id: Long,
                       private val question: String,
                       private val answer: String,
                       private val fields: String,
                       private val time: RotableTimeVO): ValueObject<LearningRecord>{
    override fun toEntity(): LearningRecord {
        return LearningRecord(id, question, answer, fields, time.toEntity())
    }
}

class RotableTimeVO (private val id: Long,
                     private val startTime: Long,
                     private val repeatedTime: Int): ValueObject<RotableTime>{
    override fun toEntity(): RotableTime {
        return RotableTime(id, startTime, repeatedTime)
    }
}