package com.example.Recuperacion.controller

import com.example.Recuperacion.entity.Team
import com.example.Recuperacion.service.TeamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/team")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
class TeamController {

    @Autowired
    lateinit var teamService: TeamService

    @GetMapping
    fun list(): List<Team>{
        return teamService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Team {
        return teamService.listById(id)
    }

    @PostMapping
    fun save(@RequestBody team: Team): Team {
        return teamService.save(team)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody team: Team): ResponseEntity<Team> {
        return ResponseEntity(teamService.update(team), HttpStatus.OK)
    }

    @PatchMapping
    fun updateAddress(@RequestBody team: Team): ResponseEntity<Team> {
        return ResponseEntity(teamService.updateAddress(team), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        teamService.delete(id)
    }
}