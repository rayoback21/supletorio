package com.example.Recuperacion.repository

import com.example.Recuperacion.entity.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository: JpaRepository<Player, Long> {
    fun findById(id: Long?): Player
}
