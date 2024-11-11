package com.example.tasklist.web.controller;

import com.example.tasklist.domain.task.Task;
import com.example.tasklist.domain.user.User;
import com.example.tasklist.service.TaskService;
import com.example.tasklist.service.UserService;
import com.example.tasklist.web.dto.task.TaskDto;
import com.example.tasklist.web.dto.user.UserDto;
import com.example.tasklist.web.mappers.TaskMapper;
import com.example.tasklist.web.mappers.UserMapper;
import com.example.tasklist.web.validation.OnCreate;
import com.example.tasklist.web.validation.OnUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @PutMapping
    public UserDto update(@Validated(OnUpdate.class)
                          @RequestBody UserDto dto) {
        User user = userMapper.toEntity(dto);
        User updateUser = userService.update(user);
        return userMapper.toDto(updateUser);

    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTaskByUserId(@PathVariable Long id) {
        List<Task> taskList = taskService.getAllUserId(id);
        return taskMapper.toDto(taskList);
    }

    @PostMapping("/{id}/tasks")
    public TaskDto createTask(@PathVariable Long id,
                              @Validated(OnCreate.class)
                              @RequestBody TaskDto dto) {
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }
}
