package com.example.Recuperacion.entity

import jakarta.persistence.*

@Entity
@Table(name = "team")
class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null
    var name: String? = null
    var country: String? = null

}