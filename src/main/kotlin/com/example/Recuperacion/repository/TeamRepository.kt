package com.example.Recuperacion.repository

import com.example.Recuperacion.entity.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamRepository: JpaRepository<Team, Long> {
    fun findById(id: Long?): Team
}