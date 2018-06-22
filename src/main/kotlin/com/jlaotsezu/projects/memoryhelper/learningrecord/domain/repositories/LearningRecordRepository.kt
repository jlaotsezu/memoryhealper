package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.repositories

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.LearningRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LearningRecordRepository: JpaRepository<LearningRecord, Long>