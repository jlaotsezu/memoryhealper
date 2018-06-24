package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.valueobjects

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.LearningRecord

data class LearningRecordVO(
        val question: String?,
        val answer: String?,
        val fields: String?
){
    var id: String = ""
    var reviewTime: Int = 0
    var created: Long = 0L
    var updated: Long = 0L
    constructor(learningRecord: LearningRecord): this(
            learningRecord.question,
            learningRecord.answer,
            learningRecord.fields
    ){
        id = learningRecord.id
        reviewTime = learningRecord.reviewTime
        created = learningRecord.created
        updated = learningRecord.updated
    }
}