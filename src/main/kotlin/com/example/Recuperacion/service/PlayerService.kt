package com.example.Recuperacion.service

import com.example.Recuperacion.entity.Player
import com.example.Recuperacion.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PlayerService {
    @Autowired
    lateinit var playerRepository: PlayerRepository

    fun list(): List<Player> {
        return playerRepository.findAll()
    }

    fun listById(id: Long): Player {
        return playerRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "El Estudiante con el id $id no es correcto") }
    }

    fun save(student: Player): Player {
        return playerRepository.save(student)
    }

    fun update( player: Player): Player {
        try {
            playerRepository.findById(player.id) ?: throw Exception("Jugador no Encontrado")
            return playerRepository.save(player)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(player: Player): Player? {
        try {
            var response = playerRepository.findById(player.id)
            response.apply {
                positione = player.positione
            }
            return playerRepository.save(response)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        if (!playerRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id $id not found")
        }
        playerRepository.deleteById(id)
    }
}