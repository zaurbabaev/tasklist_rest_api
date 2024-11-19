package com.example.tasklist.domain.user;

import com.example.tasklist.domain.task.Task;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    Long id;
    String name;
    String username;
    String password;
    String passwordConfirmation;
    Set<Role> roles;
    List<Task> tasks;

}