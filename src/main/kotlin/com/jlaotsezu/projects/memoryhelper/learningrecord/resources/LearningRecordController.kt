package com.jlaotsezu.projects.memoryhelper.learningrecord.resources

import com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities.LearningRecord
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
    @GetMapping("/learningRecord/{id}")
    fun getLearningRecord(@PathVariable("id") id: Long): ResponseEntity<LearningRecord>{
        val payload = learningRecordService.fetchById(id)
        return ResponseEntity(payload, HttpStatus.OK)
    }
    @GetMapping("/learningRecords/search")
    fun searchLearningRecords(@RequestParam("keyword") keyword: String): ResponseEntity<List<LearningRecord>>{
        val payload = learningRecordService.search(keyword)
        return ResponseEntity(payload, HttpStatus.OK)
    }
    @GetMapping("/learningRecords/page/{page}")
    fun getLearningRecords(@PathVariable("page") page: Int): ResponseEntity<List<LearningRecord>>{
        val payload = learningRecordService.fetch(page = page)
        return ResponseEntity(payload, HttpStatus.OK)
    }
    @PostMapping("/learningRecord/add")
    fun addLearningRecord(@RequestBody learningRecordVO: LearningRecordVO): ResponseEntity<Unit>{
        learningRecordService.insert(learningRecordVO.toEntity())
        return ResponseEntity(HttpStatus.CREATED)
    }
    @PutMapping("/learningRecord/update")
    fun updateLearningRecord(@RequestBody learningRecordVO: LearningRecordVO): ResponseEntity<Unit>{
        learningRecordService.update(learningRecordVO.toEntity())
        return ResponseEntity(HttpStatus.ACCEPTED)
    }
}