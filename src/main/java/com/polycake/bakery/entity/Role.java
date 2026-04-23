package com.polycake.bakery.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleID")
    private Long roleId;

    @Column(name = "RoleName", columnDefinition = "NVARCHAR(50)")
    private String roleName;

    public Role() {}

    public Long getRoleId() { return roleId; }
    public void setRoleId(Long roleId) { this.roleId = roleId; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
}