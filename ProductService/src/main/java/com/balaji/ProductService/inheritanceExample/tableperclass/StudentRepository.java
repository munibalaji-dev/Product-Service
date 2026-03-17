package com.balaji.ProductService.inheritanceExample.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
