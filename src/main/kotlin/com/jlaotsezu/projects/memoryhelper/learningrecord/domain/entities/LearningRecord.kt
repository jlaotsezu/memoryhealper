package com.jlaotsezu.projects.memoryhelper.learningrecord.domain.entities

import com.fasterxml.jackson.annotation.JsonInclude
/*import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp*/
//import javax.persistence.*

//@Entity
//@Table(name = "learningrecord")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class LearningRecord(
        //@Id
       // @GeneratedValue(generator = "uuid2")
       // @GenericGenerator(name = "uuid2", strategy = "uuid2")
        var id: String = "",
        var question: String,
        var answer: String = "",
        var fields: String,
        var reviewTime: Int = 0,

       // @CreationTimestamp
        var created: Long = System.currentTimeMillis(),

       // @UpdateTimestamp
        var updated: Long = System.currentTimeMillis()
){
    constructor(): this("", "", "", "", 0, 0, 0)
}