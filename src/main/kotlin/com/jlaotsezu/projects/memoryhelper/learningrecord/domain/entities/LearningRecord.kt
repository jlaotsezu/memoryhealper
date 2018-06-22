package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities

import javax.persistence.*

@Entity
class LearningRecord(){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var learningrecord_id: Long = 0L
    var question: String = ""
    var answer: String = ""
    var fields: String = ""

    @OneToOne
    @JoinColumn(name = "rotabletime_id", unique = true, nullable = false, insertable = true, updatable = true)
    var time: RotableTime = RotableTime()

    constructor(id: Long, question: String, answer: String, fields: String, time: RotableTime): this() {
        this.learningrecord_id = id
        this.question = question
        this.answer = answer
        this.fields = fields
        this.time = time
    }
}

@Entity
class RotableTime (){

    var rotabletime_id: Long = 0L
    var startTime: Long = 0L
    var repeatedTime: Int = 0

    constructor(rotabletime_id: Long, startTime: Long, repeatedTime: Int): this() {
        this.rotabletime_id = rotabletime_id
        this.startTime = startTime
        this.repeatedTime = repeatedTime
    }


    fun next(){}
}