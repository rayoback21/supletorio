package com.example.Recuperacion.service

import com.example.Recuperacion.dto.RegisterDto
import com.example.Recuperacion.entity.UserEntity
import com.example.Recuperacion.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserSecurityService: UserDetailsService {
    @Autowired
    lateinit var userRepository: UserRepository
    @Override
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails? {
        val userEntity = userRepository.findByUsername(username)
            ?: throw
            UsernameNotFoundException(
                "User $username not found."
            )

        val roles: Array<String?> = userEntity.roles?.map {
                role -> role.roles }!!.toTypedArray()

        return User.builder()
            .username(userEntity.username)
            .password(userEntity.password)
            .roles(*roles)
            .accountLocked(userEntity.locked!!)
            .disabled(userEntity.disabled!!)
            .build()
    }
    fun register(registerDto: RegisterDto):UserEntity{
        val newUser = UserEntity()
        newUser.apply {
            username = registerDto.username
            password = BCryptPasswordEncoder().encode(registerDto.password)
            email = registerDto.email
            locked = false
            disabled = false
        }
        userRepository.save(newUser)
        return newUser
    }
}