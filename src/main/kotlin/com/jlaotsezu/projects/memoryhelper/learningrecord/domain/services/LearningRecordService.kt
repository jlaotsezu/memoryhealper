package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.services

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.LearningRecord
import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.valueobjects.LearningRecordVO


interface LearningRecordService{
    fun insert(record: LearningRecordVO): LearningRecordVO
    fun update(record: LearningRecordVO): LearningRecordVO
    fun search(keyword: String): List<LearningRecordVO>
    fun fetch(page: Int, pageSize: Int = 20): List<LearningRecordVO>
    fun fetchById(id: String): LearningRecordVO
    fun fetchAll(): List<LearningRecordVO>
}