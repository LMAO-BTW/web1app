package org.app.backend.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.util.Date
import java.util.UUID

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    val id: UUID,

    @Column(name = "name")
    val name: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "role")
    @Enumerated(EnumType.ORDINAL)
    val role: Role = Role.USER,

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    val createdAt: Date?,

    @CreationTimestamp
    @Column(name = "updated_at")
    val updatedAt: Date?

)
