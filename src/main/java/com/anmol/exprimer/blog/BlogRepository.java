package com.anmol.exprimer.blog;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, UUID>{

}
