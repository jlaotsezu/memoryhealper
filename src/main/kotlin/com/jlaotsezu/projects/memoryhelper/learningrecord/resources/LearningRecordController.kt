package com.jlaotsezu.projects.memoryhelper.learningrecord.resources

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.services.LearningRecordService
import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.valueobjects.LearningRecordVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class LearningRecordController{
    @Autowired
    lateinit var learningRecordService: LearningRecordService
    @GetMapping("/learningrecords/{id}")
    fun getLearningRecord(@PathVariable("id") id: String): ResponseEntity<LearningRecordVO>{
        val payload = learningRecordService.fetchById(id)
        return ResponseEntity(payload, HttpStatus.OK)
    }
    @GetMapping("/learningrecords")
    fun getLearningRecords() = ResponseEntity(learningRecordService.fetchAll(), HttpStatus.OK)
    @PostMapping("/learningrecords/by-keyword")
    fun searchLearningRecords(@RequestBody learningRecordByKeywordRequest: LearningRecordByKeywordRequest): ResponseEntity<List<LearningRecordVO>>{
        val payload = learningRecordService.search(learningRecordByKeywordRequest.keyword)
        return ResponseEntity(payload, HttpStatus.OK)
    }
    @PostMapping("/learningrecords/by-page")
    fun getLearningRecords(@RequestBody learningRecordByPageRequest: LearningRecordByPageRequest): ResponseEntity<List<LearningRecordVO>>{
        val payload = learningRecordService.fetch(page = learningRecordByPageRequest.page)
        return ResponseEntity(payload, HttpStatus.OK)
    }
    @PutMapping("/learningrecords")
    fun addLearningRecord(@RequestBody learningRecordVO: LearningRecordVO): ResponseEntity<LearningRecordVO>{
        return ResponseEntity(learningRecordService.insert(learningRecordVO), HttpStatus.CREATED)
    }
    @PostMapping("/learningrecords")
    fun updateLearningRecord(@RequestBody learningRecordVO: LearningRecordVO): ResponseEntity<LearningRecordVO>{
        return ResponseEntity(learningRecordService.update(learningRecordVO), HttpStatus.ACCEPTED)
    }
}