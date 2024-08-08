package com.example.Recuperacion.service

import com.example.Recuperacion.entity.Team
import com.example.Recuperacion.repository.TeamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TeamService {
    @Autowired
    lateinit var teamRepository: TeamRepository

    fun list(): List<Team>{
        return teamRepository.findAll()
    }

    fun listById(id: Long): Team{
        return teamRepository.findById(id)
            .orElseThrow{ResponseStatusException(HttpStatus.NOT_FOUND,"El Colegio con el id $id no es correcto")}

    }
    fun save(team: Team): Team{
        return teamRepository.save(team)
    }
    fun update(team: Team): Team{
        try {
            teamRepository.findById(team.id)?: throw Exception("Client Not Found")
            return teamRepository.save(team)
        }catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun updateAddress(team: Team): Team? {
        try {
            var response =teamRepository.findById(team.id)
            response.apply {
                country= team.country
            }
            return teamRepository.save(response)
        } catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long) {
        if (teamRepository.existsById(id)) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "School with id $id not found")
        }
        teamRepository.deleteById(id)

    }
}