package org.app.backend.repositories

import org.app.backend.main
import org.app.backend.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import java.util.UUID.randomUUID

@Repository
interface UserRepository : JpaRepository<User, UUID>
