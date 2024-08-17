package org.app.backend.services

import org.app.backend.model.User
import org.app.backend.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findAll() = userRepository.findAll()

    fun findById(id: UUID) = userRepository.findById(id)

    fun save(user: User) = userRepository.save(user)

    fun update(user: User) = userRepository.save(user)

}