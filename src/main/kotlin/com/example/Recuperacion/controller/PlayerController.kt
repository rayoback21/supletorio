package com.example.Recuperacion.controller

import com.example.Recuperacion.entity.Player
import com.example.Recuperacion.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/player")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class PlayerController {
    @Autowired
    lateinit var playerService: PlayerService

    @GetMapping
    fun list(): List<Player> {
        return playerService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable id: Long): Player {
        return playerService.listById(id)
    }

    @PostMapping
    fun save(@RequestBody player: Player): Player {
        return playerService.save(player)
    }

    @PutMapping
    fun update(@PathVariable id: Long?, @RequestBody player: Player?): ResponseEntity<Player> {
        val updatedPlayer = playerService.update(player!!)
        return ResponseEntity.ok(updatedPlayer)
    }

    @PatchMapping
    fun patch(@PathVariable id: Long?, @RequestBody player: Player?): ResponseEntity<Player> {
        val updatedPlayer = playerService.updateName(player!!)
        return ResponseEntity.ok(updatedPlayer)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        playerService.delete(id)

    }
}