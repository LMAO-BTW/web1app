package org.app.backend.dtos

import java.util.UUID


data class UserUpdateInput(
    val id: UUID,
    val name: String,
    val email: String
)

data class UserSaveInput(
    val name: String,
    val email: String,
    val password: String
)
