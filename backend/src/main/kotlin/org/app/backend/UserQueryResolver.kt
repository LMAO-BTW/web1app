package org.app.backend

import org.app.backend.model.User
import org.app.backend.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller


@Controller
class UserQueryResolver(
    @Autowired private val userService: UserService
) {

    @QueryMapping
    fun findUsers(): List<User> {
        return userService.findAll()
    }
}