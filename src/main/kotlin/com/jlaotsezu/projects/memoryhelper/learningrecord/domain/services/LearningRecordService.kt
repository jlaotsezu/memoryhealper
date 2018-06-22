package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.services

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.LearningRecord


interface LearningRecordService{
    fun insert(record: LearningRecord)
    fun update(record: LearningRecord)
    fun search(keyword: String): List<LearningRecord>
    fun fetch(page: Int, pageSize: Int = 20): List<LearningRecord>
    fun fetchById(id: Long): LearningRecord
}