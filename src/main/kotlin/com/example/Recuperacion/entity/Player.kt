package com.example.Recuperacion.entity

import jakarta.persistence.*

@Entity
@Table(name = "player")
class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    @Column(name = "full_name")
    var fullName: String? = null
    var age: String? = null
    var positione: String? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    var team: Team? = null
}