package org.app.backend.services

import org.app.backend.dtos.UserSaveInput
import org.app.backend.dtos.UserUpdateInput
import org.app.backend.model.Role
import org.app.backend.model.User
import org.app.backend.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findAll() = userRepository.findAll()

    fun findById(id: UUID): User? {
        return userRepository.findById(id).orElseGet(null)
    }

    fun save(user: UserSaveInput): User{
        val newUser = User(
            id = UUID.randomUUID(),
            name = user.name,
            email = user.email,
            password = user.password,
            Role.USER,
            null,
            null
        )
        return userRepository.save(newUser)
    }

    fun update(user: UserUpdateInput): User {
        val userToUpdate = userRepository.findById(user.id)
        if(!userToUpdate.isPresent){
            throw Exception("User not found")
        }

        val updatedUser = userToUpdate.get().copy(
            name = user.name,
            email = user.email
        )

        return userRepository.save(updatedUser)
    }

    fun delete(id: UUID): Boolean {
        val userToDelete = userRepository.findById(id)
        if(!userToDelete.isPresent){
            return false
        }

        userRepository.delete(userToDelete.get())

        return true
    }

}