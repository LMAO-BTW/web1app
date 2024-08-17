package org.app.backend.resolvers

import org.app.backend.model.User
import org.app.backend.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import java.util.UUID


@Controller
class UserQueryResolver(
    @Autowired private val userService: UserService
) {

    @QueryMapping
    fun findUsers(): List<User> {
        return userService.findAll()
    }

    @QueryMapping
    fun findUserById(@Argument id: UUID): User? {
        return userService.findById(id)
    }
}