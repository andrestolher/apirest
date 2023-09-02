package com.andres.app.apirest.Repository;

import com.andres.app.apirest.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Task,Long> {
}
