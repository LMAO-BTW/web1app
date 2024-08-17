package org.app.backend.resolvers

import org.app.backend.dtos.UserSaveInput
import org.app.backend.dtos.UserUpdateInput
import org.app.backend.model.User
import org.app.backend.services.UserService
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller
import java.util.*

@Controller
class UserMutationResolver(private val userService: UserService) {

    @MutationMapping
    fun createUser(@Argument input: UserSaveInput): User {
        return userService.save(input)
    }

    @MutationMapping
    fun updateUser(@Argument input: UserUpdateInput): User {
        return userService.update(input)
    }

    @MutationMapping
    fun deleteUser(@Argument input: String): Boolean {
        val uuid = UUID.fromString(input)
        return userService.delete(uuid)
    }
}
